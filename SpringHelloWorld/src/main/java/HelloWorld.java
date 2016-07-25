/**
 * Created by codecadet on 11/07/16.
 */
public class HelloWorld {

    private String name;

    public HelloWorld() {
    }

    public HelloWorld(String name) {
        this.name = name;
    }

    public void sayMyName() {
        System.out.println("Hello from " + name + ".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
