package com.yejing.exercise.reference;

import com.yejing.exercise.exercise.ClassA;
import org.aspectj.util.SoftHashMap;
import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class ReferenceTest {
    @Test
    public void test3() throws Exception{
        ReferenceQueue<ClassA> referenceQueue = new ReferenceQueue<>();
        ClassA classA = new ClassA("a", "b");
        WeakReferenceEnhancer enhancer = new WeakReferenceEnhancer(classA, referenceQueue);
        classA = null;
        Object o1 = enhancer.get();
        System.gc();
        Thread.sleep(500);
        Object o2 = enhancer.get();
        Reference o3 = referenceQueue.poll();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
    }


    @Test
    public void test2() throws Exception{
        WeakHashMap<String, String> map = new WeakHashMap<>();
        map.put(new String("a"), "a");
        map.put("b", "b");
        System.gc();
        Thread.sleep(1000);
        map.put(new String("c"), "c");
        Field rqField = WeakHashMap.class.getDeclaredField("queue");
        rqField.setAccessible(true);
        ReferenceQueue<?> rq = (ReferenceQueue<?>)rqField.get(map);
        Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength");
        queueLengthField.setAccessible(true);
        long queueLength = (long)queueLengthField.get(rq);
        System.out.println(queueLength);

    }

    @Test
    public void test1() throws Exception{
        SoftHashMap<String, String> map = new SoftHashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        System.gc();
        Field rqField = SoftHashMap.class.getDeclaredField("rq");
        rqField.setAccessible(true);
        ReferenceQueue<?> rq = (ReferenceQueue<?>)rqField.get(map);
        Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength");
        queueLengthField.setAccessible(true);
        long queueLength = (long)queueLengthField.get(rq);
        System.out.println(queueLength);

    }
}
