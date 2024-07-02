package vn.edu.likelion.bai2.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trainee {
    private final int idBadge;
    private String idTrainee;
    private String name;
    private LocalDate dateOfBirth;
    private boolean status;
    private Classes classes;
    private static int increaseId = 100;


    public Trainee(){
        this.idBadge = ++increaseId;
    }

    public void setIdTrainee(String idTrainee){
        this.idTrainee = idTrainee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateOfBirth = LocalDate.parse(dateOfBirth, dateTimeFormatter);
    }

    public int getIdBadge() {
        return idBadge;
    }

    public String getIdTrainee() {
        return idTrainee;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.dateOfBirth.format(dateTimeFormatter);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
