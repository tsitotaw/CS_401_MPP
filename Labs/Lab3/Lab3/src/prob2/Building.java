package prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
	private double cost;
	private double profit;
	private List<Apartment> apartments;
	
	
	public Building(double cost, double profit) {
		this.cost = cost;
		this.profit = profit;
		
		this.apartments = new ArrayList<>();
	}
	
	void addApartment(Apartment apartment) {
		this.apartments.add(apartment);
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public List<Apartment> getApartments() {
		return apartments;
	}
	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}
	
	
}
