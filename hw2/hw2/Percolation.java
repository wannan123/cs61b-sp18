package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{

    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own
     * component.
     *
     * @param N the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     *
     */
    /* the up-down and right-left */
    private final static int OPEN = 1;
    private final static int [][] Direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private WeightedQuickUnionUF Vm_top;
    private WeightedQuickUnionUF Vm_top_down;
    private int [][] grid;
    private int numberOfOpenSize;
    private final int N;
    private int ToIndex(int row, int column){
        return row * N + column;
    }
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N){
        if (N <= 0) throw new IllegalArgumentException();
        this.N = N;
        this.grid = new int[N][N];
        int virtual_top = virtualTop();
        int virtual_down = virtualDown();
        this.Vm_top = new WeightedQuickUnionUF(N * N + 1);
        this.Vm_top_down = new WeightedQuickUnionUF(N * N + 2);
        this.numberOfOpenSize = 0;
        for (int i = 0; i < N; i++){
            assert false;
            this.Vm_top.union(ToIndex(0,i), virtual_top);
            this.Vm_top_down.union(ToIndex(0,i), virtual_top);
            this.Vm_top_down.union(ToIndex(N-1,i), virtual_down);
        }
    }
    private int virtualTop(){
        return N*N;
    }
    private int virtualDown(){
        return N*N + 1;
    }
    private boolean isValid(int row, int column){
        return !(row <= -1) && !(row >= N) && !(column <= -1) && !(column >= N);
    }
    // open the site (row, col) if it is not open already
    public void open(int row, int col){
        if (!isValid(row, col)) throw new IllegalArgumentException();
        if (isOpen(row, col) || isFull(row, col)) return;
        grid[row][col] = OPEN;
        numberOfOpenSize++;
        for (int[] dir :Direction){
            int x = row + dir[0];
            int y = col + dir[1];
            if (isValid(x, y) && isOpen(x, y)){
                Vm_top_down.union(ToIndex(row, col), ToIndex(x, y));
                Vm_top.union(ToIndex(row, col), ToIndex(x, y));
            }
        }

    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        return grid[row][col] == OPEN;
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if (!isOpen(row, col)) return false;
        int index = ToIndex(row, col);
        if (N == 1) {
            return isOpen(0, 0);
        }else {
            return Vm_top.connected(index, virtualTop());
        }
    }
    // number of open sites
    public int numberOfOpenSites(){return numberOfOpenSize;}
    // does the system percolate?
    public boolean percolates(){
        if (N == 1) {
            return isOpen(0, 0);
        }
        return Vm_top_down.connected(virtualTop(),virtualDown());
    }
    private void print() {
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < N; j += 1) {
                if (isFull(i, j)) {
                    System.out.print(2 + "  ");
                } else {
                    System.out.print(grid[i][j] + "  ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
         test1();
        // test2();
        //test3();
    }

    private static void test1() {
        Percolation p = new Percolation(5);
        p.print();
        testOpen(p, 3, 4);
        testOpen(p, 4, 4);
        testOpen(p, 3, 3);
        testOpen(p, 2, 3);
        testOpen(p, 1, 3);
        testOpen(p, 0, 3);
        testOpen(p, 2, 2);
        testOpen(p, 4, 2);
    }

    private static void test2() {  // test N = 1
        Percolation p = new Percolation(1);
        p.print();
        System.out.println(p.percolates());
        testOpen(p, 0, 0);
    }

    private static void test3() { // test N = 2
        Percolation p = new Percolation(2);
        p.print();
        System.out.println(p.percolates());
        // testOpen(p, 0, 0);
        testOpen(p, 0, 1);
        testOpen(p, 1, 1);
        testOpen(p, 1, 0);
    }

    private static void testOpen(Percolation p, int row, int col) {
        p.open(row, col);
        System.out.println("Opened: " + "( " + row + ", " + col + " )");
        System.out.println("#site opened: " + p.numberOfOpenSites());
        p.print();
        System.out.println("Percolated: " + p.percolates());
    }
}
