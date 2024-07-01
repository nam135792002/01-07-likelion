package vn.edu.likelion.bai2.entity;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private int id;
    private String name;
    private List<Classes> listClass;

    public Trainer(){
        this.listClass = new ArrayList<>();
    }
}
