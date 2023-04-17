package byog.lab6;

import java.util.Random;

public class UnionFindTest {
    public static void main(String[] args){
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(1,0);
        unionFind.union(3,2);
        unionFind.union(2,1);

        System.out.println(unionFind.connected(3,1));
        System.out.println(unionFind.sizeOf(1));
        System.out.println(unionFind.sizeOf(3));

    }
}
