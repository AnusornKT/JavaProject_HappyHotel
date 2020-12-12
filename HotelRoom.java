
public class HotelRoom{
	
	HotelRoom(){
			
	}
	
	// ############# Variables  #############
	public static int amtOfSingleRoom = 5;
	public static int amtOfDoubleRoom = 5;
	


	private String customerName;
	private String date;
	private String customerRoomType;
	

	private int amountOfPeople;
	private int[] pricePernight= {150, 220};
	
		
	// ############# Methods  #############
	public String getCustomerName(){
		return customerName;
	}
	public int getAmountOfPeople(){
		return amountOfPeople;
	}
	public int getPricePernight(int tRoom){
		return pricePernight[tRoom];
	}

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	public void setAmountOfPeople(int amountOfPeople){
		this.amountOfPeople = amountOfPeople;
	}
	public void setPricePernight(int[] pricePernight){
		this.pricePernight = pricePernight;
	}
	
	// ###### Getter/Setters: Customer's Room Type ######
	public String getCustomerRoomType() {
		return customerRoomType;
	}
	public void setCustomerRoomType(String customerRoomType) {
		this.customerRoomType = customerRoomType;
	}
	
	// ###### Getter/Setters: Customer Date ######
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	// ###### Getter/Setters: Amount of Single Room ######
	public static int getAmtOfSingleRoom(){
		return amtOfSingleRoom;
	}

	public static void setAmtOfSingleRoom(int amtOfSingleRoom){
		HotelRoom.amtOfSingleRoom = amtOfSingleRoom;
	}
	
	
	// ######  Getter/Setters: Amount of Double Room ###### 
	public static int getAmtOfDoubleRoom(){
		return amtOfDoubleRoom;
	}
	
	public static void setAmtOfDoubleRoom(int amtOfDoubleRoom){
		HotelRoom.amtOfDoubleRoom = amtOfDoubleRoom;
	}
	
	// ### Getter/Setters: Update the amount of rooms based on type ###### 
	public static void decreaseAmtSingRoom(int amtBookingSingRoom){
		amtOfSingleRoom = amtOfSingleRoom - amtBookingSingRoom;
	}
	
	public static void decreaseAmtDoubleRoom(int amtBookingDoubRoom){
		amtOfDoubleRoom = amtOfDoubleRoom - amtBookingDoubRoom;
	}
	
	public static void increaseAmtSingRoom(){
		amtOfSingleRoom = amtOfSingleRoom + 1;
	}
	
	public static void increaseAmtDoubleRoom(){
		amtOfDoubleRoom = amtOfDoubleRoom + 1;
	}
	

	// displayName()
	public void displayName(){
		System.out.println("Customer Name: " + getCustomerName());
	}
	
	// Return a string of a guest info:
	public String getGuestAllInfo(){
		return "Name: " + customerName + 
				"\nAmount of people: " + Integer.toString(amountOfPeople) + 
				"\nDate: " + date +
				"\nRoom type: " + customerRoomType +
				"\n\n";
	}
	
}
