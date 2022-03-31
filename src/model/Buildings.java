package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Buildings {

    public String buildingName;
    private int officesTotal;
    public  HashMap<Integer, Integer> building;

    public Buildings(String buildingName, int offices_num) {
        this.buildingName = buildingName;
    }

    public void createBuilding( int floors_num, int offices_num) {
       building = new HashMap<Integer, Integer>();
        for(int i=1; i<floors_num;i++){
            building.put(i,offices_num);
        }
        officesTotal=floors_num*offices_num;
    }

    public void sortToOffices(ArrayList <Person> personArrayList){
        for(int i=0;i<personArrayList.size();i++) {
            int floor2Go = which_Floor(personArrayList.get(i).getDesiredOffice());
            if(building.get(floor2Go)!=0){
                personArrayList.get(i).setOnOffice(true);
                building.put(floor2Go,building.get(floor2Go)-1);
            }
        }

    }

    public int which_Floor(double desiredOffice){
        if(desiredOffice<=officesTotal && desiredOffice>0) {
            double floor = desiredOffice / building.get(1);
            int whole = (int) floor;
            double decimal = floor - whole;
            if (decimal >= 0.1) {
                whole++;
            }
            return whole;
        }
        return 0;
    }
}
