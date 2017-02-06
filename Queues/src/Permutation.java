import edu.princeton.cs.algs4.StdIn;

public class Permutation {
   public static void main(String[] args){
	  
	   
	   RandomizedQueue<Object> lista = new RandomizedQueue<Object>();
       int flag = 0;
       int num = 0;
       while (!StdIn.isEmpty()) {
	    	   if(flag == 0){
	    	   num = Integer.parseInt(StdIn.readString());
	    	   flag = 1;
	    	   continue;
    	   }
           String item = StdIn.readString();
           if (!item.equals(" "))
               lista.enqueue(item);
           
       for(int i = 0; i < num; i++)
    	   System.out.println(lista.sample());
     }
   }
}