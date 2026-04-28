package kr.ac.kopo.dgj.bookmarket.repository;

import kr.ac.kopo.dgj.bookmarket.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {
    List<Book> getAllBookList(); // 리스트 형태의 Book 목록 객체를 가져온다.(도메인 객체의 Book을 가져와야함)
    Book getBookById(String bookId);
    List<Book> getBookListByCategory(String category);
    Set<Book> getBookListByFilter(Map<String, List<String>> filter); // Set은 중복을 허용하지 않는다는 의미.
    // Map은 <키워드, (그 키워드에 해당하는 데이터들)> 형태로 필터링된 데이터들을 가져오며, 그걸 Set형태로 반환하기 때문에 최종적으로 중복이 제거된 필터링 데이터들을 가져오게 됨.
    void setNewBook(Book book);
}
