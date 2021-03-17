package by.it_academy.jd2;

public class Person {
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String AGE = "age";
    private String param_save = "ARRAY_NAME_PARAM";

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getAGE() {
        return AGE;
    }

    public String getParam_save() {
        return param_save;
    }

    public void setParam_save(String param_save) {
        this.param_save = param_save;
    }
    //= "lastName";
}
