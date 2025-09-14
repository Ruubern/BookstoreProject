package hh.sof003.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof003.bookstore.domain.Book;
import hh.sof003.bookstore.domain.BookRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookstoreController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/addbook")
    public String getMethodName(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id));
        return "editbook";
    }

}
    
    
