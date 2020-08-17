import com.gec.bean.User;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ShuishouceyanMap {

    public HashMap<Integer, User> establishMap(){
        //创建User的Map并返回
        HashMap<Integer,User> hashMap=new HashMap<>();
        hashMap.put(1736,new User(103,"zhangsan","103","103"));
        hashMap.put(2342,new User(102,"lisi","102","102"));
        hashMap.put(3090,new User(104,"wangwu","104","104"));
        hashMap.put(4666,new User(101,"zhaoliu","101","101"));
        hashMap.put(5223,new User(105,"wuqi","105","105"));
        System.out.println("原本的HashMap：");
        for (Map.Entry<Integer, User> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        return hashMap;
    }

    public HashMap<Integer,User> paiXuLinkedHashMap(HashMap<Integer, User> hashMap){//将HashMap传入
        //将HashMap转换为Set集合
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();
        //再将Set集合转为List集合
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entries);
        //使用工具类Collections的sort方法排序，创建Comparator匿名内部类重写排序方法
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                //按User对象的id大小排序，升序
                return o1.getValue().getId()-o2.getValue().getId();
            }
        });
        //创建有序的Map集合：LinkedHashMap，用来存储排序完成后的List集合内的Map.Entry
        LinkedHashMap<Integer,User> linkedHashMap=new LinkedHashMap<>();
        //循环遍历List,将List内的值保存进LinkedHashMap
        for (Map.Entry<Integer, User> mapEntry : list) {
            linkedHashMap.put(mapEntry.getKey(),mapEntry.getValue());
        }
        //返回这个LinkedHashMap
        return linkedHashMap;
    }

    @Test
    public void fun(){
        //调用前面两个方法获取到已完成排序的HashMap
        HashMap<Integer, User> hashMap = paiXuLinkedHashMap(establishMap());
        //获取HashMap迭代对象
        Iterator<Map.Entry<Integer, User>> iterator = hashMap.entrySet().iterator();
        System.out.println("LinkedHashMap的排序结果：");
        while (iterator.hasNext()){//循环迭代(遍历)
            //将迭代获取到的对象转为一个map键值对
            Map.Entry<Integer, User> entry = (Map.Entry<Integer,User>)iterator.next();
            //控制台输出该键值对
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * 推荐使用以下方法
     */
    @Test
    public void fun2(){
        //调用前面两个方法获取到已完成排序的HashMap
        HashMap<Integer, User> hashMap = paiXuLinkedHashMap(establishMap());
        System.out.println("LinkedHashMap的排序结果：");
        //将hashMap转化为Set集合，直接使用键值对对象Entry遍历Set集合
        for (Map.Entry<Integer, User> entry : hashMap.entrySet()) {
            //控制台输出键值对对象Entry的键和值
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
