package java8;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-10 17:49
 **/
public class Test1 {


    public Test1(String name, BigDecimal value, int var) {
        this.name = name;
        this.value = value;
        this.var = var;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Test1(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public Test1(int var) {
        this.var = var;
    }

    String name;
    BigDecimal value;
    int var;
    Date date;

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

    public static void main(String[] args) {

    }
}
