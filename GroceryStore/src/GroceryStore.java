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
  }
}
