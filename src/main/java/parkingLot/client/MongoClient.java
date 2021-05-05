package parkingLot.client;
import java.util.*;
import org.bson.Document;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

public class MongoClient extends BaseClient{
    AppConfig appConfig=new AppConfig();
    
    public void SetSlot() {
            String regNumber=registrationNumber();
            String color=color();
            BasicDBObject updateDocument = new BasicDBObject();
            updateDocument.append("$set", new BasicDBObject().append("Registration Number", regNumber));
            updateDocument.append("$set", new BasicDBObject().append("Color",color));
            appConfig.getDocument().updateOne(Filters.eq("Registration Number",null), Updates.set("Registration Number",regNumber));
            appConfig.getDocument().updateOne(Filters.eq("Color",null), Updates.set("Color",color));
            Document vehicleInfo = appConfig.getCollection().find("registrationNumber", regNo).first();
            int slot = vehicleInfo.get("_id") ;
            String floor = null;
            if(slot<=10)
	                {
	                floor = "Ground Floor";
	                }
	                else if(slot>10 && slot<=20)
	                {
	                floor = "First Floor";
	                }
	                else if(slot>20 && slot<=30)
	                {
	                floor = "Second Floor";
	                }
	                else if(slot>30 && slot<=40)
	                {
	                floor = "Third Floor";
	                }
	                else if(slot>40 && slot<=50)
	                {
	                floor = "Fourth Floor";
	                }
	                else
	                {
	                floor = "Fifth Floor";
	                }    
        System.out.println("Vehicle Slot Number: " + slot);
        System.out.println(floor);
        
    }

    
    public void ToRemoveFromSlot() {
        String regNumber=registrationNumber();
        Bson filter=new Document("Registration Number",regNumber);
        Bson newValue = new Document("Registration Number",null).append("Color",null);
        Bson updateOperation =new Document("$set",newValue);
        appConfig.getDocument().updateOne(filter,updateOperation);
        System.out.println("Car is Removed.");
    }

    
    public void SearchSlotByRegNumber() {
        String regNumber=registrationNumber();
        FindIterable<Document> documents=appConfig.getDocument().find();
        for (Document info:documents){
            if (info.get("Registration Number")!=null && info.get("Registration Number").equals(regNumber)){
                System.out.println(info.get("_id"));
            }
        }
    }
    
    
    public void SearchCarByColor() {
        String color=color();
        FindIterable<Document> documents=appConfig.getDocument().find();
        for(Document info:documents){
           if( info.get("Color") !=null && info.get("Color").equals(color)){
               System.out.println(info.get("Registration Number"));
           }
        }
    }

    
    public void SearchSlotByColor() {
        String color=color();
        FindIterable<Document> documents=appConfig.getDocument().find();
        for(Document info:documents){
            if( info.get("Color") !=null && info.get("Color").equals(color)){
                System.out.println(info.get("_id"));
            }
        }
    }
      public void createCollection(){
        try {
            MongoCollection<Document> collection = appConfig.getDatabase().getCollection("Vehicle");
            Document document = new Document();
            for (int i = 1; i <= 60; i++) {
                document.append("_id", i);
                document.append("registrationNumber", null);
                document.append("Colour", null);
                collection.insertOne(document);
            }
        }catch (Exception ex){
            ex.getMessage();
        }
    }
}
