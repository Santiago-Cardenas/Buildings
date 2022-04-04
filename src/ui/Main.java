
package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Buildings;
import model.Person;

public class Main {
    private Scanner sc;
    private boolean exit;
    private Buildings buildings;
    private String msg2Print = "";

    public Main() {
        this.sc = new Scanner(System.in);
        this.exit = false;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        System.out.println("\n");
        System.out.println("Please select an option\n1)Create buildings\n2)Exit\n");
        int option = this.sc.nextInt();
        if (option != 2) {
            this.sc.nextLine();
            System.out.println("Please create the building");
            int building_num = this.sc.nextInt();
            this.sc.nextLine();

            for(int i = 0; i < building_num; ++i) {
                this.buildingCreation();
            }

            System.out.println(this.msg2Print);
        } else {
            System.out.println("Goodbye\n");
        }

    }

    public void buildingCreation() {
        String entry = this.sc.nextLine();
        String[] arrOfStr = entry.split(" ", 4);
        String name = arrOfStr[0];
        int peopleQt = Integer.parseInt(arrOfStr[1]);
        int floors_num = Integer.parseInt(arrOfStr[2]);
        int offices_num = Integer.parseInt(arrOfStr[3]);
        this.buildings = new Buildings(name, offices_num);
        this.buildings.createBuilding(floors_num, (double)offices_num);
        this.peopleCreation(peopleQt);
        this.buildings.setFloors_num(floors_num);
    }

    public void peopleCreation(int peopleQt) {
        ArrayList<Person> peopleInBuilding = new ArrayList();
        double floor= buildings.getBuildingHm().get(1);

        for(int i = 0; i < peopleQt; ++i) {
            String entry = this.sc.nextLine();
            String[] arrOfStr = entry.split(" ", 3);
            String name = arrOfStr[0];
            int currentFloor = Integer.parseInt(arrOfStr[1]);
            int desiredOffice = Integer.parseInt(arrOfStr[2]);
            Person person = new Person(name, currentFloor, desiredOffice, false);
            peopleInBuilding.add(person);
        }

        this.buildings.sortToOffices(peopleInBuilding);
        this.buildings.createElevator(peopleInBuilding);
        this.msg(this.buildings.getElevator().movements((int) floor));
    }

    public void msg(ArrayList<Person> personArrayList) {
        this.msg2Print = this.msg2Print + "Movimientos del edificio " + this.buildings.getBuildingName() + "\n\n";

        int i;
        for(i = 0; i < personArrayList.size(); ++i) {
            if (((Person)personArrayList.get(i)).isOnOffice) {
                this.msg2Print = this.msg2Print + ((Person)personArrayList.get(i)).getName() + " se mueve a la oficina " + ((Person)personArrayList.get(i)).getDesiredOffice() + "\n";
            } else {
                this.msg2Print = this.msg2Print + ((Person)personArrayList.get(i)).getName() + " no puede ser incluido en las oficinas del edificio\n";
            }
        }

        this.msg2Print = this.msg2Print + "\n\nEstado final de las oficinas en el edificio " + this.buildings.getBuildingName() + "\n\n" + "[";

        for(i = 0; i < personArrayList.size(); ++i) {
            if (i != 0) {
                if (((Person)personArrayList.get(i)).isOnOffice) {
                    this.msg2Print = this.msg2Print + "," + ((Person)personArrayList.get(i)).getName();
                }
            } else if (((Person)personArrayList.get(i)).isOnOffice) {
                this.msg2Print = this.msg2Print + ((Person)personArrayList.get(i)).getName();
            }
        }

        this.msg2Print = this.msg2Print + "]\n\n";
    }
}
