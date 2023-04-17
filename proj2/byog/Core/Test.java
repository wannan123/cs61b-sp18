package byog.Core;

import java.util.*;

public class Test {
    public static void main(String args[]){

        List<String> list=new ArrayList<String>();
        list.add("abc");
        list.add("ddd");
        list.add("ddd");

        System.out.println(">>>>>>>>>>>>去重复之前:>>>>>>>>>>>>>>");
        for(Iterator<String> it = list.iterator(); it.hasNext(); )
        {
            System.out.println("value="+it.next().toString());
        }

        System.out.println(">>>>>>>>>>>>去重复之后:>>>>>>>>>>>>>>");
        Set<String> set=new TreeSet<>();
        set.addAll(list);

        for( Iterator<String>   it = set.iterator();  it.hasNext(); )
        {
            System.out.println("value="+it.next().toString());
        }

    }

}
