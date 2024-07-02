package vn.edu.likelion.bai2.service.impl;

import vn.edu.likelion.bai2.entity.Classes;
import vn.edu.likelion.bai2.entity.Trainee;
import vn.edu.likelion.bai2.entity.Trainer;
import vn.edu.likelion.bai2.exception.NotFoundException;
import vn.edu.likelion.bai2.service.GeneralInterface;
import vn.edu.likelion.bai2.service.TrainerInterface;
import vn.edu.likelion.bai2.utility.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainerInterfaceImpl implements GeneralInterface<Trainer>, TrainerInterface {
    private Scanner sc = new Scanner(System.in);
    private Trainer trainer = null;
    private static List<Trainer> listTrainer = new ArrayList<>();
    private ClassInterfaceImpl classInterface = new ClassInterfaceImpl();

    @Override
    public void create() {
        if(listTrainer.size() == Constant.NUMBER_TEACHER_OF_SCHOOL){
            System.out.println("Amount teacher is fully.");
        }else{
            System.out.println("------------------------------------------------------------");
            System.out.println(">> CREATE A TRAINER: ");
            System.out.println("Enter the id of trainer: ");
            int idTrainer = Integer.parseInt(sc.nextLine());

            System.out.println("Enter the name of trainer: ");
            String name = sc.nextLine();

            trainer = new Trainer(idTrainer, name);

            listTrainer.add(trainer);

            System.out.println(">> Create a trainer successfully..");
            System.out.println("------------------------------------------------------------");
        }
    }

    @Override
    public Trainer findById(int id) {
        for (Trainer trainer : listTrainer){
            if(trainer.getId() == id) return trainer;
        }
        return null;
    }

    @Override
    public void printALl() throws NotFoundException {
        System.out.println("------------------------------------------------------------");
        System.out.println(">> PRINT LIST TRAINEE OF TRAINER: ");
        System.out.println("Enter the id of trainer: ");
        int idTrainer = Integer.parseInt(sc.nextLine());
        Trainer trainer = findById(idTrainer);
        if (trainer == null) throw new NotFoundException("Not found this trainer with id: " + idTrainer);
        else{
            for (Classes classes : trainer.getListClass()){
                System.out.println("List trainee of " + classes.getName() + ": ");
                System.out.println("ID Badge \t\t ID Trainee \t\t Name \t\t Date of birth \t\t Status" );
                for (Trainee trainee : classes.getListTrainee()){
                    System.out.println(trainee.getIdBadge() + "\t\t\t\t " + trainee.getIdTrainee() + "\t\t\t\t "
                            + trainee.getName() + "\t\t\t " + trainee.getDateOfBirth() + "\t\t\t" + (trainee.isStatus() ? "Continue" : "Absent"));
                }
            }
        }
    }

    @Override
    public void registerClass() throws NotFoundException{
        System.out.println("------------------------------------------------------------");
        System.out.println(">> REGISTER CLASS FOR TRAINER: ");
        System.out.println("Enter the id of trainer: ");
        int idTrainer = Integer.parseInt(sc.nextLine());
        Trainer trainer = findById(idTrainer);
        if (trainer == null) throw new NotFoundException("Not found this trainer with id: " + idTrainer);
        else{
            if (trainer.getCount() == Constant.NUMBER_CLASS_REGISTERED_OF_TEACHER){
                System.out.println("Teacher: " + trainer.getName() + " registered enough two classes.");
            }else{
                do {
                    classInterface.printALl();
                    System.out.println("Enter the id of class: ");
                    int idClass = Integer.parseInt(sc.nextLine());
                    Classes classes = classInterface.findById(idClass);
                    if (classes == null) System.out.println("Not found this class with id: " + idClass);
                    else{
                        trainer.getListClass().add(classes);
                        trainer.setCount();
                        break;
                    }
                }while (true);
            }
        }
    }
}
