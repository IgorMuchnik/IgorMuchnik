package hw6;

import java.util.Objects;

public class JDIUser {
  private String numberType;
  private String user;
  private String description;

  public JDIUser(String numberType, String user, String description) {
    this.numberType = numberType;
    this.user = user;
    this.description = description;
  }

  public void setNumberType(String numberType) {
    this.numberType = numberType;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "JdiUser{" +
      "numberType='" + numberType + '\'' +
      ", user='" + user + '\'' +
      ", description='" + description + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JDIUser jdiUser = (JDIUser) o;
    return Objects.equals(numberType, jdiUser.numberType) &&
      Objects.equals(user, jdiUser.user) &&
      Objects.equals(description, jdiUser.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberType, user, description);
  }
}
