package vn.edu.likelion.bai2.entity;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private int id;
    private String name;
    private int count;
    private List<Classes> listClass;

    public Trainer(int id, String name){
        this.id = id;
        this.name = name;
        this.listClass = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Classes> getListClass() {
        return listClass;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        ++this.count;
    }
}
