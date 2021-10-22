package prob3.composition;

public class Cylinder {

	private double height;
	private double radius;	
	
	public Cylinder(double height, double radius) {
		this.height = height;
		this.radius = radius;
	}
	
	public double computeVolume() {		
		return Math.PI*Math.pow(radius, 2)*this.height; //πr2h
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}	
	
}
