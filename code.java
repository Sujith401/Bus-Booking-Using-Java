package busTicketBooking;
import java.util.*;
public class BusReserve
{
	Scanner in = new Scanner(System.in);
	String user,password;
    int choice,rn,count,cno,pay,total;
    int available[] = new int[6];
    String desti[]={"1.CHENNAI","2.HYDERABAD","3.BANGALORE","4.COIMBATORE","5.TRICHY"};
    int price[]= {375,800,1200,300,250};
    public BusReserve()
    {
    	
		System.out.print("Enter Username: ");
		user = in.nextLine();
		System.out.print("Enter Password: ");
		password = in.nextLine();
		for(int o=1; o<=5; o++)
    	{
    		available[o]=20;
  		}
		option();
		
    }
    public void option()
    {
    	if(user.equals("1") && password.equals("1"))
    	{
    			System.out.println("********************************************");
    			System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
    			System.out.println("********************************************");
    			System.out.println("** [1] Destination                   **");
    			System.out.println("** [2] Passengers                    **");
    			System.out.println("** [3] Exit                          **");
    			System.out.println("***************************************");
    			System.out.println("***************************************\n");
    	}
    	else
    	{
    		System.err.println("\t\n1!!!!!!!!  Invalid Account  !!!!!!!!");
    		System.exit(0);
    	}
    	System.out.println("Enter Your choice:");
    	choice=in.nextInt();
    	switch(choice)
    	{
    	case 1:
    		destiNation();
    		break;
    		
    	case 2:
    		pass();
    		break;  		
    		
    	case 3:
    		exit();	
    	}
    }
    public void pass()
    {
    	System.out.println("Enter city No: ");
    	cno=in.nextInt();
    	System.out.println("Select How Many Seats You Want: ");
    	count=in.nextInt();
    	String passenger[]=new String[count];
    	for(int i=0;i<count;i++)
    	{
    		System.out.println("Enter Passenger Name " +(i+1)+" : ");
    		passenger[i]=in.next();	
    	}
    	bill(passenger);
 	
    }
    public void bill(String passenger[])
    {
    	System.out.println("\n***************************************");
		System.out.println("**        DETAILS                    **");
		System.out.println("***************************************");
		System.out.println("NO. OF PASSENGERS :	  " + count );
    	System.out.println("PASSEBGER NAME'S  :	  "+Arrays.toString(passenger));   
		System.out.println("PASSENGER'S DESTINATION : " + desti[cno-1] );
		System.out.println("PRICE OF 1 TICKET :	  " + price[cno-1]);
		total= price[cno-1]*count;
		System.out.println("TOTAL FARE PRICE  :	  Rs." + total);
		System.out.println("***************************************");
		System.out.println("***************************************\n");
		System.out.println("Pay Amount  : " );
		pay=in.nextInt();
		if(pay==total)
		{
			 available[cno]-=count;
			 int ackNo=(int)Math.ceil(Math.random()*10000000);
			 System.out.println("	Your Booking No : " + ackNo);
			 
		}
		else
		{
			System.err.println("Your payment is not correct.If you didn't pay accurate amount then it will refund to you!!");
		}
		System.out.println("\tDo you want another transaction? {1/0} : "); 
		rn=in.nextInt();
		if(rn==1)
			option();
		else
			exit();
    	
    }
	public void destiNation()
	{
		System.out.println("*****************************************");
		System.out.println("**   DESTINATION   |   FARE   |  SEAT  **");
		System.out.println("*****************************************");
		for(int i=0;i<5;i++)
		{
			System.out.println("  "+desti[i]+"\t\t"+price[i] +"	 "+ available[i+1]);
		}
		System.out.println("*****************************************");
		System.out.println("*****************************************\n");
		System.out.println("\tDo you want another transaction? {1/0} : "); 
		rn=in.nextInt();
		if(rn==1)
			option();
		else
			exit();
	}
	public void exit()
	{
		System.err.println("  Thank You!!");
		System.exit(0);
	}
	 public static void main(String args[])
	 {
		 	System.out.println("	Welcome To The Bus Booking Page	");
		 	BusReserve ob=new BusReserve();
		 	
	 }
		    	
}
