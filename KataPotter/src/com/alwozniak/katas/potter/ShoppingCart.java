package com.alwozniak.katas.potter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

  public enum BookType {FIRST, SECOND, THIRD, FOURTH, FIFTH}
  private Map<BookType, Integer> books = new HashMap<>();

  public void addBook(BookType bookType, int amount) {
    if (books.get(bookType) == null) {
      books.put(bookType, 0);
    }
    books.put(bookType, books.get(bookType) + amount);
  }

  public int getNumberOfBooks() {
    Collection<Integer> values = books.values();
    int sum = 0;
    for (int value : values) {
      sum += value;
    }
    return sum;
  }

  public int getNumberOfPresentBookTypes() {
    return books.keySet().size();
  }
}
