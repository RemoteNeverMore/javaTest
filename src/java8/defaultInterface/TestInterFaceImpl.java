package java8.defaultInterface;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-23 15:35
 **/
public class TestInterFaceImpl implements TestInterFace {


    @Override
    public void plus() {

    }

    public static void main(String[] args) {
        TestInterFace testInterFace = new TestInterFaceImpl();
        testInterFace.add(100);
    }
}
