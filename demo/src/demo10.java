import java.util.Arrays;
import java.util.List;

public class demo10 {
    public static void main(String[] args) {
        String s="aa123456aa";
//        System.out.println(s);
//        s=StringUtils.strip(s,"a");
//        System.out.println(s);
        String[] s1={"a","b","c","d","a"};
//        s=StringUtils.substringBetween(s,"sd");
//        s=StringUtils.substringBetween(s,"ao","sd");
//        s=StringUtils.repeat(s,2);
//        s=StringUtils.rightPad(s,50,"asdfasdfasdfasdfasdfasdfasdffffffffffffffffffffffffffffffffff");
//        s=StringUtils.center(s,100,"#");
//        s=StringUtils.swapCase(s);
//        int a=StringUtils.countMatches(s,"AA");
//        System.out.println(a);
//        System.out.println(s);

        String[] string={"a","b","c","d","e","f","g"};
        List<String> list=Arrays.asList(string);
        list.forEach((s2)-> System.out.println(s2+"   "));

        String a = "aaaaa";
        String b = null;
        System.out.println(a + "=" + b);
        System.out.println(b);

    }
}
