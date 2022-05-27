package threadPoolTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: wangchao
 * @create: 2022-05-18 09:23
 **/
public class OrderThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService richService = Executors.newFixedThreadPool(1);
//        KeyAffinityExecutor
        ExecutorService singleDogService = Executors.newFixedThreadPool(1);
        Map<String,ExecutorService> serviceMap = new HashMap<>();
        serviceMap.put("富贵",richService);
        serviceMap.put("旺财",singleDogService);

        List<CoderDoSomeThing> coderDoSomeThingList = new ArrayList<>();

        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "启动Idea"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "搞数据库,连tomcat,crud一顿输出"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "嘴角疯狂上扬"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "接口访问报错"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "心态崩了，卸载Idea"));

        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "启动Idea"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "搞数据库,连tomcat,crud一顿输出"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "嘴角疯狂上扬"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "接口访问报错"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "心态崩了，卸载Idea"));

        coderDoSomeThingList.forEach(coder->{
            ExecutorService service = serviceMap.get(coder.getName());
            service.execute(()-> System.out.println(coder.toString()));
        });

    }

}
