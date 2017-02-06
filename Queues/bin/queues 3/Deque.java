import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
		   private SNode s;
		
		  //Model for Node creation
		   private class Node{
			  private Item item;
			  private Node next;
			  private Node prev;
		   }
		   //Node that will point to first and last nodes of the list and 
		   //say the size of the list
		   private class SNode{
				  private Integer item;
				  private Node next;
				  private Node prev;
		   }
		   
		   public Deque() {
			   s = new SNode();
			   s.item = 0;
			   s.next = null;
			   s.prev = null;
		   }
		   
		   public boolean isEmpty()  {
			   return s.item == 0;// is the deque empty?
		   }
		   public int size()      {
			   return s.item;// return the number of items on the deque
		   }
		   public void addFirst(Item item) {
			   if (item == null) {
			        throw new NullPointerException("Parameter Type cannot be null");
			    }
			   else if(!isEmpty()){
				   Node oldfirst = s.next;
				   Node a = new Node();
				   a.item = item;
				   a.next = oldfirst;
				   a.prev = null;
				   oldfirst.prev = a;
				   s.next = a;
				   s.item++;
			 
			  } 
			  else{
				  Node firstNode = new Node();
				  firstNode.item = item;
				  firstNode.prev = null;
				  firstNode.next = null;
				  s.next = firstNode;
				  s.prev = firstNode;
				  s.item++;
				 
			  }
		   }
		   public void addLast(Item item)    {
			   if (item == null) {
			        throw new NullPointerException("Parameter Type cannot be null");
			    }
			   else if(!isEmpty()) {
				   Node oldLast = s.prev;
				   Node b = new Node();
				   b.item = item;
				   b.next = null;
				   b.prev = oldLast;
				   oldLast.next = b;
				   s.prev = b;
				   s.item++;
			   }
			
			 else {
				  Node firstNode = new Node();
				  firstNode.item = item;
				  firstNode.prev = null;
				  firstNode.next = null;
				  s.prev = firstNode;
				  s.next = firstNode;
				  s.item++;
			 }
		   }
		   public Item removeFirst()  {
			  if(s.item == 0){
				  throw new NoSuchElementException();
			  }  
			  else if(s.item == 1){
				  Item b = s.next.item;
				  s.next = null;
				  s.prev = null;
				  s.item--;
				  return b;
			  }
			  else{
			   Item b = s.next.item;
			   s.next = s.next.next;
			   s.next.prev = null;
			   s.item--;
			   return b;
			  } 
		   }
		   public Item removeLast()  {
			   if(s.item == 0){
					  throw new NoSuchElementException();
			   } 
			   else if(s.item == 1){
					  Item b = s.prev.item;
					  s.next = null;
					  s.prev = null;
					  s.item--;
					  return b;
				  }
			   else{ 
			   Item c = s.prev.item;
			   s.prev = s.prev.prev;
			   s.prev.next = null;
			   s.item--;
			   return c;
			   }
		   }
		  public Iterator<Item> iterator()  {
			   // return an iterator over items in order from front to end
			  return new ListIterator();
		   }
		  private class ListIterator implements Iterator<Item> {
		        
				private Node current = s.next;
		        public boolean hasNext()  { return current != null;                     }
		        public void remove()      { throw new UnsupportedOperationException();  }

		        public Item next() {
		            if (!hasNext()) throw new NoSuchElementException();
		            Item item = current.item;
		            current = current.next; 
		            return item;
		        }
		    }
		   
		   
		   public static void main(String[] args)  {
			   		
			  }
			  
			   
}
		
		

