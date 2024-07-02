package vn.edu.likelion.bai2.entity;

public class TraineeAbsent{
    private String reason;
    private Trainee trainee;

    public TraineeAbsent(String reason, Trainee trainee) {
        this.reason = reason;
        this.trainee = trainee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }
}
