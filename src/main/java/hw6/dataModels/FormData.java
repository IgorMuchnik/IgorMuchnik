package hw6.dataModels;

import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;

import java.util.Arrays;
import java.util.List;

public class FormData {

  private Integer odd;
  private Integer even;
  private Colors colors;
  private Metals metals;
  private List<Vegetables> vegetables;
  private List<Elements> elements;

  public FormData(Integer odd, Integer even, Colors colors, Metals metals,
                  List<Vegetables> vegetables, List<Elements> elements) {
    this.odd = odd;
    this.even = even;
    this.colors = colors;
    this.metals = metals;
    this.vegetables = vegetables;
    this.elements = elements;
  }

  public Integer getOdd() {
    return odd;
  }

  public Integer getEven() {
    return even;
  }

  public String getColors() {
    return colors.toString();
  }

  public String getMetals() {
    return metals.toString();
  }

  public List<Vegetables> getVegetables() {
    return vegetables;
  }

  public List<Elements> getElements() {
    return elements;
  }

  public String getVegetablesAsString() {
    if (vegetables != null) {
      StringBuilder stringBuilder = new StringBuilder();
      vegetables.forEach(e -> stringBuilder.append(e.toString()));
      return stringBuilder.toString();
    }

    return null;
  }

  public String getElementsAsString() {
    if (elements != null) {
      StringBuilder stringBuilder = new StringBuilder();
      elements.forEach(e -> stringBuilder.append(e.toString()));
      return stringBuilder.toString();
    }

    return null;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    //set defaults below
    private Integer odd = 1;
    private Integer even = 2;
    private Colors colors = Colors.COLORS;
    private Metals metals = Metals.METALS;
    private List<Vegetables> vegetables = Arrays.asList(Vegetables.VEGETABLES);
    private List<Elements> elements = Arrays.asList();


    public Builder() {
    }

    public Builder setOdd(Integer odd) {
      this.odd = odd;
      return this;
    }

    public Builder setEven(Integer even) {
      this.even = even;
      return this;

    }

    public Builder setColors(Colors colors) {
      this.colors = colors;
      return this;

    }

    public Builder setMetals(Metals metals) {
      this.metals = metals;
      return this;

    }

    public Builder setVegetables(List<Vegetables> vegetables) {
      this.vegetables = vegetables;
      return this;

    }

    public Builder setElements(List<Elements> elements) {
      this.elements = elements;
      return this;

    }

    public FormData build() {
      return new FormData(odd, even, colors, metals, vegetables, elements);
    }
  }
}
