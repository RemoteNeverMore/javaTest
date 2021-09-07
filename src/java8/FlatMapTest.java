package java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-08-05 13:54
 **/
public class FlatMapTest {
    static List<Test> tests;
    static List<Test> tests1;
    static {
        tests = Arrays.asList(new Test("id1",Arrays.asList("1","2","3")),new Test("id2",Arrays.asList("21","22","23")),new Test("id3",Arrays.asList("31","32","33")));
        tests1 = Arrays.asList(new Test("id1,id11"),new Test("id2,id21"),new Test("id3"));
    }

    public static void main(String[] args) {
//        List<String> itemIds = tests.stream().map(Test::getList)
//                .flatMap(Collection::stream).collect(Collectors.toList());
//
//        List<String> ids = tests1.stream().map(Test::getIds)
//                .flatMap(x -> Arrays.stream(x.split(","))).collect(Collectors.toList());
//        System.out.println(itemIds);
//        System.out.println(ids);
        List<Test> list = new ArrayList<>();
        Test test = new Test();
        System.out.println(test);
        System.out.println(new Test());
        for (int i = 0; i < 10; i++) {
//            test = new Test(i+"V");

        }
        String[] departments = new String[] {"iERP", "iERP", "EIBU"};
// 抛出 IllegalStateException 异常
        Map<Integer, String> map = Arrays.stream(departments)
                .collect(Collectors.toMap(String::hashCode, str -> str));

    }

    static class Test{


        public Test() {

        }
//
//        @Override
//        public String toString() {
//            return "Test{" +
//                    "list=" + list +
//                    ", ids='" + ids + '\'' +
//                    '}';
//        }

        public Test(String ids, List<String> list) {
            this.list = list;
            this.ids = ids;
        }

        public Test(String ids) {
            this.ids = ids;
        }

        List<String> list;
        String ids;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public String getIds() {
            return ids;
        }

        public void setIds(String ids) {
            this.ids = ids;
        }
    }
}
