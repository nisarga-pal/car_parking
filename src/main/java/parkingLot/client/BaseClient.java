package parkingSystem;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class BaseClient {
	Scanner sc=new Scanner(System.in);
	
    public abstract void SetSlot() throws SQLException;{}
    public abstract void ToRemoveFromSlot();
    public abstract void SearchSlotByRegNumber();
    public abstract void SearchCarByColor();
    public abstract void searchSlotByColor();
}
