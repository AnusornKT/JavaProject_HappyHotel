
public class HotelRoom{
	
	HotelRoom(){
			
	}
	
	// ############# Variables  #############
	public static int amtOfSingleRoom = 5;
	public static int amtOfDoubleRoom = 5;
	

	private String[] typeRoom = {
								"Single Room", "Double Room"
								};
	private String customerName;
	private int amountOfPeople;
	private int[] pricePernight= {150, 220};
	
	
	
	
	// ############# Methods  #############
	public String getTypeRoom(int tRoom){
		return typeRoom[0];
	}
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
	
	
	public void decreaseAmtSingRoom(int amtBookingSingRoom){
		amtOfSingleRoom = amtOfSingleRoom - amtBookingSingRoom;
	}
	

	public void displayName(){
		System.out.println("Customer Name: " + getCustomerName());
	}
	
}
