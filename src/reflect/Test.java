package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args)throws Exception {
        Class aClass = TestObj.class;

        Constructor con = aClass.getConstructor(Integer.class);
        Object obj = con.newInstance(6);
        Field[] fields = aClass.getDeclaredFields();
        //获取公共属性
        Field[] publicFields = aClass.getFields();
        //获取所有的私有属性
        for (Field field:fields) {
            field.setAccessible(true);
            System.out.println("属性值---"+field.getName());
//            Object var = field.get(field.getName());
            Object var= field.get(obj);
            System.out.println("属性值为---"+var);
        }

//        Field name = aClass.getDeclaredField("age");
////设置为true才能获取私有属性
//        name.setAccessible(true);
//        Object value2= name.get(obj);
//        System.err.println("私有指定属性值："+value2);
        //获取公共方法
        Method[] publicMethod = aClass.getMethods();
        //获取私有方法
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m: methods) {
            m.setAccessible(true);
            System.out.println("属性方法名称---"+m.getName());
            if("setAge".equals(m.getName())){
                m.invoke(obj,12);
            }
        }
        Field field = aClass.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println(field.get(obj));
    }

}
