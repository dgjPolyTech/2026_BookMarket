package kr.ac.kopo.dgj.bookmarket.controller;

import kr.ac.kopo.dgj.bookmarket.BookService.BookService;
import kr.ac.kopo.dgj.bookmarket.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method= RequestMethod.GET)
    public String requestBookList(Model model) { // 모델 중 spring의 ui로 해야함.
        List<Book> listOfBooks = bookService.getAllBookList();
        model.addAttribute("bookList", listOfBooks);
        return "books";
    }
}