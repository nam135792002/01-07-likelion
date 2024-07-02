package vn.edu.likelion.bai2.service.impl;

import vn.edu.likelion.bai2.entity.Trainee;
import vn.edu.likelion.bai2.entity.TraineeAbsent;
import vn.edu.likelion.bai2.exception.NotFoundException;
import vn.edu.likelion.bai2.service.GeneralInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TraineeAbsentInterfaceImpl implements GeneralInterface {
    private TraineeInterfaceImpl traineeInterface = new TraineeInterfaceImpl();
    private Scanner sc = new Scanner(System.in);
    private Trainee trainee = null;
    private TraineeAbsent traineeAbsent = null;
    private static List<TraineeAbsent> listTraineeAbsent = new ArrayList<>();

    @Override
    public void create() {
        System.out.println("------------------------------------------------------------");
        System.out.println(">> ADD TRAINEE INTO LIST OF ABSENT: ");
        System.out.print("Enter the id of class: ");
        int idClass = Integer.parseInt(sc.nextLine());

        System.out.print("Enter the id of trainee: ");
        int idTrainee = Integer.parseInt(sc.nextLine());

        try {
            trainee = traineeInterface.findById(idClass, idTrainee);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter the reason absent of trainee: ");
        String reason = sc.nextLine();

        traineeAbsent = new TraineeAbsent(reason, trainee);

        listTraineeAbsent.add(traineeAbsent);
        trainee.setStatus(false);
        System.out.println("Add trainee into list of absent successfully.");
        System.out.println("------------------------------------------------------------");
    }

    @Override
    public void printALl(){
        System.out.println("------------------------------------------------------------");
        System.out.println(">> PRINT LIST OF TRAINEE ABSENT: ");
        System.out.println("ID \t\t\t Name \t\t\t Reason \t\t\t Name of Class");
        for(TraineeAbsent traineeAbsent : listTraineeAbsent){
            System.out.println(traineeAbsent.getTrainee().getIdTrainee() + "\t\t\t" +
                    traineeAbsent.getTrainee().getName() + "\t\t\t" +
                    traineeAbsent.getReason() + "\t\t\t" +
                    traineeAbsent.getTrainee().getClasses().getName());
        }
        System.out.println("------------------------------------------------------------");
    }
}
