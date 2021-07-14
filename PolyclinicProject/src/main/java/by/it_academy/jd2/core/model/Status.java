package by.it_academy.jd2.core.model;

public enum Status {
    POSITIV,
    NEGATIV;

    public static Status  getStatus(String status){
        if(POSITIV.name().equals(status)){
            return POSITIV;
        }
        if(NEGATIV.name().equals(status)){
            return NEGATIV;
        }
        else return null;
    }

}
