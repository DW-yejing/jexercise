package com.yejing.exercise.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceEnhancer<T> extends WeakReference<T> {
    private T key;

    public WeakReferenceEnhancer(T key, ReferenceQueue<Object> referenceQueue ){
        super(key, referenceQueue);
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}
