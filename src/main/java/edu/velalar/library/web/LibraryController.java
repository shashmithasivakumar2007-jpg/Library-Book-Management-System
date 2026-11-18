package edu.velalar.library.web;
import edu.velalar.library.model.*; import edu.velalar.library.service.LibraryService; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller public class LibraryController {
 private final LibraryService svc; public LibraryController(LibraryService s){svc=s;}
 @GetMapping("/") public String home(Model m){m.addAttribute("books",svc.books());m.addAttribute("students",svc.students());m.addAttribute("loans",svc.loans());m.addAttribute("active",svc.active());m.addAttribute("overdue",svc.overdue());m.addAttribute("book",new Book());m.addAttribute("student",new Student());return "index";}
 @PostMapping("/books") public String book(@ModelAttribute Book b){svc.saveBook(b);return "redirect:/";}
 @PostMapping("/students") public String student(@ModelAttribute Student s){svc.saveStudent(s);return "redirect:/";}
 @PostMapping("/issue") public String issue(@RequestParam Long bookId,@RequestParam Long studentId,RedirectAttributes r){try{svc.issue(bookId,studentId);r.addFlashAttribute("msg","Book issued successfully.");}catch(Exception e){r.addFlashAttribute("msg",e.getMessage());}return "redirect:/";}
 @PostMapping("/return/{id}") public String giveBack(@PathVariable Long id,RedirectAttributes r){try{svc.giveBack(id);r.addFlashAttribute("msg","Book returned.");}catch(Exception e){r.addFlashAttribute("msg",e.getMessage());}return "redirect:/";}
 @GetMapping("/history/{id}") public String history(@PathVariable Long id,Model m){m.addAttribute("history",svc.history(id));return "history";}
}
