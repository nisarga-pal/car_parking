package parkingLot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;
import automatic_parking.com.client.BaseClient;
import automatic_parking.com.client.InMemory;
import automatic_parking.com.client.Mysqlclient;
import automatic_parking.com.utility.AppConfig;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AppConfig applicationConfig=new AppConfig();
	    applicationConfig.fileConfig();
	    String clientName= applicationConfig.getClient();
		BaseClient baseClient=new InMemory();

	    if(clientName.equalsIgnoreCase("mysql"))
	    {
	       System.out.println("Client Name - "+clientName);
	       baseClient=new Mysqlclient();
		   applicationConfig.mySqlConnection();
	    }
	    else if(clientName.equalsIgnoreCase("mongodb")){
			System.out.println("Client Name - "+clientName);
			baseClient=new MongoClient();
			applicationConfig.mongoConnection();
			MongoClient mongoClient=(MongoClient) baseClient;
			mongoClient.createCollection();
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
