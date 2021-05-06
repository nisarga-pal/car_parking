package parkingSystem;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class BaseClient {
	Scanner sc=new Scanner(System.in);
	
	public String color(){
        	System.out.println("Enter Car Color : ");
        	String color = sc.nextLine();
        	return color;
        	return sc.nextLine();
        }
	public String registrationNumber(){
        	System.out.println("Enter Car Registration Number : ");
        	String registrationNumber = sc.nextLine();
        	return registrationNumber;
        	return sc.nextLine();
    	}
        public abstract void SetSlot() throws SQLException;{}
        public abstract void ToRemoveFromSlot();
        public abstract void SearchSlotByRegNumber();
        public abstract void SearchCarByColor();
        public abstract void searchSlotByColor();
}
