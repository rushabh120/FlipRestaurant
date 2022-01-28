package model;

public class User {

    private String userName;
    private UserLevel level;

    public User(String userName) {
        this.userName = userName;
        this.level = UserLevel.LEVEL1;
    }

    public String getUserName() {
        return userName;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }
}
