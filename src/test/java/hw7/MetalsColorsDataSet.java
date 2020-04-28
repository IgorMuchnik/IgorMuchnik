package hw7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw7.models.MetalsColors;
import hw7.models.MetalsColorsDTO;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class MetalsColorsDataSet {
  private static final String PATH = "src\\test\\resources\\hw7\\JDI_ex8_metalsColorsDataSet.json";

  @DataProvider(name = "dataset")
  public Object[] getData() {
    ArrayList<MetalsColors> list = new ArrayList<>();
    HashMap<String, MetalsColorsDTO> map = getMapFromFile(PATH);
    for (MetalsColorsDTO value : map.values()) {
      list.add(MetalsColorsDTO.getMetalAndColorsFromDTO(value));
    }
    return list.toArray();
  }

  private HashMap<String, MetalsColorsDTO> getMapFromFile(String path) {
    HashMap<String, MetalsColorsDTO> map = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      map = mapper.readValue(new File(path), new TypeReference<HashMap<String, MetalsColorsDTO>>() {
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    return map;
  }
}
