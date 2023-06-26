package com.adjecti.parkinglot.main;
import java.util.Scanner;

public class Main1 {
	
	private int floors;
    private int rows;
    private int columns;
    private static int[][][] parkingLot;
    
    public Main1(int floors, int rows, int columns) {
        this.floors = floors;
        this.rows = rows;
        this.columns = columns;
        this.parkingLot = new int[floors][rows][columns];
    }

	public static void main(String[] args) {
		Main1 pakingLot1=null;
		 System.out.println("---WELCOME TO PARKING LOT---");
	        System.out.println();
	       var sc = new Scanner(System.in);

	        boolean isParkingLotOpen = false;

	        while(true) {
	            System.out.println("---PLEASE ENTER YOUR CHOICE---");
	            System.out.println();
	            if(!isParkingLotOpen) {
	                System.out.println("1. DEFINE PARKING LOT");
	            }
	            System.out.println("2. PARK A VEHICLE");
	            System.out.println("3. UNPARK A VEHICLE");
	            System.out.println("4. STATUS CHECK OF PARKING LOT");
	            System.out.println("5. SEARCH THE VEHICLE");
	            System.out.println("6. EXIT");

	            int choice = sc.nextInt();

	            if(choice == 1) {
	                // DEFINE PARKING LOT
	                isParkingLotOpen = true;
	                System.out.println("ENTER THE NUMBER OF FLOORS IN PARKING LOT");
	                int floor = sc.nextInt();
	              
	                System.out.println("ENTER THE NUMBER OF ROWS IN PARKING LOT PER FLOOR");
	                int rows = sc.nextInt();
	                System.out.println("ENTER THE NUMBER OF COLUMNS IN PARKING LOT PER FLOOR");
	                int columns = sc.nextInt();
                     pakingLot1=new Main1(floor,rows,columns); 
                   
	                parkingLot = pakingLot1.getParkingLot(floor,rows, columns);
	                
	                pakingLot1.displayParkingLot();
	                
	            } else if (isParkingLotOpen && choice == 2) {
	                // PARK A VEHICLE - CHECK FOR THE FIRST EMPTY BLOCK
	            	pakingLot1.parkVehicleInParkingLot();
	                
	            } else if(isParkingLotOpen && choice == 3) {
	                // UNPARK A VEHICLE
	                System.out.println("ENTER THE FLOOR TO UNPARK A VEHICLE");
	                int floorNumber = sc.nextInt();
	                System.out.println("ENTER THE ROW NUMBER OF A FLOOR TO UNPARK A VEHICLE");
	                int rowNumber = sc.nextInt();
	                System.out.println("ENTER THE COLUMN NUMBER OF A FLOOR TO UNPARK A VEHICLE");
	                int columnNumber = sc.nextInt();

	                pakingLot1.unParkVehicleFromParkingLot(floorNumber, rowNumber, columnNumber);
	            } else if (isParkingLotOpen && choice == 4) {
	                // STATUS CHECK OF PARKING LOT
	            	pakingLot1.displayParkingLot();

	            }
	            else if(isParkingLotOpen && choice==5) {
	            	 System.out.println("ENTER THE FLOOR TO  A VEHICLE");
		                int floorNumber = sc.nextInt();
		                System.out.println("ENTER THE ROW NUMBER OF A FLOOR TO SEARCH A VEHICLE");
		                int rowNumber = sc.nextInt();
		                System.out.println("ENTER THE COLUMN NUMBER OF A FLOOR TO SEARCH A VEHICLE");
		                int columnNumber = sc.nextInt();
		                pakingLot1.findParkingLot(floorNumber, rowNumber,columnNumber);
	            }
	            else if(choice < 1 || choice > 5) {
	                System.out.println("---PARKING LOT IS CLOSED---");
	                System.out.println();
	                break;
	            }
	            System.out.println();
	        }
	    }

	private boolean  unParkVehicleFromParkingLot(int floor, int row,int column) {
		 if (this.parkingLot[floor][row-1][column-1] == 1) {
	            this.parkingLot[floor][row-1][column-1] = 0;
	            System.out.println("VECHILE UNPARKED FROM FLOOR " + floor + ", ROW " + row + ", COLUMN " + column);
	            return true;
	        } else {
	            System.out.println("NO VECHILE PARKED AT FLOOR " + floor + ", ROW " + row + ", COLUMN " + column);
	            return false;
	        }
		
	}

	private boolean  parkVehicleInParkingLot() {
		
		for (int i = 0; i < this.floors; i++) {
            for (int j = 0; j < this.rows; j++) {
                for (int k = 0; k < this.columns; k++) {
                	//check weather slots are empty or not
                    if (this.parkingLot[i][j][k] == 0) {
                        this.parkingLot[i][j][k] = 1;
                        System.out.println("VECHILE PARKED AT FLOOR " + (i) + ", ROW " + (j+1) + ", COLUMN " + (k+1));
                        return true;
                    }
                }
            }
        }
        System.out.println("SORRY, PARKING SLOT IS FULL!!!!");
        return false;
		
	}

	private  void displayParkingLot() {
		  for (int i = 0; i < this.floors; i++) {
	            System.out.println("Floor " + (i) + ":");
	            for (int j = 0; j < this.rows; j++) {
	                for (int k = 0; k < this.columns; k++) {
	                        System.out.print("*******");
	                    }
	                //To come in next row
	                System.out.println("*");
	                //For printing value if slots are empty otherwise print blank
	                for (int l = 0; l < this.columns; l++) {
	                    if (this.parkingLot[i][j][l] == 0) {
	                        System.out.print("|      ");
	                    } else {
	                        System.out.print("|" +"'O'" + (i) + "" + (j+1) + "" + (l+1));
	                    }
	                }
	             
	                System.out.println("|");
	            }
	            //for printing last column
	            for (int m = 0; m < this.columns; m++) {
	                System.out.print("*******");
	            }
	            System.out.println("*\n");
	        }
		
	}

	private  int[][][] getParkingLot(int floor, int rows2, int columns2) {
		int[][][] newParkingLot = new int[this.floors][this.rows][this.columns];
		 
	        for (int i = 1; i < this.floors-1; i++) {
	            for (int j = 0; j < this.rows; j++) {
	                for (int k = 0; k < this.columns; k++) {
	                	newParkingLot[i][j][k] = this.parkingLot[i][j][k];
	                }
	            }   
	        }
		return this.parkingLot=newParkingLot;
	}
private void findParkingLot(int floor,int row,int column){
	int[][][] newParkingLot1=new int[floors][rows][columns];
	for(int i=0;i<floors;i++) {
		for(int j=0;j<rows;j++) {
			for(int k=0;k<columns;k++) {
			 if((newParkingLot1[floor][row][column])==this.parkingLot[i][j][k]) {
				 System.out.println("VEHICLE AT THIS POSITION IS FOUND:"+(i) + "" + (j+1) + "" + (k+1));
				 break;
			 }
			 else {
				 System.out.println("NO VEHICLE AT THIS SLOT");
			 }
				
			}
		}
	}
	
}

	}


