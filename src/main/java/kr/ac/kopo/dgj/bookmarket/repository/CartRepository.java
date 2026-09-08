package kr.ac.kopo.dgj.bookmarket.repository;

import kr.ac.kopo.dgj.bookmarket.domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
}
