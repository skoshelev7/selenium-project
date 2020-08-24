package org.example;

import java.util.HashMap;

public class ThreadObjects {
    private static HashMap<String, Pages> pagesHashMap = new HashMap<String, Pages>();

    static {
        pagesHashMap.put(Thread.currentThread().getName(), new Pages());
    }

    public static Pages pages() {
        return pagesHashMap.get(Thread.currentThread().getName());
    }
}
