/*MIS 350
Tommy Le, Grace Tan, Cindy Castro, Ngoc Do
12/02/2021
This program creates objects and call methods
*/

//import scanner to take user input, import arraylist to hold elements, import calendar to print time on receipt
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

//create public class 
public class Boba {
   public static void main (String[] args) {
      Scanner input = new Scanner(System.in);
      Calendar today = Calendar.getInstance();
      
      //Array that holds up to 100 objects
      Customers [] cust = new Customers[100];
     
      //set up accounts with number, name, and existing points
      cust[0] = new Customers("2028025152","Tommy",800);
      cust[1] = new Customers("7034209605","Cindy",500);
      cust[2] = new Customers("7034777908","Ngoc", 100);
      cust[3] = new Customers("6197614768","Grace", 800);
   
      //set up array list to store item name, item price, and each drink total
      ArrayList <String> items = new ArrayList<String>(); 
      ArrayList <Double> itemPrice = new ArrayList<Double>(); 
      ArrayList <Double> discount = new ArrayList<Double>();
   
      //set flag variables and String variables
      boolean flag4 = true;
      int p = 4;
      boolean fla = true;
      boolean lflag = true;
      boolean setflag = true;
      String cellNum = "";
      String blacktea = "black";
      String greentea = "green";
      
   //do-while loop to restart transaction
   do{
   System.out.println("|========================================|");
   System.out.println("|             BobaTime Menu              |");
   System.out.println("|Step 1: Choose a base                   |");
   System.out.println("|    Green tea or black tea        $ 4.00|");
   System.out.println("|Step 2: Add milk?                 $ 0.75|");
   System.out.println("|Step 3: Add Boba?                 $ 0.50|");
   System.out.println("|========================================|");
   
      //do-while loop to start another order
      do{
   System.out.print("Please enter your phone number (e.g., 1111111111): ");
   cellNum = input.next();
   if(check(cellNum) == false){
      System.out.print("Invalid input. Try again.\n");
   }
      else if (cellNum.length() != 10){
         System.out.print("Number needs to be exactly 10 digits. Please try again.\n");
      }
         else 
            setflag = false;
   }while(setflag == true);
   setflag = true;
   //search number to see if account exists   
   int rIndex = search(cust,cellNum, p);
   if(rIndex == -1){
      System.out.print("Please enter your first name: ");
      String nam = input.next();
      cust[p] = new Customers(cellNum, nam , 0);
      rIndex = p;
      p++;
      System.out.printf("\nWelcome %s!\n", nam);
      }
   else {
      System.out.printf("\nWelcome back %s! \n", cust[rIndex].getName());
   }
          System.out.println();

  //loop for type of tea
   do {
   boolean flag = true;
   do{
   System.out.print("Please enter your choice of tea (enter \"black\" or \"green\"): ");
   String tea = input.next();
   if(blacktea.equals(tea)) { 
      items.add("blacktea");
      itemPrice.add(4.00);
      flag = false;
   }
   else if (greentea.equals(tea)) {
      items.add("greentea");
      itemPrice.add(4.00);
      flag = false;
   }
   else 
      System.out.print("Invalid input\n");
   }while(flag == true);
   
   //loop if user wants boba
   boolean flag2 = true;
   do{
   System.out.print("Would you like to add boba? (enter \"1\" for boba or \"2\" for no boba): ");
   String answer = input.next();
      if("1".equals(answer)){
         items.add("Boba");
         itemPrice.add(.50);
         flag2 = false;
      }
      else if ("2".equals(answer)){
         items.add("Boba");
         itemPrice.add(0.00);
         flag2 = false;
      }
      else 
         System.out.print("Invalid input. Try again!\n");
   }while(flag2 == true);
   
   //loop for milk or no milk
   boolean flag3 = true;
   do{
   System.out.print("Would you like to add milk? (enter \"1\" for milk or \"2\" for no milk): ");
   String response = input.next();   
      if("1".equals(response)){
         items.add("Milk");
         itemPrice.add(.75);
         flag3 = false;
      } 
      else if ("2".equals(response)){
         items.add("Milk");
         itemPrice.add(0.00);
         flag3 = false;
      }
      else 
         System.out.print("Invalid input. Try again!\n");
    }while(flag3 == true);
   
   //loop if they want to add another item
   boolean fl = true;
   do{
   System.out.print("Would you like to add another item? (enter \"1\" for another order or \"2\" to end): ");
   String order = input.next();
   if ("2".equals(order)){
      fl = false;
      flag4 = false; 
   }
      else if ("1".equals(order)){
         fl = false;
         System.out.println();
      }
      else
         System.out.print("Invalid input. Try again!\n");
   }while(fl == true);
   }while(flag4 == true);
   flag4 = true;
   
   //display balance points
  System.out.println();
  System.out.printf("You have a balance of %d points.\n", cust[rIndex].getPoints());

 boolean flag5 = true;
 boolean flag6 = true;
 boolean bdisc = true;
 boolean fdisc = true;
 
 //if else condition to display awards based on points
 if (cust[rIndex].getPoints() < 20){ 
      System.out.printf("You can redeem a free topping once you earn 20 points or a free drink once you earn 100 points.\n");
      System.out.print("\nPrinting...");
      long startTime, endTime;
      long timeElapsed = 0;
      startTime = System.currentTimeMillis();
      while (timeElapsed /1000 < 4) {
      
      endTime = System.currentTimeMillis();
      timeElapsed = endTime - startTime;
     }
 }   
   
    else if (cust[rIndex].getPoints() >=20 && cust[rIndex].getPoints() < 100){
       do{
       System.out.printf("\nWould you like to use your 20 points for a free topping?\n(enter \"1\" for yes or \"2\" for no): ", cust[rIndex].getPoints());
       int use = input.nextInt();
         if (use == 1){
            cust[rIndex].minusPoints(20);
            bdisc = false;
            flag5 = false;
         }
         else if (use == 2){
            flag5 = false;  
         }
         else System.out.print("Invalid input. Try again."); 
   }while(flag5 == true);
      System.out.print("\nPrinting...");
      long startTime, endTime;
      long timeElapsed = 0;
      startTime = System.currentTimeMillis();
      while (timeElapsed /1000 < 4) {
      
      endTime = System.currentTimeMillis();
      timeElapsed = endTime - startTime;
      }
}
     
    else {
      do{
      System.out.printf("\nWould you like to use 100 points for a free drink or 20 points for a free topping?\nEnter \"1\" for free topping.\nEnter \"2\" for free drink.\nEnter \"0\" to save points.\n", cust[rIndex].getPoints());
      int use2 = input.nextInt();   
         if (use2 == 2){
            cust[rIndex].minusPoints(100);
            fdisc = false;
            flag6 = false;
         }
            else if (use2 == 1){
               cust[rIndex].minusPoints(20);
               bdisc = false;
               flag6 = false;
            }
               else if (use2 == 0){
                  flag6 = false;
               }  
         
         else System.out.print("Invalid. Try again.");
       }while(flag6 == true);
      System.out.print("\nPrinting...");
      long startTime, endTime;
      long timeElapsed = 0;
      startTime = System.currentTimeMillis();
      while (timeElapsed /1000 < 4) {
      
      endTime = System.currentTimeMillis();
      timeElapsed = endTime - startTime;
       }
     }
   
   

   //print out receipt
    System.out.println();
    System.out.println( "|==================================|");
    System.out.println( "|            BubblyTea             |");
    System.out.println( "|        4400 University Dr        |");
    System.out.println( "|        Fairfax, VA 22030         |");
    System.out.println( "|----------------------------------|");
    System.out.println( "|             Carryout             |");
    System.out.println( "|Cashier:TCGN                      |");
    System.out.printf(  "|%s\t\t  |\n", today.getTime());
    System.out.println( "|__________________________________|");
     
   
  //prints item price and name on the receipt 
  double sum =0;
   for (int i = 0; i < itemPrice.size();i++){
       if ("Boba".equals(items.get(i)) || "Milk".equals(items.get(i))){
         System.out.printf("|\t\t\t\t\t\t\t\t%s, $%.2f|\n", items.get(i),itemPrice.get(i));  
         }
         else {
            System.out.printf("|%s\t\t\t\t\t\t   $%.2f|\n", items.get(i), itemPrice.get(i));
         }                                              
          
      //adds the total for one drink
      sum += itemPrice.get(i);
      //adds each drink total to an array list 
      if ("Milk".equals(items.get(i))){
         System.out.println("|\t\t\t\t\t\t\t\t\t\t\t  |");
         discount.add(sum);
         sum = 0;
         }
      }
      
    //receipt portion for free toppings
      double totalSum;
      if (bdisc == false && flag5 == false || bdisc == false && flag6 == false ) {
         System.out.println("|Free topping                      |");
         System.out.println("|  .50 cents off (20 pts)\t  ($.50)|");
         System.out.println("|__________________________________|");
         System.out.printf("|Subtotal\t\t\t\t\t\t$%5.2f  |\n",(sum(discount))-(.50));
         totalSum = (sum(discount))-(.50);
         System.out.printf("|Tax     \t\t 6%%\t\t\t$%5.2f  |\n",(.06)*totalSum);
         System.out.println("|                                  |");
         System.out.printf("|total   \t\t\t\t\t\t$%5.2f  |\n", totalSum +((.06)*totalSum));
      }   
      //receipt portion for free drink
      else if (fdisc == false && flag6 == false){
            System.out.println("|Free Drink                        |");
            System.out.printf("|   (100 pts)\t             ($%.2f)|\n", min(discount));
            System.out.println("|__________________________________|");
            System.out.printf("|Subtotal\t\t\t\t\t\t$%5.2f  |\n",(sum(discount))-(min(discount)));
            totalSum = (sum(discount))-(min(discount));
            System.out.printf("|Tax     \t\t 6%%\t\t\t$%5.2f  |\n",(totalSum *.06));
            System.out.println("|                                  |");
            System.out.printf("|total   \t\t\t\t\t\t$%5.2f  |\n", totalSum +(.06*(sum(discount)-(min(discount)))));
            }
      //receipt portion for no rewards
          
      else { 
           System.out.println("|__________________________________|");
           System.out.printf("|Subtotal\t\t\t\t\t\t$%5.2f  |\n",sum(discount));
           totalSum = sum(discount);
           System.out.printf("|Tax     \t\t 6%%\t\t\t$%5.2f  |\n",.06*totalSum);
           System.out.println("|                                  |");
           System.out.printf("|Total   \t\t\t\t\t\t$%5.2f  |\n", totalSum +(.06*(sum(discount))));
         }
    //add points to customers account               
    cust[rIndex].addPoints(totalSum);
    //prints out customer's balance and goodbye message
    System.out.println( "|__________________________________|");
    System.out.printf(  "|Current point balance:\t\t %5.1f  |\n",(double)cust[rIndex].getPoints());
    System.out.println( "|----------------------------------|");
    System.out.println( "|     Every $1 spent = 1 point     |");
    System.out.println( "|----------------------------------|");
    System.out.println( "|            Thank you             |");
    System.out.println( "|         Have a good day!         |");
    System.out.println( "|==================================|"); 
    System.out.println();
       
    
    System.out.println();
    //loop for entire process
    boolean flagl = true;
    do{
    System.out.print("New transaction? (enter \"1\" to continue or \"0\" to stop): ");
      int answer = input.nextInt();
      if (answer == 0 ){
         System.out.print("\nThank you! Have a nice day!\n");
         flagl = false; 
         lflag = false;   
      } 
         else if (answer == 1){
         flagl = false;
         System.out.println();
         }
            else
               System.out.print("invalid user input.\n");
      }while(flagl == true);
      
    //removes all the elements from all array list
    discount.clear();
    items.clear();
    itemPrice.clear();
  }while(lflag == true);
            
}
     
         

  
 
 
 
 
   
   
         
      
      
         

//Method that sums each element within array list and returns a double value
  public static double sum(ArrayList <Double> discount) {
  double sum = 0;
  for (int i = 0; i < discount.size(); i++){
      sum += discount.get(i);
      }
      return sum;
  }
  
 //Method that checks if user input is a number and returns a boolean value 
  public static boolean check(String num){
      boolean isNum = true;
      for (int i = 0; i < num.length();i++)
         if (!Character.isDigit(num.charAt(i)))//charAt used to read char value at a given index. isDigit is apart of character class method that checks if a char is a digit and returns a boolean. isletter couldbe made to check letter.
            isNum = false;
            return isNum;
   }
   
   
   

   //Method that finds the smallest element within the array list and returns it as a double value
   public static double min(ArrayList <Double> discount) {
   double min = discount.get(0);
   for(int i = 0; i < discount.size(); i++)
      if (min > discount.get(i)){
         min = discount.get(i);
      }
      return min;
      }
      
 
   
   
   
   
   //Search method that finds associated number with the account
   public static int search(Customers []c,String cellNum, int p){
      for(int i = 0; i < p; i++)
         if (c[i].getcellNum().equals(cellNum)){
            return i;
         }
         return -1;
   
   }

}