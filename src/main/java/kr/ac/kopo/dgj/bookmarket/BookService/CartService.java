package kr.ac.kopo.dgj.bookmarket.BookService;

import kr.ac.kopo.dgj.bookmarket.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
}
