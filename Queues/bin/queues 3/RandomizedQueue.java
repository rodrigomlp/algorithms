
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
   
	 private Item[] a;         // array of items
	 private int n;            // number of elements on array
	 
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		   a = (Item[]) new Object[2];
	        n = 0;
   }
   public boolean isEmpty() {
	   // is the queue empty?
	   return n == 0;
   }
   public int size() {
	   // return the number of items on the queue
	   return n;
   }
   public void enqueue(Item item) {
	   if (item == null) {
	        throw new NullPointerException("Parameter Type cannot be null");
	    }
        else if(n == a.length){
        	resize(2*a.length);    // double size of array if necessary
        }
       a[n++] = item;  
	   // add the item
   }
   public Item dequeue(){
	   if (isEmpty()) 
		   throw new NoSuchElementException("Underflow");
	   
	   //select random item in list
	   int ran = StdRandom.uniform(n);
	   
	  
	   Item item = a[ran];   
	   //swapping elements
	   Item temp = a[ran];
       a[ran] = a[n-1];
       a[n-1] = temp;
       
 
       a[n-1] = null;                              // to avoid loitering
       n--;
       // shrink size of array if necessary
       if (n > 0 && n == a.length/4) resize(a.length/2);
       return item;
	   
   }
   public Item sample()  {
	   if (isEmpty()) 
		   throw new NoSuchElementException("Underflow");
	   // return (but do not remove) a random item
	   int ran = StdRandom.uniform(n);
	   Item item = a[ran];
	   return item;
   }
   public Iterator<Item> iterator() {
       return new ReverseArrayIterator();
   }

   // an iterator, doesn't implement remove() since it's optional
   private class ReverseArrayIterator implements Iterator<Item> {
       private int i;

       public ReverseArrayIterator() {
    	   StdRandom.shuffle(a, 0, n);
    	   
           i = n-1;
       }

       public boolean hasNext() {
           return i >= 0;
       }

       public void remove() {
           throw new UnsupportedOperationException();
       }

       public Item next() {
           if (!hasNext()) throw new NoSuchElementException();
           return a[i--];
       }
   }
   // resize the underlying array holding the elements
   private void resize(int capacity) {
       

       // textbook implementation
       @SuppressWarnings("unchecked")
	   Item[] temp = (Item[]) new Object[capacity];
       for (int i = 0; i < n; i++) {
           temp[i] = a[i];
       }
       a = temp;

      // alternative implementation
      // a = java.util.Arrays.copyOf(a, capacity);
   }
   public static void main(String[] args){
	  
	  
		  
   }
}