import java.util.ArrayList;
import java.util.Scanner;

/**
 This is our main class where all the operations on a product are done
 */
public class Ledger {
    
    
    public static void main(String args[]){
        ArrayList<Product>list = new ArrayList<Product>(); ///This is our main arraylist where the product is kept
        Product obj1=null;  ///Initially the object is null
        int availableBalance = 0;
        
        /**
         * Next we give users 7 options in a CLI to do any operation
         */

        System.out.println("Enter Your Choice: " + "\n"+"Press 0 to exit!"+"\n"+"Press 1 to add an element"+
        "\n"+"Press 2 to delete an element"+"\n"+"Press 3 to buy an element"+
        "\n"+"Press 4 to sell an element"+"\n"+
        "Press 5 to view the product"+"\n"+"Press 6 to check available balance");
        
        Scanner s = new Scanner(System.in);
        int choice1 = s.nextInt(); ///User can input any number here.
        /**
         * The loop will run until the user press 0
         */
        while(choice1!=0){
            if(choice1==0){
                break;
            }
            else if(choice1>6){
                System.out.println("You press the wrong button");       ///If the given number is greater than 6, it will perform no operation
            }
        else if(choice1 ==1){                      ///This block will create an object and add it to the list
            
            String name = s.next();
            int bp = s.nextInt();
            int sp = s.nextInt();
            int ip = s.nextInt();
            Product obj = new Product(name, bp, sp, ip, 0);
            obj1 = obj;
            obj.addProduct(list, name, bp, sp, ip, 0, obj );
            System.out.println(obj.getName() +" "+"is added to the list");
        }
            else if(choice1==2){                  ///This block will delete an object from the list
                
                
                if(list.size()>=1){   
                System.out.println("Do you want to delete some product? Enter the product name: ");
                String deleteProductName = s.next();
                obj1.deleteProduct(list, deleteProductName);
                
                
                }
                else{
                    System.out.println("Currently You dont have any product in list to delete");
                
                }
                
           }
    else if(choice1==3){                    ///This block will buy a product given the product name
        
        if(availableBalance >0){
              String name = s.next();
         obj1.buyProduct(list, name, availableBalance);
          }
          else{
            System.out.println("Currently You dont have enough money to buy a product"); 
            
          }
        
        
          
    }
    else if (choice1==4){                ///This block will sell a product given the product name
        if(list.size()>=1){ 
       String name = s.next();
       availableBalance = obj1.sellProduct(list, name);
       
        }
        else{
            System.out.println("You don't have any product in the list");
        }
    }
    else if(choice1==5){               ///This block will view the ArrayList
        obj1.viewProduct(list);
    }
    else if(choice1==6){            ///This block will check the availableBalance
        obj1.checkAvailableBalance(availableBalance);
    }
         /**
         * We will give options to do a operation until he inputs 0 in a CLI 
         */
     System.out.println("Do you want to continue?"+"\n"+"Press 0 to exit!"+"\n"+"Press 1 to add an element"+
    "\n"+"Press 2 to delete an element"+"\n"+"Press 3 to buy an element"+
    "\n"+"Press 4 to sell an element"+"\n"+
    "Press 5 to view the product"+"\n"+"Press 6 to check available balance");
    
    choice1 = s.nextInt();

    }
    

        
        
  }
}
    
    


