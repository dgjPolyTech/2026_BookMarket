package kr.ac.kopo.dgj.bookmarket.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryException extends RuntimeException{
    private String errorMessage;

    public CategoryException() {
        this.errorMessage = "요청한 도서 카테고리를 찾을 수 없습니다.";
    }
}
