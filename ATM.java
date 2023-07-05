import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;
 class bankaccount{
     static void register(){
         Scanner sc =new Scanner (System.in);
         System.out.println("**************************");
         System.out.println("Enter your Name ");
         ATM.name=sc.nextLine();
         System.out.println("Enter your userName ");
         String user=sc.nextLine();
         System.out.println("Enter your password ");
         String pass=sc.nextLine();
         System.out.println("Enter your Account number ");
         ATM.accnumber=sc.nextLine();
         System.out.println("REGISTRATION SUCCESSFULLY");
         System.out.println("**************************");
         ATM.prompt();
         while(true)
         {
             display(ATM.name);
             int choice=sc.nextInt();
             if(choice==1)
             {
                 login(user,pass);
                 break;
             }
             else 
             {
                 if(choice==2){
                 System.exit(0);
             }
             else
             {
                 System.out.println("Bad value! Enter again");
             }
         }
     }
 }
static void display(String name){}
static void login(String user,String pass){}
}
class transaction{
    static void withdraw()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("Enetr amount to withdraw");
        int wcash=sc.nextInt();
        if(wcash<ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs" + wcash+"/-withdraw successfully");
            System.out.println("**************************");
        }
        else {
            System.out.println("Insufficient balance to withdraw the cash");
            System.out.println("**************************");
        }
        ATM.prompt(); 
    }
    static void deposit()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("Enetr amount to deposite");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer .toString(dcash));
        ATM.history.add("Deposite");
        System.out.println("Amount Rs" + dcash+"/-deposite successfully");
        System.out.println("**************************");
        ATM.prompt();   
    }
    static void transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receving body");
        String s=sc.nextLine();
        System.out.println("Enter the account number of receving body");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance)
        {
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("Transfered");
            System.out.println("Amount Rs" + tcash+"/-transferred successfully");
        }
        else{
            System.out.println("Insufficient balance to transfer the cash");
        }
            
    }
}
class check{
    static void checkbalance(){
      System.out.println("**************************");
      System.out.println("Available balance in the bank account:");
      ATM.showbalance();
      System.out.println("**************************");
      ATM.prompt();
    }            
}

class his{
    static void transactionhistory()
    {
        System.out.println("**************************");
        System.out.println("Transaction history");
        int k=0;
        if(ATM.balance>0){
            for( int i=0;i<(ATM.history.size()/2);i++){
                for(int j=0;j<2;j++)
                {
                    System.out.println(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("**************************");
            }
        }
        else{
            System.out.println("Account is empty");
    }
        ATM.prompt();
}
}
    
public  class ATM{
   public static String name;
   public static int balance=0;
   public static String accnumber;
   public static ArrayList<String> history= new ArrayList<String>();
   static void updatebalance(int dcash){
       balance=balance+dcash;
   }
   static void showbalance(){
       System.out.println(balance);
   }
   public static void homepage()
   {
     Scanner sc=new Scanner (System.in);
     System.out.println("Welcone to ATM interface");
     System.out.println("**************************");
     System.out.println("1.Register");
     System.out.println("2.exit");
     System.out.println("Enter your choice");
     int choice=sc.nextInt();
     if(choice==1){
         bankaccount.register();
     }
     else{
         if(choice==2){
             System.exit(0);
   }
         else{
             System.out.println("Select a value from given choice");
         }
         homepage();
     }
   }
   static void prompt()
   {
       Scanner sc=new Scanner (System.in);
       System.out.print("Welcome"+ATM.name+"! to ATM System");
       System.out.println("**************************");
       System.out.println("Select option");
       System.out.println("1.Withdraw");
       System.out.println("2.Deposit");
       System.out.println("3.Transfer");
       System.out.println("4.check balance");
       System.out.println("5.Transaction history");
       System.out.println("6.Exit");
       System.out.println("Enter your choice");
       int choice= sc.nextInt();
       switch(choice){
           case 1:
               transaction.withdraw();
           case 2:
               transaction.deposit();
           case 3:transaction.transfer();
           case 4:
               check.checkbalance();
           case 5:
               his.transactionhistory();
           case 6:
               System.exit(0);
              
       }
     
   }
   public static void main(String args[]){
       homepage();
   }
}
