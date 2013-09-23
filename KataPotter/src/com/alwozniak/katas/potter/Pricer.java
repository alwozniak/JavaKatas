package com.alwozniak.katas.potter;

public class Pricer {

  public int price(ShoppingCart cart) {
    int numberOfBookTypes = cart.getNumberOfPresentBookTypes();
    int discount = calculateDiscount(cart.getNumberOfPresentBookTypes());

    int basePrice = 800 * cart.getNumberOfBooks();
    return basePrice * (100 - discount) / 100;
  }

  private int calculateDiscount(int numberOfTypes) {
    return 5 * (numberOfTypes - 1);
  }
}
