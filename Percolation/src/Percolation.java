import edu.princeton.cs.algs4.WeightedQuickUnionUF;


 public class Percolation {
     private int[][] grid;
     private WeightedQuickUnionUF obj;
     private WeightedQuickUnionUF obj2;
     private  int lastSite;
     private  int numSites;
     private int side;
     private  int sizeOfGrid;
     
  public Percolation(int n) {
         
         this.side = n;
         
         if (n < 0) {
          throw new IllegalArgumentException();
         }
      
      // connect different sites
      
      createConnect(n);
      
      // initialize grid to have n+1 to account for 0 and n+1 that keeps track if
      // system is percolated
      
      grid = new int[n+1][n+1];
     
     
     }
   
     private int mapping(int row, int col) {
       return (row-1)*side + col;
     }
     
     private void check(int row, int col) {
     
      int num = mapping(row, col);
      if (num < 0 || num > lastSite)
    	  throw new IndexOutOfBoundsException();
     }
     
     private void createConnect(int n) {
    
      int lastRow = n*n-n+1;
      sizeOfGrid = n*n;
      lastSite = n*n+1;
      
      
      /* keeps track of connection of sites. 0 and n+1 are virtual sites connected
      to the first and last row respectively
      */
      
      obj = new WeightedQuickUnionUF(sizeOfGrid+2);
     obj2 = new WeightedQuickUnionUF(sizeOfGrid + 1);
      
      // connects virtual site n with first row
      
      for (int a = 1; a <= n; a++) {
       obj.union(a, 0);
       obj2.union(a, 0);
      }
      
      // connects virtual site n+1 with last row
      
      for (int b = lastRow; b <= sizeOfGrid; b++) {
       obj.union(b, lastSite);
      }
      
     }
     
     
   
     public void open(int row, int col)  {
      
      check(row, col);
      
      if (!isOpen(row, col)) {
       if (row != 1 && isOpen(row-1, col)) {
        obj.union(mapping(row, col), mapping(row-1, col));
        obj2.union(mapping(row, col), mapping(row-1, col));
       }
       if (row != side && isOpen(row+1, col)) {
        obj.union(mapping(row, col), mapping(row+1, col));
        obj2.union(mapping(row, col), mapping(row+1, col));
       }
       if (col != 1 && isOpen(row, col-1)) {
        obj.union(mapping(row, col), mapping(row, col-1));
        obj2.union(mapping(row, col), mapping(row, col-1));
       }
       if (col != side && isOpen(row, col+1)) {
        obj.union(mapping(row, col), mapping(row, col+1));
        obj2.union(mapping(row, col), mapping(row, col+1)); 
       }
       grid[row][col] = 1;
       numSites++;
       
     }
 
   }
     public boolean isOpen(int row, int col) {
      check(row, col);
      // is site (row, col) open?
      return grid[row][col] == 1;
     }
     
     
     public boolean isFull(int row, int col) {
      check(row, col);
      
       if(isOpen(row,col) && obj2.connected(mapping(row, col), 0)){
        return true;
       }
       else
    	 return false;
     }
     
     public  int numberOfOpenSites() {
      // number of open sites
      return numSites;
     }
     public boolean percolates()  {
      // does the system percolate?
      return obj.connected(0, lastSite);
    
      
     }

     public static void main(String[] args) {
        
      /*
    	 Percolation arr = new Percolation(3);
    
   
    	 for(int i=1; i<4; i++){
    		 for(int j=1; j<4; j++){
    			 System.out.print(grid[i][j]);
    		 }
    		 System.out.println();
    	 }
    	 
    	 
    	 System.out.println();
    	 System.out.println();
    	 
    	 arr.open(1,3);
    	 arr.open(2,3);
    	 arr.open(3,3);
    	 arr.open(3,1);


    	 
    	 for(int i=1; i<4; i++){
    		 for(int j=1; j<4; j++){
    			 System.out.print(grid[i][j]);
    		 }
    		 System.out.println();
    	 }
    	 
    */
    	
    
     }
  }