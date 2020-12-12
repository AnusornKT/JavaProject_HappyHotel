
// ###################### Random Matrix ###################### 
// Written by Anusorn (K.T.) Kiattanaphon
// CSC240 - C40  Java Programming
// 03 December 2020
// Program purpose: A program to create a random matrix of 1's and 0's when
//					a user select what a number want to be display in the grid (10*10).
// 					The number can be either 1's, 0's, or random numbers.

// Import machines that we will use for this program:

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class HappyHotels extends Application{
	// Create gridRoot:
	static GridPane gridRoot = new GridPane();
	// Create TextArea for listing the all the rooms and guests:
	TextArea listingArea = new TextArea();
	HotelRoom[] roomArr;
	// ---- Available Rooms----
	// Single Rooms;
	Text singRoomAmntText = new Text();
	Text doubleRoomAmntText = new Text();
	int counter = 0;

	public void update_list(HotelRoom[] arrOfobj){
		
		int lengthOfCurrenObjArr = counter + 1;
		try{
			for(int i = 0; i < lengthOfCurrenObjArr; i++){	
				if(arrOfobj[i] != null){
					listingArea.appendText(arrOfobj[i].getGuestAllInfo());
				};
			};
		}catch(Exception e){
			System.out.print(e);
		}
		
	}
	
	public void checkOut_room(HotelRoom[] arrOfobj, String nameTocheckout){
		int lengthOfArray = counter;
		
		try{
			for(int i = 0; i < lengthOfArray; i++)
			{
				if(nameTocheckout.toLowerCase().equals(arrOfobj[i].getCustomerName().toLowerCase())){
					
						System.out.println("Customer " + arrOfobj[i].getCustomerName() + " has checked put!");
						if(arrOfobj[i].getCustomerRoomType().equals("Single Room")){
							HotelRoom.increaseAmtSingRoom();
							singRoomAmntText.setText(Integer.toString(HotelRoom.getAmtOfSingleRoom()));
						}else if(arrOfobj[i].getCustomerRoomType().equals("Double Room")){
							HotelRoom.increaseAmtDoubleRoom();
							doubleRoomAmntText.setText(Integer.toString(HotelRoom.getAmtOfDoubleRoom()));
						}
						arrOfobj[i] = null;
				};
			};
		}catch(Exception e){
			System.out.print(e);
		}
	}
	
	@Override
	public void start(Stage primaryStage){
		try
		{
			// amtOfSingleRoom = 5;
			// amtOfDoubleRoom = 5;
			// ----- Room Type ----:
			// 1 - Single Room
			// 2 - Double Room
						
			roomArr = new HotelRoom[10];
			listingArea.setEditable(false);
			listingArea.setPrefSize(450, 500);
			
			// ##### Recheck #####
			// Add this string to listingArea once the program is first open.
			listingArea.appendText("Welcome to Happy Hotel System...");
		
			
			// -------------------------------  Date ----------------------------------
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E yyyy/MM/dd a HH:mm:ss ");  
			LocalDateTime now = LocalDateTime.now();  
			
			String currentDate;
			currentDate = dtf.format(now);
			
			System.out.println((dtf.format(now)));
			System.out.println(currentDate);  
			
			

			// ############################# JavaFX: Stages ###############################
			// ############################## Primary Stage: ##############################
			// --------------------------- root & Boxes ----------------------------- 
			// Create a vertical box:
			VBox root = new VBox();
			
			// rootPS:
			root.setSpacing(20);
			root.setBackground(new Background(new BackgroundFill(Color.web("#222831"), null, null)));
			// Set width and length of the scene:
			Scene scene = new Scene(root, 1000, 800);
			
			// Create a sub horizontal boxes for heading, button:
			HBox singRoomAmtPS = new HBox();
			HBox doubleRoomAmtPS = new HBox();
			HBox headingPS = new HBox();
			HBox buttonPS = new HBox();
			HBox contentPS = new HBox();
			
			// ---------------------------------- Available Rooms --------------------------------
			// Single Rooms;
			Text availableSingRoom = new Text();
			availableSingRoom.setText("Available Single room: ");
			availableSingRoom.setFont(Font.font("monaco", FontWeight.LIGHT, FontPosture.REGULAR, 20));
			availableSingRoom.setFill(Color.WHITE);
			
			
			
			
			singRoomAmntText.setText(Integer.toString(HotelRoom.getAmtOfSingleRoom()));
			singRoomAmntText.setFont(Font.font("monaco", FontWeight.LIGHT, FontPosture.REGULAR, 20));
			singRoomAmntText.setFill(Color.WHITE);
			
			// Add text fields to the primary state(PS):
			singRoomAmtPS.getChildren().add(availableSingRoom);
			singRoomAmtPS.getChildren().add(singRoomAmntText);
			singRoomAmtPS.setAlignment(Pos.CENTER_LEFT);
			
			
			// Double Rooms;
			Text availableDoubRoom = new Text();
			availableDoubRoom.setText("Available Double room: ");
			availableDoubRoom.setFont(Font.font("monaco", FontWeight.LIGHT, FontPosture.REGULAR, 20));
			availableDoubRoom.setFill(Color.WHITE);
			
			
			doubleRoomAmntText.setText(Integer.toString(HotelRoom.getAmtOfDoubleRoom()));
			doubleRoomAmntText.setFont(Font.font("monaco", FontWeight.LIGHT, FontPosture.REGULAR, 20));
			doubleRoomAmntText.setFill(Color.WHITE);
			
			// Add text fields to the primary state(PS):
			doubleRoomAmtPS.getChildren().add(availableDoubRoom);
			doubleRoomAmtPS.getChildren().add(doubleRoomAmntText);
			doubleRoomAmtPS.setAlignment(Pos.CENTER_LEFT);
			
			// ---------------------------------- headingText --------------------------------
			// Create Heading (Title):
			Text headingText = new Text();
			headingText.setText("Happy Hotel");
			headingText.setFont(Font.font("monaco", FontWeight.LIGHT, FontPosture.REGULAR, 40));
			headingText.setFill(Color.WHITE);
			headingPS.getChildren().add(headingText);
			headingPS.setAlignment(Pos.CENTER);
			
			
			// --------------------------------- ButtonsPS ---------------------------------
			buttonPS.setSpacing(15);
			// Create buttons for do specific tasks:
			Button btnRegister = new Button("Register / Check In");
			Button btnCheckOut = new Button("Check Out");
			Button btnQuit = new Button("Quit");
						
			buttonPS.getChildren().add(btnRegister);
			buttonPS.getChildren().add(btnCheckOut);
			buttonPS.getChildren().add(btnQuit);
			buttonPS.setAlignment(Pos.CENTER);

			
			
			// ########################### Secondary Stage ##########################
			VBox rootSS = new VBox();
			rootSS.setSpacing(10);
					
			// Set width and length of the scene:
			Scene sceneSS = new Scene(rootSS, 500, 250);
			Stage secondaryStage = new Stage();

			// --------------------------------- ButtonSS ---------------------------
			HBox buttonSS = new HBox();
			buttonSS.setSpacing(15);
			Button btnRegisSS = new Button("Register");
			Button btnCancelSS = new Button("Cancel");
			buttonSS.getChildren().add(btnRegisSS);
			buttonSS.getChildren().add(btnCancelSS);
			buttonSS.setAlignment(Pos.CENTER);
			
			// -------------------------------- TextField ---------------------------
			// Create text fields to get the user input:
			TextField customerName = new TextField();
			TextField amntOfguest = new TextField();
			
			// Both fields should be wide enough to display 15 chars
			customerName.setPrefColumnCount(15);
			amntOfguest.setPrefColumnCount(15);
			
			// -------------------------------- rootInput ---------------------------
			GridPane rootSSinput = new GridPane();
			// Set the horizontal spacing to 10px
			rootSSinput.setHgap(10);
						
			// Set the vertical spacing to 5px
			rootSSinput.setVgap(10);

			
			// Add Date:
			Label currentDateLbl = new Label("Registration Date: ");
			Label dateRegister = new Label();
			rootSSinput.addRow(1, currentDateLbl, dateRegister);
			
			
			
			// Add  Fields to the GridPane
			rootSSinput.addRow(2, new Label("Guest name: "), customerName);
			rootSSinput.addRow(3, new Label("Amount of people: "), amntOfguest);

						
			// Set the Size of the GridPane
			rootSSinput.setMinSize(250, 150);
						
			rootSSinput.setStyle("-fx-padding: 10;" +
				                "-fx-border-style: solid inside;" +
				                "-fx-border-width: 2;" +
				                "-fx-border-insets: 5;" +
				                "-fx-border-radius: 5;" +
				                "-fx-border-color: grey;");
			


			// --------------------------------- CheckBox SS ------------------------
			// Create the Label for the Car
			Label roomTypeLbl = new Label("Room Type: ");
			
			// Create a ChoiceBox for cars:
			ChoiceBox<String> roomTypesBox = new ChoiceBox<>();
			// Add the items to the ChoiceBox
			roomTypesBox.getItems().addAll("Single Room", "Double Room");
			
			// Create the Selection Message Label
			Label customerRoomChoice = new Label("Customer selection: ");
			
			// Create the Selection Value Label
			Label selectedValueRoomType = new Label();
			
			// Bind the value property to the text property of the Label
			selectedValueRoomType.textProperty().bind(roomTypesBox.valueProperty());
			
			
			rootSSinput.addRow(4, roomTypeLbl,roomTypesBox);
			rootSSinput.addRow(5, customerRoomChoice, selectedValueRoomType);

			
			contentPS.setAlignment(Pos.CENTER);
			contentPS.getChildren().add(listingArea);
			
			
			// ########################### Third Stage ##########################
			VBox rootTD = new VBox();
			rootTD.setSpacing(10);
			
			// Set width and length of the scene:
			Scene sceneTD = new Scene(rootTD, 500, 200);
			Stage thirdStage = new Stage();
			
			// --------------------------------- ButtonSS ---------------------------
			HBox buttonTD = new HBox();
			buttonTD.setSpacing(15);
			Button btnCheckOutTD = new Button("Check out");
			Button btnCancelTD = new Button("Cancel");
			buttonTD.getChildren().add(btnCheckOutTD);
			buttonTD.getChildren().add(btnCancelTD);
			buttonTD.setAlignment(Pos.CENTER);

			// -------------------------------- TextField ---------------------------
			// Create text fields to get the user input:
			TextField checkOutName = new TextField();
		
			// The field should be wide enough to display 15 chars
			checkOutName.setPrefColumnCount(20);

			// -------------------------------- rootInput ---------------------------
			GridPane rootTDinput = new GridPane();
			// Set the horizontal spacing to 10px
			rootTDinput.setHgap(10);
				
			// Set the vertical spacing to 10px
			rootTDinput.setVgap(10);
			
			// Add Date:
			Label checkOutNameLbl = new Label("Check out name: ");
			rootTDinput.addRow(1, checkOutNameLbl, checkOutName);
	
			// Set the Size of the GridPane
			rootTDinput.setMinSize(250, 150);
			rootTDinput.setAlignment(Pos.CENTER);
			
			
			
			
			// ####################### Button EvenListener (SS) ########################
			btnRegisSS.setOnAction(new EventHandler<ActionEvent>()
	        {
			    @Override public void handle(ActionEvent e)
			    {
					
			    	listingArea.clear();


			    	System.out.println(selectedValueRoomType.getText());
			    	roomArr[counter].setCustomerRoomType(selectedValueRoomType.getText());
			    	
			  
			    	System.out.println(customerName.getText());
			    	roomArr[counter].setCustomerName(customerName.getText());
			    	
			    	
			    	System.out.println(amntOfguest.getText());
			    	int numOfcustGuest = Integer.parseInt(amntOfguest.getText());
			    	roomArr[counter].setAmountOfPeople(numOfcustGuest);
			    	
			    
			    	// Add the guest registration to the list:
			    	// listingArea.appendText(update_List(roomArr, counter));
			    	update_list(roomArr);
			    	
			    	// Decrease the room amount:
			    	if(selectedValueRoomType.getText().equals("Single Room")){
			    		System.out.println("It's equal to a single room.");
			    		HotelRoom.decreaseAmtSingRoom(1); 
			    		singRoomAmntText.setText(Integer.toString(HotelRoom.getAmtOfSingleRoom()));
			    	}else if(selectedValueRoomType.getText().equals("Double Room")){
			    		System.out.println("It's equal to a double room.");
			    		HotelRoom.decreaseAmtDoubleRoom(1);
			    		doubleRoomAmntText.setText(Integer.toString(HotelRoom.getAmtOfDoubleRoom()));
			    	}
			    	
			    	// ###### Recheck ######
			    	System.out.println("Amount of single room: " + HotelRoom.getAmtOfSingleRoom());
			    	System.out.println("Amount of double room: " + HotelRoom.getAmtOfDoubleRoom());
			    	
			    	// Update the counter:
			    	counter = counter + 1;
			    	
			    	System.out.println("Counter: " + counter);

			    	// Close the secondary stage:
			    	secondaryStage.close();
			    }
			});
			
			btnCancelSS.setOnAction(new EventHandler<ActionEvent>()
	        {
			    @Override public void handle(ActionEvent e)
			    {
			    	secondaryStage.close();
			    }
			});
			
			// ####################### Button EvenListener (PS) #########################
			// Button for register:
			btnRegister.setOnAction(new EventHandler<ActionEvent>()
	        {
			    @Override public void handle(ActionEvent e)
			    {
			    	roomArr[counter] = new HotelRoom();
			    	DateTimeFormatter liveCurrentDate = DateTimeFormatter.ofPattern("E yyyy/MM/dd a HH:mm:ss ");  
					LocalDateTime dtnow = LocalDateTime.now();  
										
			    	dateRegister.setText(liveCurrentDate.format(dtnow));
			    	String custRegisDate = liveCurrentDate.format(dtnow);
			    	roomArr[counter].setDate(custRegisDate);
			    	
			    	// Clear all the input values:
			    	customerName.clear();
					amntOfguest.clear();
			    	secondaryStage.show();
			    }
			});

			btnCheckOut.setOnAction(new EventHandler<ActionEvent>()
	        {
			    @Override public void handle(ActionEvent e)
			    {
			    	System.out.println("At btnCheckOut --- Current counter is " + counter);
			    	thirdStage.show();
			    }
			});
			
			
			// Button for quit the program:
			btnQuit.setOnAction(new EventHandler<ActionEvent>()
	        {
			    @Override public void handle(ActionEvent e)
			    {
			    	primaryStage.close();
			    }
			});
			
			
			// ####################### Button EvenListener (TD) #########################
			btnCheckOutTD.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent e)
				{	
					listingArea.clear();
					System.out.println("Check Out Name: " + checkOutName.getText());
					String custNameForCheckout = checkOutName.getText();
					checkOut_room(roomArr, custNameForCheckout);
					

					// Update the counter:
			    	counter = counter - 1;
					update_list(roomArr);
					thirdStage.close();
				}
			});
						
			btnCancelTD.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent e)
				{
					thirdStage.close();
				}
			});

			// ############################### Third Stage: TD ##################################
			// rootTD
			rootTD.getChildren().add(rootTDinput);
			rootTD.getChildren().add(buttonTD);
			thirdStage.setTitle("Check Out");
			thirdStage.setScene(sceneTD);


			// ############################# Secondary Stage: SS  ###############################
			// rootSS
			rootSS.getChildren().add(rootSSinput);
			rootSS.getChildren().add(buttonSS);
			secondaryStage.setTitle("Registration / Checking In");
			secondaryStage.setScene(sceneSS);
			
			// ############################## Primary Stage: PS #################################
			// rootPS:
			root.getChildren().add(headingPS);
			root.getChildren().add(singRoomAmtPS);
			root.getChildren().add(doubleRoomAmtPS);
			root.getChildren().add(buttonPS);
			root.getChildren().add(contentPS);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Happy Hotel");
			primaryStage.show();
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	public static void main(String[] args)
	{
		Application.launch();
		
	}

}
