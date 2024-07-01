package vn.edu.likelion.bai2.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Classes {
    private int id;
    private String name;
    private int amountRegistered;
    private LocalDate startDate;
    private List<Trainee> listTrainee;

    public Classes(){
        this.listTrainee = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
