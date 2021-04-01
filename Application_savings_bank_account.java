import java.util.Scanner;
public class Application_savings_bank_account {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //the number of customer whose savings account is to be created
        System.out.println("Enter the number of customer whose savings account is to be created: ");
        int num = s.nextInt();
        int[] customers_id = new int[num];
        //create a object of Customer class
        Customer[] bank_customer = new Customer[num];
        for(int i=0; i<num; i++){
            System.out.println();
            bank_customer[i] = new Customer();
                bank_customer[i].accept_details();
                System.out.println();
                customers_id[i] = bank_customer[i].getCustomer_ID();
                System.out.println("The customer ID of the customer: "+customers_id[i]);  
                System.out.println(); 
        }
        //display on screen the details of a particular customer by last name
        search_by_last_name(bank_customer, customers_id);
        //display a list of customers belonging to a particular taluk or village in a tabular format
        customer_details_village(bank_customer, customers_id);


        
    }
    //the function for display on screen the details of a particular customer by last name
    public static void search_by_last_name(Customer[] bank_customers, int[] village_customer_id){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the last name of the customer whose details you want to see: ");
        String last_name_customer = s.next();
        for(int i=0; i<bank_customers.length; i++){
            if(bank_customers[i].getLast_name().equalsIgnoreCase(last_name_customer)) {
                bank_customers[i].display_details();
                System.out.println("The customer-id: "+village_customer_id[i]);
            }
        }
    }
    //the function for display a list of customers belonging to a particular taluk or village in a tabular format
    public static void customer_details_village(Customer[] bank_customers, int[] village_customer_id){
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the village name from where you want to see the list of customer: ");
        String village_name= s.next();
        System.out.println("S.No.   Name     Mobile-no      Email-ID        Customer-ID");
        for(int i=0; i<bank_customers.length; i++){
            if(bank_customers[i].getAddress().getVillage().equals(village_name)) {
                System.out.println(i+1+"\t"+bank_customers[i].getFirst_name()+" "+bank_customers[i].getLast_name()+"\t"+bank_customers[i].getState_code()+"-"+bank_customers[i].getMobile()+"\t"+bank_customers[i].getEmail()+"\t"+"\t"+village_customer_id[i]);
            }
        }
    }
}
