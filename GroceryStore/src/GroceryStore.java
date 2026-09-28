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
      if(names[i] != null){
        System.out.println(names[i] + "\t$" + prices[i] + "\t" + stocks[i]);
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
      if(names[i].compareTo(target) == 0){
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
