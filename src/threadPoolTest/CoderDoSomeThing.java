package threadPoolTest;

public class CoderDoSomeThing {

    private String name;
    private String doSomeThing;

    public CoderDoSomeThing(String name, String doSomeThing) {
        this.name = name;
        this.doSomeThing = doSomeThing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoSomeThing() {
        return doSomeThing;
    }

    public void setDoSomeThing(String doSomeThing) {
        this.doSomeThing = doSomeThing;
    }

    @Override
    public String toString() {
        return "CoderDoSomeThing{" +
                "name='" + name + '\'' +
                ", doSomeThing='" + doSomeThing + '\'' +
                '}';
    }
}