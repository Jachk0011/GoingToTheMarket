import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/***********************************************************************************
* 
*WARNING: ALL THE METHODS IS BASED IN THE POSITION OF THE QUEUE NOT IN THE INDEX
* 
***********************************************************************************/

public class Queue {
	private Node head = null;
		
	public Node getHead()
	{
		return this.head;
	}
	
	// Tell us if the Queue is empty
	public boolean emptyQueue(){
		return (this.head!=null) ? false : true;
	}
	
	// return the size of he Queue as a integer
	public int sizeQueue()
	{
		int size = 1;
		if(emptyQueue())
			return 0;
		else
		{
			Node temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
				size++;
			}				
			return size;
		}
	}
	
	// Let print all nodes in the Queue using Buffered
	public void printQueue() throws IOException
	{
		if(this.emptyQueue())
			System.out.println("The list is empty");
		else
		{
			Node temp = head;
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while(temp != null)
			{
				br.write(temp.toString());
				temp = temp.next;
			} 
			br.flush();
			//br.close();
		}
		
	}

	public double searchDataNodeQueue(String product)
	{
		if(this.emptyQueue())
			return -1;
		else
		{
			Node tmp = this.getHead();
			
			if(tmp.text.equals(product))
				return tmp.data;
			else
			{
				tmp = tmp.next;
				while(tmp.text != product && tmp.next != null)
					tmp = tmp.next;	
				
				return tmp.data;			
			}						
		}
	}
	
	// add to Queue the new node get as parameter, according with FIFO 
	public void enqueue(Node n)
	{
		if(emptyQueue())
			this.head = n;
		else
		{
			Node temp = head;
			while(temp.next != null)		
				temp = temp.next;
			temp.next = n;
			n.next = null;
		}				
	}
	
	//delete the head of Queue according with FIFO
	public Node dequeue(){
		Node tmp = getHead();
		this.head = getHead().next;				
		tmp.next = null;		
		return tmp;
	}

}
