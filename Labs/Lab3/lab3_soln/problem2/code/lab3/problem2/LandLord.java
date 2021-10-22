package lab3.problem2;

import java.util.ArrayList;
import java.util.List;

public class LandLord {

	public static void main(String[] args){
		List<Building> buildingList = new ArrayList<>();
		
		Building building1 = new Building("Building1", new ArrayList<Apartment>(){
			{
				add(new Apartment(250, "Apartment1"));
				add(new Apartment(200, "Apartment2"));
			}
		}, 100);
		
		Building building2 = new Building("Building2", new ArrayList<Apartment>(){
			{
				add(new Apartment(300, "Apartment1"));
				add(new Apartment(200, "Apartment2"));
			}
		}, 200);
		
		buildingList.add(building1);
		buildingList.add(building2);
		
		for(Building building : buildingList){
			System.out.println(building);
		}
	}
}
