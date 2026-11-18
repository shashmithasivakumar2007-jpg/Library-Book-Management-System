
import os
from pathlib import Path

import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sqlalchemy import create_engine, text
from sqlalchemy.engine import URL

# Database configuration
u = os.getenv("DB_USER", "library_reader")
p = os.getenv("DB_PASSWORD")
host = os.getenv("DB_HOST", "junction.proxy.rlwy.net")
port = int(os.getenv("DB_PORT", "55563"))
database = os.getenv("DB_NAME", "library_db")

# Database connection
connection_url = URL.create(
    drivername="mysql+pymysql",
    username=u,
    password=p,
    host=host,
    port=port,
    database=database
)

engine = create_engine(connection_url)

# Fetch library transaction data
q = text("""
    SELECT
        l.id AS loan_id,
        s.roll_number,
        s.name AS student_name,
        b.title,
        b.category,
        l.issue_date,
        l.due_date,
        l.return_date
    FROM loans l
    JOIN students s ON s.id = l.student_id
    JOIN books b ON b.id = l.book_id
""")

df = pd.read_sql(
    q,
    engine,
    parse_dates=["issue_date", "due_date", "return_date"]
)

if df.empty:
    print("No loan records yet. Issue books in the web app and run again.")
    raise SystemExit

# Clean and prepare data
df = df.drop_duplicates("loan_id").copy()
df["category"] = df["category"].fillna("Unknown")
df["month"] = df["issue_date"].dt.to_period("M").astype(str)

df["overdue"] = (
    df["return_date"].isna()
    & (df["due_date"].dt.date < pd.Timestamp.today().date())
)

# Create output folder
out = Path("visualizations")
out.mkdir(exist_ok=True)

# Save cleaned transaction data
df.to_csv(out / "cleaned_transactions.csv", index=False)

# Set chart style
sns.set_theme(style="whitegrid")

# 1. Borrowing by category
plt.figure(figsize=(8, 5))
sns.countplot(
    data=df,
    y="category",
    order=df["category"].value_counts().index
)
plt.title("Borrowing by Category")
plt.tight_layout()
plt.savefig(out / "category_borrowing.png", dpi=150)
plt.close()

# 2. Monthly borrowing trend
monthly = df.groupby("month").size().reset_index(name="issues")

plt.figure(figsize=(8, 5))
sns.lineplot(data=monthly, x="month", y="issues", marker="o")
plt.xticks(rotation=35)
plt.title("Monthly Borrowing Trend")
plt.tight_layout()
plt.savefig(out / "monthly_trend.png", dpi=150)
plt.close()

# 3. Most borrowed books
popular = (
    df["title"]
    .value_counts()
    .head(10)
    .rename_axis("title")
    .reset_index(name="issues")
)

plt.figure(figsize=(8, 5))
sns.barplot(data=popular, y="title", x="issues")
plt.title("Most Borrowed Books")
plt.tight_layout()
plt.savefig(out / "popular_books.png", dpi=150)
plt.close()

# Display results
print("Charts and cleaned data saved in:", out.resolve())
print("Overdue active loans:", int(df["overdue"].sum()))

engine.dispose()
