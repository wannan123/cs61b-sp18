package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] data;
    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf){
        data = new double[T];

        for (int i = 0; i < T; i++){
            Percolation percolation = pf.make(N);
            while (!percolation.percolates()){
                int row = (int)StdRandom.uniform(N);
                int cul = (int)StdRandom.uniform(N);
                percolation.open(row, cul);
            }
            data[i] = (double) percolation.numberOfOpenSites() / (N * N);

        }
    }
    // sample mean of percolation threshold
    public double mean(){return StdStats.mean(data);}
    // sample standard deviation of percolation threshold
    public double stddev(){return StdStats.stddev(data);}
    // low endpoint of 95% confidence interval
    public double confidenceLow(){
        double mean = mean();
        double stddev = stddev();
        return mean - (1.96 * stddev) / Math.sqrt(data.length);
    }
    public double confidenceHigh(){
        double mean = mean();
        double stddev = stddev();
        return mean + (1.96 * stddev) / Math.sqrt(data.length);

    }
    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(30, 100, new PercolationFactory());
        System.out.println("Low bound: " + ps.confidenceLow());
        System.out.println("High bound: " + ps.confidenceHigh());
    }
}
