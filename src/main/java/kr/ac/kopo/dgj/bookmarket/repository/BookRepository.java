package kr.ac.kopo.dgj.bookmarket.repository;

import kr.ac.kopo.dgj.bookmarket.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {
    List<Book> getAllBookList(); // 리스트 형태의 Book 목록 객체를 가져온다.(도메인 객체의 Book을 가져와야함)

    Book getBookById(String bookId);

    List<Book> getBookListByCategory(String category);

    Set<Book> getBookListByFilter(Map<String, List<String>> filter); // 키:값 형태로 가져온다.
    // String, List<String> 이라는 건 Stirng이라고 이름 붙여진 List 데이터(String)를 가져온다는 것.
}
