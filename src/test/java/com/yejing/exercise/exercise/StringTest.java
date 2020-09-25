package com.yejing.exercise.exercise;

import com.alibaba.fastjson.JSON;
import com.yejing.exercise.model.ModelA;
import com.yejing.exercise.model.Node;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.net.URLDecoder;
import java.util.*;

public class StringTest {
    @Test
    public void stringTest() throws Exception{
        FileReader fileReader = new FileReader("C:\\Users\\cars\\Desktop\\e\\a.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

    }

    @Test
    public void aAppend(){

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemory= memoryMXBean.getHeapMemoryUsage();
        long maxHeap = heapMemory.getMax();
        byte[] b = new byte[10000];
        Arrays.fill(b, (byte)97);
        String a = new String(b);
        try {
            FileWriter fw = new FileWriter("C:\\Users\\cars\\Desktop\\a\\a.txt", true);
            fw.write(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("complete");
    }

    /*@Test
    public void jsonTest(){
        String line = new String("[{\\x22a\\x22:\\x22a\\xB1ph.\\xCD\\x86\\xBEI\\xBA\\xC3\\xBCiM+\\xCE\\xCE\\x1E\\xDF7\\x1E\\xD9z\\xD9Q\\x8A}\\xD4\\xB2\\xD5\\xA0y\\x98\\x08@\\xE1!\\xA8\\xEF^\\x0D\\x7F\\xECX!\\xFF\\x06IP\\xEC\\x9F[\\x85;\\x02\\x817R\\x87\\xFB\\x1Ch\\xCB\\xC7\\xC6\\x06\\x8F\\xE2Z\\xDA^J\\xEB\\xBCF\\xA6\\xE6\\xF4\\xF7\\xC1\\xE3\\xA4T\\x89\\xC6\\xB2\\x5Cx]");
        line = line.replaceAll("\\\\x", "%");
        System.out.println(line);
        String a ="sadfx";
        try {
            a = URLDecoder.decode(line, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
      a= "[{\"a\": \"f\\x]";
        System.out.println(a);
        try {
            JSON.parseObject(a, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Test
    public void inttest(){
        int a = (int) 'f';
        System.out.println(a);
    }

    @Test
    public void test_20190920001(){
        String a =null;
        long t2 = 0;
        long t1 = 0;
        try {
            t1 = System.currentTimeMillis();
            a = DigestUtils.md5Hex(new FileInputStream("C:\\Users\\cars\\Desktop\\aa.xlsx"));
            t2 = System.currentTimeMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(t2-t1);
    }

    @Test
    public void atest(){
        a:
        for(int i=0; i<10; i++){
            b:
            for(int q=0; q<10; q++){
                System.out.println(i+"-"+q);
                if(i==8 && q==8){
                    break a;
                }
            }

        }
    }

    @Test
    public void btest(){
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        ModelA a = new ModelA();
        ctest(a);
        System.out.println(a);
    }

    public void ctest(ModelA a){
        ModelA aa = new ModelA();
        aa.setAge("18");
        a =aa;
    }

    @Test
    public void test_20191218(){
        Node dummyHead = new Node("a");
        Node currNode = dummyHead.next;
        for(int i=0; i<3; i++){
            currNode = new Node("key-"+String.valueOf(i));
            currNode.next= new Node(String.valueOf(i));
            currNode = currNode.next;
        }
        System.out.println(currNode);
    }

    @Test
    public void test_20200120(){
        String a = "123";
        int b = a.charAt(1);
        System.out.println(b);
    }

    @Test
    public void test1(){
        List<ClassA> classAList = new ArrayList<>();
        for(int i=0; i<5; i++){
            ClassA classA = new ClassA();
            classA.a = "a";
            classA.b = "b";
            if(!classAList.contains(classA)){
                classAList.add(classA);
            }
        }
    }

    @Test
    public void test2(){
       Set<String> a = new TreeSet<>();
       List<String> b = new ArrayList<>();
       b.add("a");
       b.add("b");
       a.addAll(b);
       System.out.println(a);
       b = new ArrayList<>();
       b.add("d");
       b.add("c");
       b.add("e");
       a.addAll(b);
        System.out.println(a);
    }


}
