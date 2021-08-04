package java8;

import java.util.Date;
import java.util.Optional;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-16 10:57
 **/
public class OptionalTest {

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        //orElse 不推荐  是否成功都会执行
        String name1 = Optional.of("String").orElse(getName()); //
        Optional<String> optionalS = Optional.of(name1);

        System.out.println(name1);
        Test test = null;
        Date date = Optional.ofNullable(test).map(Test::getDate).orElse(new Date());
        System.out.println(date);;

    }

    private static String getName() {
        System.out.println("do orElse");
        return "---------";
    }
}
