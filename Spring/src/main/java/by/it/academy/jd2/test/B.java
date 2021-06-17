package by.it.academy.jd2.test;

import org.springframework.beans.factory.annotation.Autowired;

public class B {
    @Autowired
    private  A obj;
    public B(A obj) {
        this.obj=obj;
    }

    public B() {
        this.obj=null;
    }
    public void setObj(A obj){   this.obj=obj;}
}
