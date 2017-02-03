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
			  if(!(s.item==0)){
			   Node oldfirst = s.next;
			   Node a = new Node();
			   a.item = item;
			   a.next = oldfirst;
			   a.prev = null;
			   oldfirst.prev = a;
			   s.next = a;
			   s.item++;
			   System.out.println("Added " + s.next.item + " to front") ;
			  } 
			  else{
				  Node firstNode = new Node();
				  firstNode.item = item;
				  firstNode.prev = null;
				  firstNode.next = null;
				  s.next = firstNode;
				  s.prev = firstNode;
				  s.item++;
				  System.out.println("First note is " + firstNode.item);
			  }
		   }
		   public void addLast(Item item)    {
			if(!(s.item==0)){
			   Node oldLast = s.prev;
			   Node b = new Node();
			   b.item = item;
			   b.next = null;
			   b.prev = oldLast;
			   oldLast.next = b;
			   s.prev = b;
			   s.item++;
			   System.out.println("Added " + s.prev.item + " to back");
			}
			else{
			  Node firstNode = new Node();
			  firstNode.item = item;
			  firstNode.prev = null;
			  firstNode.next = null;
			  s.prev = firstNode;
			  s.next = firstNode;
			  s.item++;
			  System.out.println("Added " + s.prev.item + " to back");
			}
		   }
		   public Item removeFirst()  {
			  if(s.item == 0){
				  throw new NoSuchElementException();
			  }  
			   Item b = s.next.item;
			   s.next = s.next.next;
			   s.next.prev = null;
			   s.item--;
			   return b;
			   
		   }
		   public Item removeLast()  {
			   if(s.item == 0){
					  throw new NoSuchElementException();
			   } 
			   Item c = s.prev.item;
			   s.prev = s.prev.prev;
			   s.prev.next = null;
			   s.item--;
			   return c;
			   
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

