import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by codecadet on 11/07/16.
 */
public class SpringMain {

    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/spring-config.xml");

        HelloWorld h1 = context.getBean("hello", HelloWorld.class);
        HelloWorld h2 = context.getBean("world", HelloWorld.class);

        h1.sayMyName();
        h2.sayMyName();

    }
}
