package com.guigu.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guigu.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

    @Test
    public void test1(){
        Person person = new Person(1, "好");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以把java对象转换成json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        //第一个参数是json字符串，第二个是java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);

    }

    @Test
    public void test2(){
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(1, "过"));
        personList.add(new Person(2, "康"));

        Gson gson = new Gson();

        //把list转换成json字符串
        String personListJsonString = gson.toJson(personList);
       // System.out.println(personListJsonString);

        //List<Person> list = gson.fromJson(personListJsonString, personList.getClass());
        List<Person> list = gson.fromJson(personListJsonString,new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);//list取里面不是person。类型异常
        System.out.println(person);
    }
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();

        personMap.put(1, new Person(1, "好"));
        personMap.put(2, new Person(2, "好"));

        Gson gson = new Gson();

        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

        //Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(personMap2);
        Person p = personMap2.get(1);
        System.out.println(p);

    }
}
