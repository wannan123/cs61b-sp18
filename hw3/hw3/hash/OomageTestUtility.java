package hw3.hash;

import javax.print.DocFlavor;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        double []count = new double[M];
        for (Oomage o : oomages){
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            count[bucketNum] += 1;
        }
        for (double i : count){
            if (i < ((double) oomages.size() / 50) && (oomages.size() / 2.5) < i){
                return false;
            }
        }
        return true;
    }
}
