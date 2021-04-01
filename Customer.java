import java.util.Random;
import java.util.Scanner;
public class Customer {
    private String first_name;    //required
    private String last_name;     //required
    private String state_code;
    private String mobile_no;     //required
    private String email;         //not required
    private Address address = new Address();       //required

    private int customer_ID;
    
    public String getFirst_name() {
        first_name = first_name.substring(0,1).toUpperCase() + first_name.substring(1);
        return first_name;
    }
    public void setFirst_name(String first_name) {
         this.first_name = first_name;
    }

    public String getLast_name() {
        last_name = last_name.substring(0,1).toUpperCase() + last_name.substring(1);
        return last_name;
    }
    public void setLast_name(String last_name) {
         this.last_name = last_name;
    }

    public String getState_code() {
        return state_code;
    }
    public void setState_code(String state_code) {
         this.state_code = state_code;
    }

    public String getMobile() {
        return mobile_no;
    }
    public void setMobile(String mobile_no) {
         this.mobile_no = mobile_no;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }

    public Address getAddress() {
        return address;
    }

    public int getCustomer_ID() {
        Random rand = new Random();
        customer_ID = rand.nextInt(100000);
        return customer_ID;
    }


    public Customer(){

    }

    public void accept_details(){
        Scanner s = new Scanner(System.in);
        //read first name from user and its required
        System.out.println("Enter your first name:");
        first_name=s.next().toLowerCase();
        //read last name from user and its required
        System.out.println("Enter your last name:");
        last_name=s.next().toLowerCase();
        //read state code phone number from user that contains 2 digits (required)
        do{
        System.out.println("Enter your state-code phone number: ");
        state_code=s.next();
        if(!(state_code.length()==2)){
            System.out.println("Entered state-code phone number is not valid. Please enter 2 digit state-code phone number.");
        }
        }while(!(state_code.length()==2));
        //read mobile number from user that contains 10 digits (required)
        do{
        System.out.println("Enter your mobile number: ");
        mobile_no=s.next();
            if(!(mobile_no.length()==10)){
                System.out.println("Entered phone no is not valid. Please enter 10 digit mobile number.");
            }
        }while(!(mobile_no.length()==10));
        // (not required) read email ID from user that contains @ and .com
        System.out.println("Do you have email ID \"Enter y for yes and n for no\"");
        char choice = s.next().charAt(0);
        while(choice=='y'){
            do{
                System.out.println("Enter your email id (optional) (example@gmail.com):");
                email=s.next();
                if(!(email.contains("@")&&email.contains(".com"))){
                    System.out.println("Entered email ID is not valid. Please enter a email Id that contains \"@\" and \".com\".");
                }
            }while(!(email.contains("@")&&email.contains(".")));
        choice='n';
        }
        //read address of the customer from user (Street name, City name, State, Zip-Code) (required)
        address.accept_address();
    }

    public void display_details(){
        System.out.println();
        System.out.println("The details of the customer: ");
        System.out.println();
        System.out.println("Name: "+getFirst_name()+ " " +getLast_name());
        System.out.println("Mobile number including state code: "+state_code+"-"+mobile_no);
        if(email!=null){
            System.out.println("The email ID of customer: "+email);
        }
        System.out.print("The address of the customer: ");
        address.display_address();
    }
    // public void display_details_tabular() {
    //     for(int i=0; i<6; i++){
    //         if(i==0){
    //             System.out.print(i+1);
    //         }else if(i==1){
    //             System.out.print(getFirst_name()+getLast_name());
    //         }else if(i==2){
    //             System.out.print(getState_code()+"-"+getMobile());
    //         }else if(i==3){
    //             System.out.print(getEmail());
    //         }else if(i==4){
    //             address.display_address();
    //         }else{
    //             System.out.print(getCustomer_ID());
    //         }
    //     }
    // }
}