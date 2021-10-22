package quizclasses;

import java.util.*;

public  class Trader{
	
	private String name;
	private String city;
	private List<Trader> associates = new ArrayList<>();

	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}
	
	public void addAssociate(Trader t) {
		associates.add(t);
	}

	public String getName(){
		return this.name;
	}

	public String getCity(){
		return this.city;
	}
	
	public List<Trader> getAssociates() {
		return associates;
	}
	
	public boolean isAssociate(Trader t) {
		return associates.contains(t);
	}

	public void setCity(String newCity){
		this.city = newCity;
	}
	@Override
	public String toString(){
		return "Trader:"+this.name + " in " + this.city;
	}
	@Override 
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Trader)) return false;
		Trader t = (Trader) ob;
		return t.name.equals(name) && t.city.equals(city);
	}
}