package ui;

import model.Buildings;
import model.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner sc;
    private boolean exit;
    private Buildings buildings;
    private String msg2Print ="";


    public Main() {
        sc = new Scanner(System.in);
        exit=false;
    }

    public static void main(String[] args){
        ui.Main main = new ui.Main();
        main.menu();
    }

    public void menu() {
        System.out.println("\n");
        System.out.println("Please select an option\n"+
                "1)Create buildings\n"+
                "2)Exit\n");
        int option=sc.nextInt();
        if(option!=2) {
            sc.nextLine();
            System.out.println("Please create the building");
            int building_num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < building_num; i++) {
                buildingCreation();
            }
            System.out.println(msg2Print);
        }
        else{
            System.out.println("Goodbye\n");
        }
    }

    public void buildingCreation() {
        String entry = sc.nextLine();
        String[] arrOfStr = entry.split(" ", 4);
        String name = arrOfStr[0];
        int peopleQt=  Integer.parseInt(arrOfStr[1]);
        int floors_num = Integer.parseInt(arrOfStr[2]);
        int offices_num = Integer.parseInt(arrOfStr[3]);
        buildings = new Buildings(name, offices_num);
        buildings.createBuilding(floors_num, offices_num);
        peopleCreation(peopleQt);
    }

    public void peopleCreation(int peopleQt){
        ArrayList<Person> peopleInBuilding = new ArrayList<Person>();
        for(int i=0; i<peopleQt;i++) {
            String entry = sc.nextLine();
            String[] arrOfStr = entry.split(" ", 3);
            String name = arrOfStr[0];
            int currentFloor = Integer.parseInt(arrOfStr[1]);
            int desiredOffice = Integer.parseInt(arrOfStr[2]);
            Person person = new Person(name, currentFloor, desiredOffice, false);
            peopleInBuilding.add(person);
        }
        sc.nextLine();
        buildings.sortToOffices(peopleInBuilding);
        msg(peopleInBuilding);
    }

    public void msg(ArrayList <Person> personArrayList){
        msg2Print+= "Movimientos del edificio " + buildings.getBuildingName() + "\n\n";
        for(int i=0;i<personArrayList.size();i++){
            if(personArrayList.get(i).isOnOffice){
                msg2Print+=(personArrayList.get(i).getName() + " se mueve a la oficina " + personArrayList.get(i).getDesiredOffice() + "\n");
            }
            else{
                msg2Print+=(personArrayList.get(i).getName() + " no puede ser incluido en las oficinas del edificio\n");
            }
        }
        msg2Print+= "\n\n" + "Estado final de las oficinas en el edificio " + buildings.getBuildingName() + "\n\n" + "[";
        for(int i=0;i<personArrayList.size();i++){
            if(i != 0){
                if(personArrayList.get(i).isOnOffice) {
                    msg2Print += "," + (personArrayList.get(i).getName());
                }
            }
            else if(personArrayList.get(i).isOnOffice) {
                msg2Print += (personArrayList.get(i).getName());
            }
        }

        msg2Print+= "]\n\n" ;
    }
}

