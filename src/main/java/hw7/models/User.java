package hw7.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
  public static final User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

  private String login;
  private String password;
  private String fullName;
}
