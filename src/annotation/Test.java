package annotation;

import com.sun.deploy.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

   private static String createSql(String className)throws Exception{
        Class<?> cl = Class.forName("annotation.AnnotationDemo");
        DbTable dbTable = cl.getAnnotation(DbTable.class);
       List<String> columnDefs = new ArrayList<String>();
        if(null == dbTable)
             return null;
        String tbName = dbTable.name();
       if(tbName.length() < 1)
           tbName = cl.getName().toUpperCase();
       for(Field field : cl.getDeclaredFields()) {
           String columnName = null;
           Annotation[] annotations = field.getDeclaredAnnotations();
           if(annotations.length < 1)
               continue; // Not a db table column
           if(annotations[0] instanceof SqlInteger){
               SqlInteger sInt = (SqlInteger) annotations[0];

               //若是没有name则用字段名称代替数据库字段名
               if(sInt.name().length() < 1)
                   columnName = field.getName().toUpperCase();
               else
                   columnName = sInt.name();
               columnDefs.add(columnName + " INT" +getConstraints(sInt.constraint()));
           }
           if(annotations[0] instanceof SqlString){
               SqlString sInt = (SqlString) annotations[0];
               //若是没有name则用字段名称代替数据库字段名
               if(sInt.name().length() < 1)
                   columnName = field.getName().toUpperCase();
               else
                   columnName = sInt.name();
               columnDefs.add(columnName + " VARCHAR(" + sInt.value()+") "+getConstraints(sInt.constraint()));
           }
       }
       //数据库表构建语句
       StringBuilder createCommand = new StringBuilder(
               "CREATE TABLE " + tbName + "(");

       for(String columnDef : columnDefs)
           createCommand.append("\n    " + columnDef + ",");

       String sql = createCommand.substring(0,createCommand.length()-1)+"\n)";
     return sql;
   }


    static String getConstraints(Constraints con){
        String constraints = "";
        if(!con.allowNull()){
            constraints += " NOT NULL";
        }
        if(con.primaryKey())
            constraints += " PRIMARY KEY";
        if(con.unique())
            constraints += " UNIQUE";
        return constraints;
    }


    public static void main(String[] args) throws Exception{

//        String[] arg={"annotation.AnnotationDemo."};
//        for(String className : arg) {
//            System.out.println("Table Creation SQL for " +
//                    className + " is :\n" + createSql(className));
//        }



    }

}
