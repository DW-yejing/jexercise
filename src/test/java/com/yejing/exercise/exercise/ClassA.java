package com.yejing.exercise.exercise;

import java.util.Objects;

public class ClassA {
    public String a;
    public String b;

    public ClassA(){}

    public ClassA(String a){
        this.a = a;
        System.out.println("ClassA initialed");
    }

    public ClassA(String a, String b){
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassA classA = (ClassA) o;
        return a.equals(classA.a) &&
                b.equals(classA.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
