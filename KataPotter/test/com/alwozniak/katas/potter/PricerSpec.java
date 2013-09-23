package com.alwozniak.katas.potter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PricerSpec {

  private ShoppingCart cart;
  private Pricer pricer;

  @Before
  public void setUp() {
    cart = new ShoppingCart();
    pricer = new Pricer();
  }

  @Test
  public void priceForEmptyCartShouldBeZero() {
    // given
    ShoppingCart shoppingCart = new ShoppingCart();
    Pricer pricer = new Pricer();
    // when
    int price = pricer.price(shoppingCart);
    // then
    assertEquals(0, price);
  }

  @Test
  public void shouldPriceCartCorrectlyWhenHavingOneBook() {
    // given
    cart.addBook(ShoppingCart.BookType.FIRST, 1);
    // when
    int price = pricer.price(cart);
    // then
    assertEquals(800, price);
  }

  @Test
  public void shouldPriceCartCorrectlyWhenHavingManyBooksOfTheSameKind() {
    // given
    cart.addBook(ShoppingCart.BookType.FIRST, 5);
    // when
    int price = pricer.price(cart);
    // then
    assertEquals(4000, price);
  }

  @Test
  public void shouldApplyFivePercentDiscountForTwoKindsOfBooksInTheCart() {
    // given
    cart.addBook(ShoppingCart.BookType.FIRST, 1);
    cart.addBook(ShoppingCart.BookType.SECOND, 1);
    // when
    int price = pricer.price(cart);
    // then
    assertEquals(1520, price);
  }

  @Test
  public void shouldApplyTwentyPercentOfDiscountForFiveKindsOfBooksInTheCart() {
    // given
    cart.addBook(ShoppingCart.BookType.FIRST, 1);
    cart.addBook(ShoppingCart.BookType.SECOND, 1);
    cart.addBook(ShoppingCart.BookType.THIRD, 1);
    cart.addBook(ShoppingCart.BookType.FOURTH, 1);
    cart.addBook(ShoppingCart.BookType.FIFTH, 1);
    // when
    int price = pricer.price(cart);
    // then
    assertEquals(3200, price);
  }

  @Test
  public void shouldApplyFivePercentOfDiscountJustForTheSetOfDistinctBooks() {
    // given
    cart.addBook(ShoppingCart.BookType.FIRST, 1);
    cart.addBook(ShoppingCart.BookType.SECOND, 2);
    // when
    int price = pricer.price(cart);
    // then
    assertEquals(1520 + 800, price);
  }
}
