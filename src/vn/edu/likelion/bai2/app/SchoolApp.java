package vn.edu.likelion.bai2.app;

import vn.edu.likelion.bai2.exception.NotFoundException;
import vn.edu.likelion.bai2.service.impl.ClassInterfaceImpl;
import vn.edu.likelion.bai2.service.impl.TraineeAbsentInterfaceImpl;
import vn.edu.likelion.bai2.service.impl.TraineeInterfaceImpl;
import vn.edu.likelion.bai2.service.impl.TrainerInterfaceImpl;

public class SchoolApp {
    public static void main(String[] args) throws NotFoundException {
        ClassInterfaceImpl classInterface = new ClassInterfaceImpl();

        // create three class
        classInterface.create();
        classInterface.create();
        classInterface.create();

        // print all of class
        classInterface.printALl();

        TraineeInterfaceImpl traineeInterface = new TraineeInterfaceImpl();

        // create four trainee save a class
        traineeInterface.create();
        traineeInterface.create();
        traineeInterface.create();
        traineeInterface.create();

        // print all trainee a class
        traineeInterface.printALl();

        // print all of class
        classInterface.printALl();

        // update info a trainee
        traineeInterface.update();

        // print all trainee a class
        traineeInterface.printALl();

        TraineeAbsentInterfaceImpl traineeAbsentInterfaceImpl = new TraineeAbsentInterfaceImpl();

        // create two trainee absent
        traineeAbsentInterfaceImpl.create();
        traineeAbsentInterfaceImpl.create();

        // print all trainee a class
        traineeInterface.printALl();

        TrainerInterfaceImpl trainerService = new TrainerInterfaceImpl();

        // create one trainer
        trainerService.create();
        trainerService.create();

        // trainer will register a class
        trainerService.registerClass();
        trainerService.registerClass();

        // print all class which trainer registered
        trainerService.printALl();
    }
}
