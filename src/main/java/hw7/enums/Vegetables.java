package hw7.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Vegetables {
  CUCUMBER("Cucumber"),
  TOMATO("Tomato"),
  VEGETABLES("Vegetables"),
  ONION("Onion");

  private final String vegetable;
}
