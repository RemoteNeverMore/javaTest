package java8;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-10 17:49
 **/
public class Test implements Cloneable{


    public Test(String name, BigDecimal value, String var) {
        this.name = name;
        this.value = value;
        this.var = var;
    }

    public Test(String name, BigDecimal value, int var) {
        this.name = name;
        this.value = value;
        this.var1 = var;
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




    String name;
    BigDecimal value;
    String var;
    int var1;
    Date date;

    public static  List<Integer> list  = new ArrayList<>();
    static  {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    public static void main(String[] args) {
        List<Integer> collect = list.stream().filter(o -> o > 3).collect(Collectors.toList());
        System.out.println(collect.size());

    }
    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public String getVar() {
        return var;
    }


    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public void setVar(String var) {
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


}
