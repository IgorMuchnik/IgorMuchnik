package hw7.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetalsColorsDTO {
  public List<Integer> summary;
  public List<String> elements;
  public String color;
  public String metals;
  public List<String> vegetables;

  public static MetalsColors getMetalAndColorsFromDTO(MetalsColorsDTO dto) {
    return new MetalsColors(
      dto.summary.get(0),
      dto.summary.get(1),
      dto.elements,
      dto.color,
      dto.metals,
      dto.vegetables);
  }
}
