package kr.ac.kopo.dgj.bookmarket.repository;

import kr.ac.kopo.dgj.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList(); // 리스트 형태의 Book 목록 객체를 가져온다.(도메인 객체의 Book을 가져와야함)
}
