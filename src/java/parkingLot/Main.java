package parkingLot;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
	    Scanner input = new Scanner(System.in);
	    String clientName = null;
	    System.out.println("Enter Client");
	    clientName = input.next();
	    
	    BaseClient client=null;
		if(clientName.equalsIgnoreCase("mysql")){
			client=new MySqlClient();
		}
		else if(clientName.equalsIgnoreCase("inmemory")){
			client=new InMemoryClient();
		}
	    int menu = 0;
		do {
			Menu.options();
			menu = input.nextInt();
      
		switch(menu) {
			case(1):
				client.SetSlot();
				break;
			case(2):
				client.ToRemoveFromSlot();
				break;
			case(3):
				client.SearchSlotByRegNumber();
				break;
           		case(4):
            			client.SearchCarByColor();
				break;
          		case(5):
           		 	client.SearchSlotByColor();//
				break;
			case(0):
               			 System.out.println("\nThank you!\n");
	            		break;
           	 default: {
	             System.out.println("Invalid option!\n");
	         //break;
	                    }
		      }	
		}
		while(menu!=0);
		
	}

}
