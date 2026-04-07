package kr.ac.kopo.dgj.bookmarket.controller;

import kr.ac.kopo.dgj.bookmarket.BookService.BookService;
import kr.ac.kopo.dgj.bookmarket.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/books") // 루트 url
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(method= RequestMethod.GET)
    public String requestBookList(Model model) { // 모델 중 spring의 ui로 해야함.
        List<Book> listOfBooks = bookService.getAllBookList();
        model.addAttribute("bookList", listOfBooks);
        return "books";
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model){
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model){
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
        model.addAttribute("bookList", booksByCategory);

        return "books";
    }

    @GetMapping("/all") // all 사용 시 모든 책 가져옴.
    public ModelAndView requestAllBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> list = bookService.getAllBookList();
        modelAndView.addObject("bookList", list);
        modelAndView.setViewName("books");

        return modelAndView;
    }
}