import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShuishouceyanArror {

    public final static List list=new ArrayList<>();
    public final static LinkedList linked=new LinkedList<>();

    public static Object o=new Object();

    public int fun(int a,int[] arr){
        int s=0;

        for (int i : arr) {
            if(a==i){
                s++;
            }
        }
        return s;
    }

    @Test
    public void fun2(){
        int[] arr = {1,4,1,4,2,5,4,5,8,7,8,7,7,8,8,5,4,9,6,2,4,1,5};
        int fun = fun(1,arr);
        System.out.println(fun);
    }

    //ArrayList集合的二分法查找
    /*public void erFen1(int a,int listLen){
        int len=listLen/2;
        if(len==1&&list.get(len)!=a){
            System.out.println("mu");
            return;
        }
        for(int i=len;i<list.size();i++){
            if(list.get(i)==a){
                System.out.println(list.get(i));
                return;
            }
        }

        erFen1(a,len-1);
    }*/

    @Test
    public void Arrays(){
        long l = System.currentTimeMillis();
        //添加50000个数
        for(int i=0;i<50000;i++){
            list.add(0,o);
        }
        //频繁增删耗时为145sm
        /*long l = System.currentTimeMillis();
        erFen1(50,list.size());*/
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        //输出结果是耗时16ms
    }

    //LinkedList的二分法查找
    /*public void erFen2(int a,int linkedLen){
        int len=linkedLen/2;
        if(len==1&&linked.get(len)!=a){
            System.out.println("mu");
            return;
        }
        for(int i=len;i<linked.size();i++){
            if(linked.get(i)==a){
                System.out.println(linked.get(i));
                return;
            }
        }

        erFen2(a,len-1);
    }*/

    @Test
    public void linkeds(){

        long l = System.currentTimeMillis();
        //添加50000个数
        for(int i=0;i<50000;i++){
            linked.add(0,o);
        }
        //频繁增删耗时为6sm
        /*long l = System.currentTimeMillis();
        erFen2(50,linked.size());*/
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        //输出结果是8902ms
    }
}
