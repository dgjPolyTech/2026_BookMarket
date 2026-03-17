package kr.ac.kopo.dgj.bookmarket.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter
@Getter
public class Book {
    private String bookId; // 도서 번호
    private String name; // 도서명
    private BigDecimal unitPrice; // 도서 가격(
    private String author; // 저자명
    private String description; // 도서 설명글
    private String publisher; // 출판사
    private String category; // 분류
    private long unitsInStock; // 재고량
    private String releaseDate; // 출판일
    private String condition; // 신규도서, 중고도서, E-BOOK
}
