package automatic_parking.com.core;

public class Car {
	String registrationNumber;
	String colorOfCar;
	public Car() {
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getColorOfCar() {
		return colorOfCar;
	}
	public void setColorOfCar(String colorOfCar) {
		this.colorOfCar = colorOfCar;
	}
	@Override
	public String toString() {
		return "\nRegistrationNumber=" + registrationNumber + ", \nColor=" + colorOfCar ;
	}
}
