package reflect;

public class TestObj {
    private Integer age;
    private String name;

    public TestObj(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
