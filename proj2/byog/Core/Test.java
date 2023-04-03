package byog.Core;

public class Test {
    public static void main(String[] args){
        String temp = "N123S";
        long seed = Long.parseLong(temp.replaceAll("[^0-9]", ""));
        System.out.println(seed);
    }

}
