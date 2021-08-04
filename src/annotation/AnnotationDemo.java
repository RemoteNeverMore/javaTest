package annotation;

@DbTable(name="DbTable")
public class AnnotationDemo {

    @SqlInteger(name="age",constraint = @Constraints(allowNull = true))
    private Integer age;

    @SqlString(name="name",value = 20)
    private String name;

    @SqlString(name="Id",value = 20,constraint = @Constraints(primaryKey = true))
    private String Id ;

}
