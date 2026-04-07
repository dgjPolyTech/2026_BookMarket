package kr.ac.kopo.dgj.bookmarket.repository;

import kr.ac.kopo.dgj.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository{ // bookRepository 인터페이스를 사용하는 만큼, 인터페이스에 구현된 메소드를 모두 구현해야 한다.
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() { // 이런 생성자는 alt+insert로 간단히 추가 가능하다.
        Book book1 = new Book();
        book1.setBookId("isbn1001");
        book1.setName("스프링부트 완전 정복");
        book1.setDescription("ㅋㅋㅋㅋㅋ");
        book1.setPublisher("길벗 캠퍼스");
        book1.setCategory("IT전문서");
        book1.setAuthor("송미영");
        book1.setUnitPrice(new BigDecimal(35000));
        book1.setReleaseDate("2024/12/31");

        Book book2 = new Book();
        book2.setBookId("isbn1002");
        book2.setName("데이터베이스 개론");
        book2.setDescription("ㅎㅎㅎㅎㅎ");
        book2.setPublisher("한빛 아카데미");
        book2.setCategory("IT교육교재");
        book2.setAuthor("이연희");
        book2.setUnitPrice(new BigDecimal(25000));
        book2.setReleaseDate("2022/01/15");

        Book book3 = new Book();
        book3.setBookId("isbn1003");
        book3.setName("자바자바");
        book3.setDescription("ㅇㅇㅇㅇㅇ");
        book3.setPublisher("한빛 아카데미");
        book3.setCategory("IT교육교재");
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

    @Override
    public Book getBookById(String bookId) {
        // book 객체를 null 값으로 선언해둔다.
        Book book = null;

        // book 목록을 인핸스드 for문으로 하나하나 찾는다.
        for (Book searchBook: listOfBooks) {
            if (searchBook != null && searchBook.getBookId() != null && searchBook.getBookId().equals(bookId)) {
                book = searchBook; // book을 찾았으면, 위에서 선언한 book 객체에 넣는다.
                break; // break로 빠져나간다.
            }
        }

        if(book == null) {
            // book을 찾지 못했으면, 목록에 없다는 소리이므로 강제로 오류를 발생시킨다.
            throw new IllegalArgumentException("도서ID가 "+bookId+"인 도서를 찾을 수가 없습니다.");
        }

        return book;
    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<Book>();

        for(Book searchBook : listOfBooks) {
            if(category.equalsIgnoreCase(searchBook.getCategory()))
                booksByCategory.add(searchBook);
        }

        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<String> booksByFilter = filter.keySet();

        if(booksByFilter.contains("publisher")) {
            for (String publisherName : filter.get("publisher")) {
                for(Book searchBook : listOfBooks) {
                    if(publisherName.equalsIgnoreCase(searchBook.getPublisher())){
                        booksByPublisher.add(searchBook);
                    }
                }
            }
        }

        if(booksByFilter.contains("category")) {
            for (String category : filter.get("category")) {
                List<Book> list = getBookListByCategory(category);
                booksByCategory.addAll(list);
            }
        }

        booksByCategory.retainAll(booksByPublisher);

        return booksByCategory;
    }
}
