package hw7.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetalsColors {
  private static final String LINE_SEPARATOR = ", ";

  private int oddSummaryNumber;
  private int evenSummaryNumber;
  private List<String> elements;
  private String color;
  private String metal;
  private List<String> vegetables;

  public List<String> getExpectedResults(){
    return Arrays.asList(
      "Summary: " + sum(),
      "Elements: " + String.join(LINE_SEPARATOR, elements),
      "Color: " + color,
      "Metal: " + metal,
      "Vegetables: " + String.join(LINE_SEPARATOR, vegetables));
  }

  private int sum() {
    return (oddSummaryNumber + evenSummaryNumber);
  }
}
