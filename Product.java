
import java.util.ArrayList;
/*This class contains the informations of a single product and the available operations we can do
to a product*/
public class Product {
    
    private String name; ///This variable contains product name
    private int buyPrice, sellPrice, inventoryNumber; 
    private int totalProfit;

    Product(String name, int buyPrice, int sellPrice, int inventoryNumber, int totalProfit){
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.inventoryNumber = inventoryNumber;
        this.totalProfit = totalProfit;

    }

    /**
     * This method is used to access the name variable which is private (Ensures Encapsulation)
     */
    public String getName(){
        return name;
    }
     
    /**
     * This method is used to add a product to the ArrayList that contains every product object
     * @param list
     * @param name
     * @param b
     * @param c
     * @param d
     * @param tp
     * @param p
     */
    public void addProduct(ArrayList<Product>list, String name, int b, int c, int d, int tp, Product p){
        list.add(p);
    }
     
    /**
     * This method is used to delete a product from the ArrayList
     * @param list
     * @param name
     * @param availablebalance
     */
    public void deleteProduct(ArrayList<Product>list, String name){
        for(int i=0;i<list.size();i++){
            Product remove = list.get(i);
           
            if(remove.name.equals(name)){
                System.out.println(remove.name+" "+"is deleted from the list");
               list.remove(remove);
               
            }
          }
          
    }

    /**
     * This method is used to buy a product and it updates the inventory number and available balance 
        according to that product
     * @param list
     * @param name
     * @param availablebalance
     */
    public void buyProduct(ArrayList<Product>list, String name, int availableBalance){
        for(int i=0;i<list.size();i++){
            Product buy = list.get(i);
            if(buy.name.equals(name)){
               buy.inventoryNumber = buy.inventoryNumber + 1;
               availableBalance = availableBalance - buy.buyPrice;
               System.out.println("You buy this product"+" "+buy.name+" " + buy.buyPrice +" "+buy.sellPrice+" "+buy.inventoryNumber+" "+buy.totalProfit);
             }
        }
        
    }

    /**
     * This method contains the information after a product is sold by a user
     * @param list
     * @param name
     * @return ab(available balance)
     */
    public int sellProduct(ArrayList<Product>list, String name){
        int ab=0;
        for(int i=0;i<list.size();i++){
            Product sell = list.get(i);
            if(sell.name.equals(name)){
                
                if(sell.inventoryNumber !=0){
                   
                  sell.totalProfit = sell.sellPrice - sell.buyPrice;
                  ab = ab + sell.sellPrice;
                  
                  sell.inventoryNumber = sell.inventoryNumber - 1;
                  System.out.println("You sell this product"+" "+sell.name+" " + sell.buyPrice +" "+sell.sellPrice+" "+sell.inventoryNumber+" "+sell.totalProfit);
                }
                else{
                    System.out.println("The product is finished");
                    break;
                }
            }
        }
        
        return ab;
    }
    
    /**
     * This method helps a user to view the product information which are contained in an arraylist
       in a tabular format
     * @param list
     */
    public void viewProduct(ArrayList<Product>list){
          System.out.println("----------------------------------------------");
          System.out.printf("%-6s%20s%20s\n" , "name", "inventoryNumber", "totalProfit");
          System.out.println("----------------------------------------------");
      for(int i=0;i<list.size();i++){
          Product a = list.get(i);
          
          
          System.out.printf("%-6s%10d%25d\n" , a.name, a.inventoryNumber, a.totalProfit);
          System.out.println("----------------------------------------------");
          
      }
    }

    /**
     * This method helps a user to check the available balance when he wants to buy a product
     * @param t
     */
    public void checkAvailableBalance(int t){
      System.out.println("Available Balance is"+ " "+t);
    }

    }
    

