package byog.Core;

import java.util.Random;

public class Test {
    public static void main(String[] args){
        String temp = "N123S";
        long seed = Long.parseLong(temp.replaceAll("[^0-9]", ""));
        Random random = new Random();
        int x = random.nextInt(2,10);
        int y = random.nextInt(2,10);
        System.out.println(x);
        System.out.println(y);
    }

}
