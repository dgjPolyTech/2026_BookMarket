package kr.ac.kopo.dgj.bookmarket.repository;

import kr.ac.kopo.dgj.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository{ // bookRepository 인터페이스를 사용하는 만큼, 인터페이스에 구현된 메소드를 모두 구현해야 한다.
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() { // 이런 생성자는 alt+insert로 간단히 추가 가능하다.
        Book book1 = new Book();
        book1.setBookId("isbn1001");
        book1.setName("스프링부트 완전 정복");
        book1.setDescription("ㅋㅋㅋㅋㅋ");
        book1.setPublisher("길벗 캠퍼스");
        book1.setCategory("IT 전문서");
        book1.setAuthor("송미영");
        book1.setUnitPrice(new BigDecimal(35000));
        book1.setReleaseDate("2024/12/31");

        Book book2 = new Book();
        book2.setBookId("isbn1002");
        book2.setName("데이터베이스 개론");
        book2.setDescription("ㅎㅎㅎㅎㅎ");
        book2.setPublisher("한빛 아카데미");
        book2.setCategory("IT 교육교재");
        book2.setAuthor("이연희");
        book2.setUnitPrice(new BigDecimal(25000));
        book2.setReleaseDate("2022/01/15");

        Book book3 = new Book();
        book3.setBookId("isbn1003");
        book3.setName("자바자바");
        book3.setDescription("ㅇㅇㅇㅇㅇ");
        book3.setPublisher("한빛 아카데미");
        book3.setCategory("IT 교육교재");
        book1.setAuthor("도경진");
        book3.setUnitPrice(new BigDecimal(125000));
        book3.setReleaseDate("2025/03/17");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }
}
