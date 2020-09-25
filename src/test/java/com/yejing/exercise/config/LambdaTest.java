package com.yejing.exercise.config;

import com.yejing.exercise.model.ModelA;
import net.bytebuddy.description.method.ParameterList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest {
    @Test
    public void listTest(){
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("name", "yejing1");
        map.put("age", "18");
        list.add(map);
        map = new HashMap();
        map.put("name", "yejing2");
        map.put("age", "19");
        list.add(map);

        List<ModelA> list1 = new ArrayList<>();
        ModelA modelA1 = new ModelA();
        modelA1.setName("yejing3");
        modelA1.setAge("20");
        list1.add(modelA1);
        ModelA modelA2 = new ModelA();
        modelA2.setName("yejing4");
        modelA2.setAge("21");
        list1.add(modelA2);
        List<String> r2 = list1.stream().map(o->o.getName()).collect(Collectors.toList());
        System.out.println(r2);

        List<String> r = list.stream().map(m->m.get("name")).collect(Collectors.toList());
        System.out.println(r);
    }

}
