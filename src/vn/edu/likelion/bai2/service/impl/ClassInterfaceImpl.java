package vn.edu.likelion.bai2.service.impl;

import vn.edu.likelion.bai2.entity.Classes;
import vn.edu.likelion.bai2.service.GeneralInterface;
import vn.edu.likelion.bai2.utility.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassInterfaceImpl implements GeneralInterface {

    private Scanner sc = new Scanner(System.in);
    private List<Classes> listClasses = new ArrayList<>();
    private Classes classes = null;


    @Override
    public void create() {
        if(listClasses.size() >= Constant.NUMBER_CLASS_OF_SCHOOL){
            System.out.println("Number class of school is fully!");
        }else{

        }
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


        System.out.println("Enter the name of class: ");
        String name = sc.nextLine();
        classes.setName(name);
        listClasses.add(classes);

        System.out.println("Create a class successfully");
    }
}
