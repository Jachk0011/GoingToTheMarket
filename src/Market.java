import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Market {
	static Queue market = new Queue(), 
			toBuy = new Queue();
	
	public void readFile()
	{
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		
		try 
		{
			file = new File ("test1.txt");
			fr = new FileReader (file);
			br = new BufferedReader(fr);
			int numCases = 0, counter = 0,
					numProductsMarket = 0,
					numProductsToGet = 0;
			double sum = 0;
			
			
			numCases = Integer.parseInt(br.readLine()); // got how many times the program needs run
			while(counter < numCases)
			{
				numProductsMarket = Integer.parseInt(br.readLine()); // got quantity of products in the store
				for(int i=0; i < numProductsMarket; i++)
				{
					StringTokenizer st = new StringTokenizer(br.readLine());
					market.enqueue(new Node(st.nextToken(), Double.parseDouble(st.nextToken()))); //fill market List
				}
				numProductsToGet = Integer.parseInt(br.readLine()); //got quantity of products to buy
				for(int i=0; i < numProductsToGet; i++)
				{
					StringTokenizer st = new StringTokenizer(br.readLine());
					toBuy.enqueue(new Node(st.nextToken(), Integer.parseInt(st.nextToken()))); //fill toBuy List
				}
				
				System.out.println("MARKET: ");
				market.printQueue();
				System.out.println("toBuy: ");
				toBuy.printQueue();
				
				Node tmp = toBuy.getHead();
				while(tmp.next != null)
				{
					System.out.println("temp.text: " + tmp.text +" cant: " +tmp.data);
					sum += (market.searchDataNodeQueue(tmp.text))*tmp.data; //searching and getting the prices of all products to buy
					
					tmp = tmp.next;
				}
				System.out.println("temp.text: " + tmp.text +" cant: " +tmp.data);
				sum += market.searchDataNodeQueue(tmp.text)*tmp.data; // necessary to catch the last node
				System.out.println(String.format("R$  %.2f", sum ));
				
				Node t1 = toBuy.getHead(), t2 = market.getHead();
				while(t1.next != null)
				{
					t1 = t1.next;
					toBuy.dequeue();					
				}
				toBuy.dequeue();
				while(t2.next != null)
				{
					t2 = t2.next;
					market.dequeue();					
				}
				market.dequeue();	
				
				counter++;
				sum = 0;
			}		
		}
		catch(Exception e)
	    {
			e.printStackTrace();	    
		}
		finally
		{	         
			try{                    
			    if( fr != null )   
			       fr.close();			                      
			 }catch (Exception e2){ 
			    e2.printStackTrace();
			 }
		}
	}
	
	public static void main(String[] args) {
		
		Market m = new Market();
		m.readFile();

	}

}
