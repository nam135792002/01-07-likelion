package vn.edu.likelion.bai2.service.impl;

import vn.edu.likelion.bai2.entity.Classes;
import vn.edu.likelion.bai2.entity.Trainee;
import vn.edu.likelion.bai2.exception.NotFoundException;
import vn.edu.likelion.bai2.service.GeneralInterface;
import vn.edu.likelion.bai2.service.TraineeInterface;
import vn.edu.likelion.bai2.utility.Constant;

import java.util.Scanner;

public class TraineeInterfaceImpl implements GeneralInterface<Trainee>, TraineeInterface {
    private Scanner sc = new Scanner(System.in);
    private Trainee trainee = null;
    private ClassInterfaceImpl classInterface = new ClassInterfaceImpl();

    @Override
    public void create() throws NotFoundException{
        System.out.println("------------------------------------------------------------");
        System.out.println(">> REGISTER CLASS FOR TRAINEE: ");
        trainee = new Trainee();

        enterInfoForTrainee(trainee);
        do {
            classInterface.printALl();
            System.out.print("Trainee have to choose class: ");
            int idClass = Integer.parseInt(sc.nextLine());
            Classes classes = classInterface.findById(idClass);
            if(classes == null) throw new NotFoundException("Not found this id class. Choose again..");
            else if (classes.getAmountRegistered() == Constant.NUMBER_TRAINEE_OF_CLASS) System.out.println("This class is fully. Choose again..");
            else{
                classes.getListTrainee().add(trainee);
                classes.setAmountRegistered();
                if(classes.getAmountRegistered() == 4) classes.setStatus(true);
                trainee.setStatus(true);
                trainee.setClasses(classes);
                break;
            }
        }while (true);

        System.out.println(">> Register class for trainee successfully..");
        System.out.println("------------------------------------------------------------");
    }

    @Override
    public void printALl() throws NotFoundException{
        System.out.println("------------------------------------------------------------");
        System.out.println(">> PRINT LIST OF TRAINEE A CLASS: ");
        System.out.print("Enter the id of class which you want to review list of trainee: ");
        int id = Integer.parseInt(sc.nextLine());

        Classes classes = classInterface.findById(id);
        if(classes == null){
            throw new NotFoundException("Not found id class");
        }else{
            if(classes.getListTrainee().isEmpty()) System.out.println("List of trainee is empty");
            else{
                System.out.println("ID Badge \t\t ID Trainee \t\t Name \t\t Date of birth \t\t Status" );
                for (Trainee trainee : classes.getListTrainee()){
                    System.out.println(trainee.getIdBadge() + "\t\t\t\t " + trainee.getIdTrainee() + "\t\t\t\t "
                            + trainee.getName() + "\t\t\t " + trainee.getDateOfBirth() + "\t\t\t" + (trainee.isStatus() ? "Continue" : "Absent"));
                }
            }
        }

        System.out.println("------------------------------------------------------------");
    }

    @Override
    public void update() {
        System.out.println("------------------------------------------------------------");
        System.out.println(">> UPDATE INFO TRAINEE: ");
        System.out.print("Enter the id of class: ");
        int idClass = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the trainee: ");
        int idTrainee = Integer.parseInt(sc.nextLine());

        try {
            Trainee trainee = findById(idClass, idTrainee);
            if (trainee == null) System.out.println(">> Not found this trainee with ID: " + idTrainee + "in this class with id: " + idClass);
            else{
                enterInfoForTrainee(trainee);
            }
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Trainee findById(int idCLass, int idTrainee) throws NotFoundException{
        Classes classes = classInterface.findById(idCLass);
        if(classes == null) throw new NotFoundException("Not found this class with id " + idCLass);
        else{
            for (Trainee trainee : classes.getListTrainee()){
                if(trainee.getIdBadge() == idTrainee) return trainee;
            }
        }
        return null;
    }

    private void enterInfoForTrainee(Trainee trainee){
        System.out.print("Enter the identification of trainee: ");
        String idTrainee = sc.nextLine();
        trainee.setIdTrainee(idTrainee);

        System.out.print("Enter the name of trainee: ");
        String name = sc.nextLine();
        trainee.setName(name);

        System.out.print("Enter the date of birth of trainee(dd/MM/yyyy): ");
        String dateOfBirth = sc.nextLine();
        trainee.setDateOfBirth(dateOfBirth);
    }
}
