
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * GroceryStore
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

    //continuous input loop. 1 prints inventory, 2 restocks items, 3 exits the program
    while(!isDone){
      option = -1;
      System.out.println("Please select one of the following options:");
      System.out.println("1. Display inventory\n2. Restock inventory");
      System.out.println("3. Exit Program");

      try {
          option = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Please enter a valid option.");
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
            break;
          }
          //implmented in separate branch
          restockItem(itemNames, itemStocks, inputName, addItems);

        case 3:
          System.out.println("Terminating program.");
          isDone = true;
        default:
          System.out.println("Please enter a valid option.");
          break;
      }


    }

  }

}
