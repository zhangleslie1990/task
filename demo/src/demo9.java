import java.util.ArrayList;
import java.util.List;

public class demo9 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //list.remove(2);
        System.out.println("长度:"+list.size());
        int index=list.indexOf("b");
        System.out.println("第几个:"+index+"      下一个值是:"+list.get(index+1));
        for(String s:list){
            System.out.println(s);
        }
    }
}
