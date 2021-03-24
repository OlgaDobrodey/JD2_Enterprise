package by.it_academy.jd2.serves;

import java.util.ArrayList;
import java.util.List;

public class NameView {
    private final ArrayList<String> list = new ArrayList<>();
    public void add(String name){
        this.list.add(name);
    }
    public List<String > getAll(){
        return this.list;
    }
}
