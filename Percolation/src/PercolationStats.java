import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;



public class PercolationStats {
   private  double [] nums;
   private int trials;
   
   
   public PercolationStats(int n, int trials){
	   this.trials = trials;
	   
	   nums = new double[trials];
	   
	   for (int i = 0; i < trials; i++){
		       Percolation obj = new Percolation(n);
		   
			   while (!obj.percolates()){
				   
				   int row = StdRandom.uniform(1, n+1);
				   int col = StdRandom.uniform(1, n+1);
				   
				   obj.open(row, col);
				   
			   }
			   
			   nums[i] = obj.numberOfOpenSites()/(double) (n*n);
			 
			   
	 }
	   // perform trials independent experiments on an n-by-n grid
   }
   public double mean()   {
	   return StdStats.mean(nums); // sample mean of percolation threshold
   }
   public double stddev() {
	   return StdStats.stddev(nums); // sample standard deviation of percolation threshold
   }
   public double confidenceLo() {
	   return mean()-(1.96*stddev()/Math.sqrt(trials)); // low  endpoint of 95% confidence interval
   } 
   public double confidenceHi()  {
	   return mean()+(1.96*stddev()/Math.sqrt(trials)); // high endpoint of 95% confidence interval
   }

   public static void main(String[] args) {
	   if (args.length == 2) {
           PercolationStats test = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

           System.out.printf("mean: %f\n", test.mean());
           System.out.printf("stddev: %f\n", test.stddev());
           System.out.printf("95%% confidence interval: %f, %f\n", test.confidenceLo(), test.confidenceHi());
       }
   }
}