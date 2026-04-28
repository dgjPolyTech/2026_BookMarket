package kr.ac.kopo.dgj.bookmarket.BookService;

import kr.ac.kopo.dgj.bookmarket.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookService {
    List<Book> getAllBookList();

    Book getBookById(String bookId);

    List<Book> getBookListByCategory(String category);

    Set<Book> getBookListByFilter(Map<String, List<String>> filter); // 키:값 형태로 가져온다.

    void setNewBook(Book book);
}
