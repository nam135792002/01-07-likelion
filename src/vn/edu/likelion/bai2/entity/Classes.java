package vn.edu.likelion.bai2.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Classes {
    private int id;
    private String name;
    private int amountRegistered;
    private LocalDate startDate;
    private boolean status;
    private List<Trainee> listTrainee;
    private Trainer trainer;

    public Classes(){
        this.listTrainee = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountRegistered() {
        ++this.amountRegistered;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmountRegistered() {
        return amountRegistered;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public List<Trainee> getListTrainee() {
        return listTrainee;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
