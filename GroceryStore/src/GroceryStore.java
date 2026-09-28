
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * GroceryStore
 * @author zachary contreras
 */
public class GroceryStore {

  //maximum number of items in store
  final static  int MAX_ITEMS = 10;

  public static void main(String[] args) throws Exception {
    //arrays holding fields for each item... each index corresponds to the same item for 
    //ALL indices. Size determined at compilation
    
    String[] itemNames = new String[MAX_ITEMS];
    double[] itemPrices = new double[MAX_ITEMS];
    int[] itemStocks = new int[MAX_ITEMS];
    
    //accepts keyboard input
    Scanner input = new Scanner(System.in);

    boolean isDone = false;
    int option = 0;
    String inputName = "";
    int addItems = 0;

    //TESTING DATA
    itemNames = new String[]{"Apples", "Bananas", "Tangerines" , "", "Cups" , "Spoons" , "Forks", "Knives", "Potatoes", "Tomatoes"};

    itemPrices = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    itemStocks = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    //continuous input loop. 1 prints inventory, 2 restocks items, 3 exits the program
    while(!isDone){
      option = -1;
      System.out.println("Please select one of the following options:");
      System.out.println("1. Display inventory\n2. Restock inventory");
      System.out.println("3. Exit Program");

      try {
          option = input.nextInt();
      } catch (InputMismatchException e) {
        //System.out.println("Please enter a valid option.");
        input.nextLine();
      }
      
      switch(option){
        case 1:
          //implemented in other branch
          printInventory(itemNames, itemPrices, itemStocks);
          break;

        case 2:
          System.out.println("Please enter name of item: ");
          inputName = input.next();
          System.out.println("Please input number of items to add:");
          try {
              addItems = input.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("Please input a valid number.");
            input.nextLine();
            break;
          }
          //implmented in separate branch
          restockItem(itemNames, itemStocks, inputName, addItems);
          break;

        case 3:
          System.out.println("Terminating program.");
          isDone = true;
        default:
          System.out.println("Please enter a valid option.");
          break;
      }

      
    }
    input.close();

  }

  /*
  * Function to display complete inventory with associated names, prices and items left in stock
  * for all available items. Skips over empty items.
  * @param names array holding names for items
  * @param prices array holding prices for items
  * @param stocks array holding number of items in stock
  * @author zachary contreras
  */
  public static void printInventory(String[] names, double[] prices, int[] stocks){
    //iterate over each index, but only print data if the name is not null
    for(int i = 0; i < MAX_ITEMS; i++){
      if(names[i] != null && !names[i].isEmpty()){
        System.out.println(names[i] + "\t\t$" + prices[i] + "\t" + stocks[i]);
      }
    }
  }
  /**
   * Queries an item in the store via linear search and, if found, increases the stock
   * of the item by the specified number. If item is not found, print error message.
   * @param names container arary for names
   * @param stocks container array for stock values
   * @param target name of product to add items
   * @param amount amount of product to add
   */
  public static void restockItem(String[] names, int[] stocks, String target, int amount){
    //checkpoint for printing error message
    boolean found = false;
    //search for item index by name
    for(int i = 0; i < MAX_ITEMS; i++){
      //convert to all lowercase to eliminate case sensitivity
      if(names[i].toLowerCase().compareTo(target.toLowerCase()) == 0){
        //append amount
        stocks[i] += amount;
        found = true;
      }
    }

    if(!found){
      System.out.println("Item not found.");
    }
    
  }
}  
