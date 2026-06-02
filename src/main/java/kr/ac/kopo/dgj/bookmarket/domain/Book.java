package kr.ac.kopo.dgj.bookmarket.domain;

import jakarta.validation.constraints.*;
import kr.ac.kopo.dgj.bookmarket.validator.BookId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class Book {
    @BookId
    @Pattern(regexp = "isbn[1-9]+", message = "{Pattern.book.bookId}")
    private String bookId; // 도서 번호

    @Size(min = 4, max = 50, message = "{Size.book.name}")
    private String name; // 도서명

    @Min(value = 0, message = "{Min.book.unitPrice}")
    @Digits(integer = 8, fraction = 2, message = "{Digits.book.unitPrice}") //최대 8자리, 소수점은 둘째자리까지.
    @NotNull(message = "{NotNull.book.unitPrice}")
    private BigDecimal unitPrice; // 도서 가격(

    private String author; // 저자명
    private String description; // 도서 설명글
    private String publisher; // 출판사
    private String category; // 분류
    private long unitsInStock; // 재고량
    private String releaseDate; // 출판일
    private String condition; // 신규도서, 중고도서, E-BOOK
    private String fileName; // 도서 이미지 파일 이름
    private MultipartFile bookImage; // 도서 이미지 파일 객체
}
