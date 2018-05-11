
public class Node {
	public double data;	
	public String text;
	public Node next;
	
	//CONSTRUCTORS 
	public Node (){}
	
	public Node (String text, double price)
	{
		this.text = text;
		this.data = price;
	}
	
	// NICE VIEW DATA
	public String toString()
	{
		return "Product: " + this.text +  " price: " + data + "\n";
	}
	
	
	
	
}
