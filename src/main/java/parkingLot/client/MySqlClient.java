package parkingLot;
import java.sql.*;
import java.util.*;

	public class MySqlClient extends BaseClient  {
	   static Scanner input = new Scanner(System.in);
	   static MySQL mysql=new MySQL();
	   static Connection con = mysql.create();
	   public void SetSlot() throws SQLException {
		System.out.println("Enter Colour");
	    	String colour = input.next();
	    	System.out.println("Enter Reg Plate");
	    	String regPlate = input.next();
	    	
	    	System.out.println("Alloting a slot..."+"\n");
	    	Statement stmt= con.createStatement();
	    	String sltQuery = "Select * from ParkingSystem";
	    	ResultSet rs = stmt.executeQuery(sltQuery);
	    	boolean flag=false;
	    	while(rs.next()) {
	    		if(rs.getString(2)==null) {
	    			try {
	    			String updQuery = "UPDATE ParkingSystem SET regNumber=?,colour=?,time=NOW() WHERE slot=?;";
	    			PreparedStatement statement = con.prepareStatement(updQuery);
	    			statement.setString(1, regPlate);
	    			statement.setString(2, colour);
	    			statement.setString(3, Integer.toString(rs.getInt(1)));
	    			statement.executeUpdate();
	    			System.out.println("Slot Alloted");
	    			System.out.println();
	    			flag=true;
	    			break;
	    			}
	    			catch (SQLException throwable) {
	                    System.out.println(throwable.getMessage());
	                }
	    	    }
	    	}
	    	if(!flag) {
	    		try{
	    			String insQuery = "INSERT INTO ParkingSystem(regNumber,colour,time) values(?,?,NOW());";
	    			PreparedStatement statement = con.prepareStatement(insQuery);
	    			statement.setString(1, regPlate);
	    			statement.setString(2, colour);
	    			statement.executeUpdate();
	    			System.out.println("Slot Alloted");
	    		}
	    		catch (SQLException throwable) {
	                System.out.println(throwable.getMessage());
	            }
	    	}
	         String sltQuery2 = "SELECT * FROM ParkingSystem WHERE regNumber=?;";
	         PreparedStatement statement = con.prepareStatement(sltQuery2);
	         statement.setString(1, regPlate);
	         ResultSet rs1 = statement.executeQuery();
	         while (rs1.next()) {
	        	 System.out.println("__Ticket__");
	        	 System.out.println("Registration Number:"+rs1.getString(2));
	        	 System.out.println("vehicle Colour :"+rs1.getString(3));
	        	 System.out.println("Entry Time :"+rs1.getTimestamp(4));
	        	 System.out.println("Slot Number :"+ rs1.getInt(1));
	         	}
		}
		
		public void ToRemoveFromSlot(){
	        System.out.println("Enter Reg Plate");
	    	String regPlate = input.next();
	        String updQuery2="UPDATE ParkingSystem SET regNumber=?,colour=?,time=? WHERE regNumber=?";
	        try {
	            PreparedStatement statement=con.prepareStatement(updQuery2);
	            statement.setString(1,null);
	            statement.setString(2,null);
	            statement.setString(3,null);
	            statement.setString(4,regPlate);
	            System.out.println();
	            System.out.println("Car exiting...");
	            statement.executeUpdate();
	        } catch (SQLException throwable) {
	            System.out.println(throwable.getMessage());
	        }
	    }
		public void SearchCarByColor(){
			 
		            try{
		                Statement stmt=con.createStatement();
		                Scanner sc = new Scanner(System.in);
		                System.out.print("Enter Color to be searched  : ");
		                String color=sc.next();
		                String query1="select regNumber from ParkingSystem where colour='"+color+"'";
		                ResultSet rs = stmt.executeQuery(query1);
		                while (rs.next()) {
		                    String regNumber = rs.getObject(1).toString();
		                    System.out.println(registrationNumber);}
		            }
		            catch( Exception e)
		            {
		                e.printStackTrace();
		            }
		        }

		public void SearchSlotByRegNumber(){
		            try {
		                Statement stmt = con.createStatement();
		                Scanner sc = new Scanner(System.in);
		                System.out.println("Enter Registration Number to be searched : ");
		                String regNumber = sc.next();
		                String query1 = "select slot from ParkingSystem where regNumber='" + regNumber + "' ";
		                ResultSet rs = stmt.executeQuery(query1);
		                while (rs.next()) {
		                    String slotNumber = rs.getObject(1).toString();
		                    System.out.println(slotNumber);
		                }
		            }
		            catch(Exception e){
		                e.printStackTrace();
		            }
		        }

		public void searchSlotByColor(){
		            try {
		                Statement stmt = con.createStatement();
		                Scanner sc = new Scanner(System.in);
		                System.out.println("Enter Vehicle Color to be searched  : ");
		                String color = sc.next();
		                String query1 = "select slot from ParkingSystem where colour='" + color + "' ";
		                ResultSet rs = stmt.executeQuery(query1);
		                while (rs.next()) {
		                    String slotNumber = rs.getObject(1).toString();
		                    System.out.println(slotNumber);
		                }
		            }
		            catch(Exception e){
		                e.printStackTrace();
		            }
		        
			
		}

		
	}
