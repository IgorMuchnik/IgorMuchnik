package hw4.dataModels;

public class User {

  private String name;
  private String password;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String name;
    private String password;

    Builder() {
    }

    public Builder setName(String username) {
      this.name = username;
      return this;
    }

    public Builder setPassword(String password) {
      this.password = password;
      return this;
    }

    public User build() {
      return new User(name, password);
    }
  }
}
