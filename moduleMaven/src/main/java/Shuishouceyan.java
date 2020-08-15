import com.gec.bean.User;
import org.junit.jupiter.api.Test;

import java.io.*;

public class Shuishouceyan implements Cloneable{

    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream boStream=new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(boStream);
        out.writeObject(obj);
        ByteArrayInputStream biStream=new ByteArrayInputStream(boStream.toByteArray());
        ObjectInputStream in = new ObjectInputStream(biStream);
        return (T) in.readObject();
    }

    public User copys(User user){
        User users = new User();
        users.setId(user.getId());
        users.setAccount(user.getAccount());
        users.setUname(user.getUname());
        users.setPassword(user.getPassword());
        return users;
    }

    @Test
    public void fun(){
        System.out.println("以下是copy结果=====================");
        User user=new User();
        user.setUname("小明");
        user.setAccount("xiaoming");
        user.setPassword("123456");
        user.setId(1090);

        User copy = copys(user);
        boolean equals = user.equals(copy);
        System.out.println("最终结果："+equals);
        System.out.println("对象对比结果："+(user==copy));

    }

    @Test
    public void fun2(){
        System.out.println("以下是clone结果=====================");
        User user=new User();
        user.setUname("小明");
        user.setAccount("xiaoming");
        user.setPassword("123456");
        user.setId(1090);

        try {
            User clone = clone(user);
            boolean equals = user.equals(clone);
            System.out.println("最终结果："+equals);
            System.out.println("对象对比结果："+(user==clone));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun3(){
        System.out.println("以下是实现clone结果=====================");
        User user=new User();
        user.setUname("小明");
        user.setAccount("xiaoming");
        user.setPassword("123456");
        user.setId(1090);
        try {
            Object clone = user.clone();
            boolean equals = user.equals(clone);
            System.out.println("最终结果："+equals);
            System.out.println("对象对比结果："+(user==clone));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }



}
