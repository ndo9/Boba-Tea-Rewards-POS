/*MIS 350
Tommy Le, Grace Tan, Cindy Castro, Ngoc Do
12/02/2021
This program creates objects and call methods

*/
public class Customers {

   //Instance variables
   private String cellNum;
   private int points;
   private String name;
    
   
   //Constructor
   public Customers(String num, String nam, int amount){
      cellNum = num;
      name = nam;
      points = amount;
      
      
   }
   
   //Methods to add/subtract points
   public void minusPoints(int amount){
      points -= amount;
   }
   
   public void addPoints(double amount){
      points += (int)amount; 
   }
   
   //Get methods 
   public String getcellNum(){
      return cellNum;
   }
   
   public int getPoints(){
      return points;
   }
   
   public String getName(){
      return name;
   }
   
   
   
 
   
   
   
   
   
   
   
}