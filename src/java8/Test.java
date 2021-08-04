package java8;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-10 17:49
 **/
public class Test implements Cloneable{


    public Test(String name, BigDecimal value, int var) {
        this.name = name;
        this.value = value;
        this.var = var;
    }

    public Test() {
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Test(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public Test(int var) {
        this.var = var;
    }

    String name;
    BigDecimal value;
    int var;
    Date date;

    public static  List<Integer> list  = new ArrayList<>();
    static  {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }
    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Test test = new Test();
        test.setName("clone source");
        Test test1 = (Test) test.clone();
        test1.setName("-----");
        test1.getList().add(5);
        System.out.println(test1.getList());
        System.out.println(test.getList());
    }
}
