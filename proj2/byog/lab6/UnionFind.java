package byog.lab6;

import java.util.ArrayList;
import java.util.List;

public class UnionFind {
    private int[] sets;
    private int[] size;
    public UnionFind(int n){
        sets = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            sets[i] = -1;
            size[i] = 1;
        }
    }
    public int sizeOf(int v1){
        return size[find(v1)];
    }
    public int parent(int v1){
        return sets[v1];
    }
    public boolean connected(int v1, int v2){
        return find(v1) == find(v2);
    }
    public void union(int v1, int v2){
        if (sizeOf(v1) == sizeOf(v2)){
            sets[v1] = find(v2);
            size[find(v2)] += sizeOf(v1);
        } else if (sizeOf(v1) > sizeOf(v2)) {
            sets[v2] = find(v1);
            sets[find(v1)] += sizeOf(v2);
        } else if (sizeOf(v1) < sizeOf(v2)) {
            sets[v1] = find(v2);
            size[find(v2)] += sizeOf(v1);
        }
    }
    public int find(int v1){
        List<Integer> temp = new ArrayList<>();
        while (parent(v1) != -1){
            temp.add(v1);
            v1 = parent(v1);
        }
        for (Integer i : temp){
            sets[i] = v1;
        }
        return v1;
    }
    public void validate(int v1) throws Exception {
        throw new Exception("Validate");
    }
}

