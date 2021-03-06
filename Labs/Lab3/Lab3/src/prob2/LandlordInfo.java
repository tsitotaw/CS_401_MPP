package prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
	private List<Building> buildings;

	public LandlordInfo() {
		super();
		this.buildings = new ArrayList<>();
	}
	
	void addBuilding(Building building) {
		this.buildings.add(building);
	}
	
	double calcProfits() {
		double profit = 0;
		for(Building building: this.buildings) {
			for(Apartment apartment : building.getApartments()) {
				profit += apartment.getRent() - building.getCost();
			}
		}
		
		return profit;
	}
}
