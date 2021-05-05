package parkingLot;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InMemoryClient extends BaseClient {
	
	ArrayList<Integer> Avails = new ArrayList<Integer>();
	List<Integer> Occupied = new ArrayList<Integer>();
	Scanner input = new Scanner(System.in);
	Hashtable<Integer, List<String>> Level = new Hashtable<Integer, List<String>>();
	public InMemoryClient() {
	    Collections.addAll(Avails, 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
	    101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,
	    201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,
	    301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,
	    401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420);
		}
	    public void SetSlot() {
	    
		int menu;
		String floor = " ";
	        List<String> array = new ArrayList<String>(10);
	        Date date = new Date();
	                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy,E HH:mm:ss");
	                String strDate = formatter.format(date);
	               
	        	System.out.println("Enter Colour");
	                String colour = input.next();
	               
	                System.out.println("Enter Reg Plate");
	                String regPlate = input.next();
	               
	                System.out.println("Alloting a slot..."+"\n");
	                int min = (int) Collections.min(Avails);
	               
	                if(min<100)
	                {
	                floor = "Ground Floor";
	                }
	                else if(min>100 && min<200)
	                {
	                floor = "First Floor";
	                }
	                else if(min>100 && min<200)
	                {
	                floor = "Second Floor";
	                }
	                else if(min>200 && min<300)
	                {
	                floor = "Third Floor";
	                }
	                else if(min>300 && min<400)
	                {
	                floor = "Fourth Floor";
	                }
	                else
	                {
	                floor = "Fifth Floor";
	                }
	                array.add(Integer.toString(min));
	                array.add(regPlate);
	                array.add(colour);
	                array.add(floor);
	                array.add(strDate);
	                Avails.remove(Avails.indexOf(min));
	                Occupied.add(min);
	                Level.put(min,array);
	               
	                System.out.println("Floor: "+floor+"\n"+"Slot no: "+min+"\n"+"Colour:"+colour+"\n"+"Reg Plate:"+regPlate+"\n"+"Date:"+strDate+"\n\n");
		}
		public void ToRemoveFromSlot() {
		
			if(Occupied.isEmpty()) {
				System.out.println("No cars in the slot!");
			}else {
				System.out.println("Enter Slot no");	
	        	Scanner input = new Scanner(System.in);
			Integer slot_no = input.nextInt();
		   	for( Map.Entry<Integer, List<String>> entry : Level.entrySet() )
		        {
		            Integer key = entry.getKey();
		            List<String> values = entry.getValue();
		            if(key==slot_no)
		            {
		            System.out.print("Slot no:"+key+"\t");
		            System.out.print("Colour:"+values.get(2)+"\t");
		            System.out.println("Reg Plate:"+values.get(1));
		            Level.remove(key);
		            Occupied.remove(Occupied.indexOf(slot_no));
		                Avails.add(slot_no);
		            }else {
		            	System.out.println("No cars in the slot!");
		            	break;
		            }
		        }
			}
		}
		
		public void SearchSlotByRegNumber() {
			System.out.println("Enter Reg No of your Car");
	    	String RegNo= input.next();
	    	int count=0;
	    	for( Map.Entry<Integer, List<String>> entry : Level.entrySet() ) {
	    		List<String> values = entry.getValue();
	    		if(RegNo.equals(values.get(1))) {
	    			System.out.println("Slot Number:"+ values.get(0));
	    			count++;
	    		}
	    	}
	    	if(count==0) {
	    		System.out.println("Not Found");
	   
	    	}
			
		}
		public void SearchSlotByColor() {
			System.out.println("Enter the color");
	    	String Clr= input.next();
	    	int count=0;
	    	for( Map.Entry<Integer, List<String>> entry : Level.entrySet() ) {
	    		List<String> values = entry.getValue();
	    		if(Clr.equals(values.get(2))) {
	    			System.out.println("Slot Number:"+values.get(0));
	    			count++;
	    		}
	    		
	    	}
	    	if(count==0) {
	    		System.out.println("Not Found");
	   
	    	}
			
		}
		public void SearchCarByColor() {
			System.out.println("Enter the color");
	    	String Clr= input.next();
	    	int count=0;
	    	for( Map.Entry<Integer, List<String>> entry : Level.entrySet() ) {
	    		List<String> values = entry.getValue();
	    		
	        		if(Clr.equals(values.get(2))) {
	        			System.out.println("Reg Plate:"+values.get(1));
	        			count++;
	        		}
	    	}
	    	if(count==0) {
	    		System.out.println("Not Found");
	   
	    	}
			
	}
		
		
}
