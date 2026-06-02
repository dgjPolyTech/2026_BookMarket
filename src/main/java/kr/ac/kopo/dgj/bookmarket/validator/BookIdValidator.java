package kr.ac.kopo.dgj.bookmarket.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.ac.kopo.dgj.bookmarket.BookService.BookService;
import kr.ac.kopo.dgj.bookmarket.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<BookId, String> {
    @Autowired
    private BookService bookService;


    @Override
    public void initialize(BookId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String bookId, ConstraintValidatorContext constraintValidatorContext) {
        // 도서ID(isBN) 중복되는 경우에 false(오류)
        // book 참조변수: bookid가 중복되면 참조값 변환, bookId가 존재하지 않으면 null값 반환
        Book book;

        try {
            book = bookService.getBookById(bookId);
        } catch(RuntimeException e) {
            return true;
        }

        // 중복되는 경우
        if(book != null) {
            return false;
        }

        return true;
    }
}
