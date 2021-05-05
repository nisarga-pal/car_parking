package parkingLot;
import java.util.*;

public class Slot {
	int noOfFloor;
    int slotPerFloor;
	static Car[] parkingSlot;

public Slot(int noOfFloor,int slotPerFloor) {
	this.noOfFloor=noOfFloor;
	this.slotPerFloor=slotPerFloor;
	Slot.parkingSlot=new Car[noOfFloor*slotPerFloor];
}

public Car[] getParkingSlot() {
	return parkingSlot;
}

public void setParkingSlot(Car[] parkingSlot) {
	Slot.parkingSlot = parkingSlot;
}

public int getNoOfFloor() {
	return noOfFloor;
}

public void setNoOfFloor(int noOfFloor) {
	this.noOfFloor = noOfFloor;
}

public int getSlotPerFloor() {
	return slotPerFloor;
}

public void setSlotPerFloor(int slotPerFloor) {
	this.slotPerFloor = slotPerFloor;
}
}
