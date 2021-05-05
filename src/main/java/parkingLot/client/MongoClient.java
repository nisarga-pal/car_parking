package parkingLot;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoClient extends BaseClient{
    AppConfig appConfig=new AppConfig();
    
    public void SetSlot() {
            String regNumber=registrationNumber();
            String color=color();
            BasicDBObject updateDocument = new BasicDBObject();
            updateDocument.append("Registration Number",regNumber);
            updateDocument.append("Color", color);
            updateDocument.append("$set", new BasicDBObject().append("Registration Number", regNumber));
            updateDocument.append("$set", new BasicDBObject().append("Color",color));
            appConfig.getDocument().updateOne(Filters.eq("Registration Number",null), Updates.set("Registration Number",regNumber));
            appConfig.getDocument().updateOne(Filters.eq("Color",null), Updates.set("Color",color));
            System.out.println("Car is Entered.");
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
}
