package example;

public class User {
    private String name;

    private int age;

    private float height;
    private float width;

    public User(String name, int age, float height, float width) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.width = width;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUserInfo() {
        return "name: " + name + "(" + age + ")";
    }
}
