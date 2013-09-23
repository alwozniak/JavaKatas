package com.alwozniak.katas.potter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartSpec {

  private ShoppingCart shoppingCart;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();
  }

  @Test
  public void emptyBasketShouldHaveZeroBooks() {
    // given
    // when
    int numberOfBooks = shoppingCart.getNumberOfBooks();
    // then
    assertEquals(0, numberOfBooks);
  }

  @Test
  public void thereShouldBeOneBookOfFirstKindAfterAdding() {
    // given
    shoppingCart.addBook(ShoppingCart.BookType.FIRST, 1);
    // when
    int numberOfBooks = shoppingCart.getNumberOfBooks();
    // then
    assertEquals(1, numberOfBooks);
  }

  @Test
  public void thereShouldBeFiveBooksAfterAddingOneOfEachKind() {
    // given
    shoppingCart.addBook(ShoppingCart.BookType.FIRST, 1);
    shoppingCart.addBook(ShoppingCart.BookType.SECOND, 1);
    shoppingCart.addBook(ShoppingCart.BookType.THIRD, 1);
    shoppingCart.addBook(ShoppingCart.BookType.FOURTH, 1);
    shoppingCart.addBook(ShoppingCart.BookType.FIFTH, 1);
    // when
    int numberOfBooks = shoppingCart.getNumberOfBooks();
    // then
    assertEquals(5, numberOfBooks);
  }

  @Test
  public void shouldHaveProperNumberOfBookTypes() {
    // given
    shoppingCart.addBook(ShoppingCart.BookType.FIFTH, 4);
    shoppingCart.addBook(ShoppingCart.BookType.FIRST, 3);
    // when
    int numberOfBooks = shoppingCart.getNumberOfBooks();
    int numberOfBookTypes = shoppingCart.getNumberOfPresentBookTypes();
    // then
    assertEquals(7, numberOfBooks);
    assertEquals(2, numberOfBookTypes);
  }

  @Test
  public void shouldAddBooksIncrementally() {
    // given
    shoppingCart.addBook(ShoppingCart.BookType.FIRST, 2);
    shoppingCart.addBook(ShoppingCart.BookType.FIRST, 3);
    // when
    int numberOfBooks = shoppingCart.getNumberOfBooks();
    // then
    assertEquals(5, numberOfBooks);
  }
}
