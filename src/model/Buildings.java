package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Buildings {

    public String buildingName;
    private double officesTotal,officesPerFloor;
    public  HashMap<Integer, Double> buildingHm;

    public Buildings(String buildingName, int offices_num) {
        this.buildingName = buildingName;
    }

    public void createBuilding( int floors_num, double offices_num) {
       buildingHm = new HashMap<Integer, Double>();
        for(int i=1; i<=floors_num;i++){
            buildingHm.put(i,offices_num);
        }
        officesTotal=floors_num*offices_num;
        officesPerFloor= offices_num;
    }

    public void sortToOffices(ArrayList <Person> personArrayList){
        for(int i=0;i<personArrayList.size();i++) {
            int floor2Go = which_Floor(personArrayList.get(i).getDesiredOffice());
            if(buildingHm.get(floor2Go)!=0){
                personArrayList.get(i).setOnOffice(true);
                buildingHm.put(floor2Go, buildingHm.get(floor2Go)-1);
            }
        }

    }

    public int which_Floor(double desiredOffice){
        if(desiredOffice<=officesTotal && desiredOffice>0) {
            double floor = desiredOffice / officesPerFloor;
            int whole = (int) floor;
            double decimal = floor - whole;
            if (decimal >= 0.1 && decimal<=0.9) {
                whole++;
            }
            return whole;
        }
        return 0;
    }
}
