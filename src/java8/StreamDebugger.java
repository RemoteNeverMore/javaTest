package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDebugger {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//        list.stream()
//                .filter(o->o%2==0)
//                .map(o->o*3)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        groupbyAndBigdecimalSum();
    }



    private static void groupbyAndBigdecimalSum(){
        List<Test> tests = Arrays.asList(new Test("1",new BigDecimal(2),3),new Test("1",new BigDecimal(2),3), new Test("11",new BigDecimal(12),33));
        Map<String, BigDecimal> orderMoneyGroup =
                tests.stream().collect(
                        Collectors.groupingBy(Test::getName,
                                Collectors.mapping(Test::getValue,
                                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
    }
    private static void groupbyAndintSum(){
        List<Test> tests = Arrays.asList(new Test("1",new BigDecimal(2),3), new Test("11",new BigDecimal(12),33));
        Map<String, Integer> orderMoneyGroup =
                tests.stream().collect(
                        Collectors.groupingBy(Test::getName,
                                Collectors.summingInt(o-> o.getValue().intValue())
                        )
                );
    }


    private static void split(){
        List<Test> tests = Arrays.asList(new Test("1",new BigDecimal(2),3),new Test("1",new BigDecimal(2),3), new Test("11",new BigDecimal(12),33));
        //按照名称和var分组然后 将name 用，隔开
        Map<String, String> itemIdsMap =
                tests.stream().collect(Collectors.toMap(o -> (o.getName()+ o.getVar()),
                        Test::getName, (v1, v2) -> v1 + "," + v2));
    }


}
