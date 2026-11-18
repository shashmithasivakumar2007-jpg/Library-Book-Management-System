| ID | Input / action | Expected result | Actual result |
|---|---|---|---|
| TC01 | Add valid book | Book saved | Passed |
| TC02 | Register unique student | Student saved | Passed |
| TC03 | Issue available book | Loan created; stock reduced | Passed |
| TC04 | Issue book with zero stock | Request rejected | Passed |
| TC05 | Return active loan | Return date saved; stock increased | Passed |
| TC06 | Return same loan twice | Second return rejected | Passed |
| TC07 | View overdue loans | Overdue loan displayed | Passed |
| TC08 | Run Python analysis | CSV and three charts generated | Passed |
| TC09 | View student history | Borrowing history displayed | Passed |
| TC10 | View available books | Inventory displayed correctly | Passed |