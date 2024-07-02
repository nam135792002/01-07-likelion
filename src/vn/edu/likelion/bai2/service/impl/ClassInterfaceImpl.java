package vn.edu.likelion.bai2.service.impl;

import vn.edu.likelion.bai2.entity.Classes;
import vn.edu.likelion.bai2.service.GeneralInterface;
import vn.edu.likelion.bai2.utility.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassInterfaceImpl implements GeneralInterface<Classes> {

    private Scanner sc = new Scanner(System.in);
    private static List<Classes> listClasses = new ArrayList<>();
    private Classes classes = null;


    @Override
    public void create() {
        System.out.println("------------------------------------------------------------");
        System.out.println(">> CREATE A CLASS: ");
        if(listClasses.size() >= Constant.NUMBER_CLASS_OF_SCHOOL){
            System.out.println("Number class of school is fully!");
        }else{
            classes = new Classes();

            do {
                try{
                    System.out.print("Enter the id of class: ");
                    int id = Integer.parseInt(sc.nextLine());
                    classes.setId(id);
                    break;
                }catch (NumberFormatException ex){
                    System.out.println("Invalid value!");
                }
            }while (true);

            System.out.print("Enter the name of class: ");
            String name = sc.nextLine();
            classes.setName(name);
            listClasses.add(classes);

            System.out.println(">> Create a class successfully..");
            System.out.println("------------------------------------------------------------");
        }
    }

    @Override
    public void printALl() {
        System.out.println("------------------------------------------------------------");
        System.out.println(">> PRINT LIST OF CLASS: ");
        System.out.println("ID \t\t Name \t\t Amount Registered \t\t Status" );
        for(Classes classes : listClasses){
            System.out.println(classes.getId() + "\t\t " + classes.getName() + " \t\t\t " + classes.getAmountRegistered() + "/10\t\t\t\t " + ((classes.isStatus()) ? "Open" : "Close"));
        }

        System.out.println("------------------------------------------------------------");
    }

    @Override
    public Classes findById(int id) {
        for (Classes classes : listClasses){
            if(classes.getId() == id) return classes;
        }
        return null;
    }
}
