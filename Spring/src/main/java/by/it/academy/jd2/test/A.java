package by.it.academy.jd2.test;

import org.springframework.beans.factory.annotation.Autowired;

public class A {
    @Autowired
    private B obj;

    private  Object context;


    public A(B obj) {
        this.obj = obj;

    }

    @Override
    public String toString() {
        return "Это А";
    }

    public A() {
        this.obj = null;
    }

    public void setObj(B obj) {
        this.obj = obj;
    }

//    public  void afterInit(){
//        this.obj= this.context.getBean("name", B.class);

}

