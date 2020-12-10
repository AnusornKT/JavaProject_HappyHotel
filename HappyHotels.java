import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  



public class HappyHotels {
	// amtOfSingleRoom = 5;
	// amtOfDoubleRoom = 5;
	// Room Type:
	// 1 - Single Room
	// 2 - Double Room

	public static void main(String[] args)
	{
		HotelRoom[] roomArr;
		
		roomArr = new HotelRoom[10];
		
		roomArr[0] = new HotelRoom();
		roomArr[1] = new HotelRoom();
		
		roomArr[0].setCustomerName("Jack");
		roomArr[0].setAmountOfPeople(2);
		
		roomArr[1].setCustomerName("Ma");
		roomArr[1].setAmountOfPeople(5);
		
		System.out.println("Name [0]: " + roomArr[0].getCustomerName()); 
		System.out.println("Name [1]: " + roomArr[1].getCustomerName()); 
		System.out.println("Length array of obj:" + roomArr.length); 
		roomArr[0].displayName();
		
		roomArr[1].decreaseAmtSingRoom(2);
		System.out.println(HotelRoom.getAmtOfSingleRoom());
		
		
		roomArr[0].decreaseAmtSingRoom(1);
		System.out.println(HotelRoom.getAmtOfSingleRoom());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E yyyy/MM/dd a HH:mm:ss ");  
		LocalDateTime now = LocalDateTime.now();  
		
		String currentDate;
		currentDate = dtf.format(now);
		
		System.out.println((dtf.format(now)));
		System.out.println(currentDate);  
	}



}
