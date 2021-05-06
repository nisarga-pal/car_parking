package parkingLot.client;
import java.util.*;
import automatictg.utility.ApplicationConfig;
import redis.clients.jedis.Jedis;

public class RedisClient extends BaseClient {
    AppConfig appConfig=new AppConfig();

    
    public void setSlot() {
        String regNumber=registrationNumber();
        String color=color();
        for (int i=1; i<6; i++) {
            Map<String, String> slotHash = new HashMap<>();
            String index=String.valueOf(i);
            slotHash.put("Registration_Number", registrationNumber);
            slotHash.put("Color", color);
            if (!appConfig.redisConnection().hexists(index,"Registration_Number")){
                appConfig.redisConnection().hmset(index, slotHash);
                System.out.println("car is Entered.");
                System.out.println(" Slot INFO - " + appConfig.redisConnection().hmget(index, "Registration_Number", "Color","Slot_Number"));
                break;
           }
        }
    }
  
    public void removeFromSlot() {
        String registrationNumber = registrationNumber();
        for (int i =1;i<6;i++){
            String index=String.valueOf(i);
            if (appConfig.redisConnection().hget(index,"Registration_Number").equalsIgnoreCase(registrationNumber)){
                appConfig.redisConnection().hdel(index,"Registration_Number");
                appConfig.redisConnection().hdel(index,"Color");
                System.out.println("Car is Removed.");
                break;
            }
        }
    }

    public void searchCarByColor() {
        String color=color();
        for (int i = 1; i < 6; i++) {
            String index = String.valueOf(i);
            if (appConfig.redisConnection().hget(index, "Color")!=null && appConfig.redisConnection().hget(index, "Color").equalsIgnoreCase(color)) {
                System.out.println(appConfig.redisConnection().hget(index, "Registration_Number"));
            }
        }
    }
   
    public void searchSlotByRegNumber() {
        String registrationNumber=registrationNumber();
        for (int i=1;i<6;i++){
            String index=String.valueOf(i);
            if (appConfig.redisConnection().hget(index,"Registration_Number")!=null && appConfig.redisConnection().hget(index,"Registration_Number").equalsIgnoreCase(registrationNumber)){
                System.out.println(appConfig.redisConnection().hget(index,"Slot_Number"));
            }
        }
    }
    
    public void searchSlotByColor() {
        String color=color();
        for (int i=1;i<6;i++){
            String index=String.valueOf(i);
            if (appConfig.redisConnection().hget(index,"Color")!=null && appConfig.redisConnection().hget(index,"Color").equalsIgnoreCase(color)){
                System.out.println(appConfig.redisConnection().hget(index,"Slot_Number"));
            }
        }
    }


    public void createHash(){
        Jedis jedis=appConfig.redisConnection();
        Map<String,String> hash=new HashMap<>();
        for (int i=1;i<60;i++){
            hash.put("Slot_Number",String.valueOf(i));
            jedis.hmset(String.valueOf(i),hash);
        }
    }
}

