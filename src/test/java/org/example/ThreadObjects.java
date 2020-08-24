package org.example;

import java.util.HashMap;

public class ThreadObjects {
    private static HashMap<String, Pages> pagesHashMap = new HashMap<String, Pages>();
    private static HashMap<String, WebDriverRunner> webDriverRunnerHashMap = new HashMap<String, WebDriverRunner>();

    static {
        pagesHashMap.put(Thread.currentThread().getName(), new Pages());
        webDriverRunnerHashMap.put(Thread.currentThread().getName(), new WebDriverRunner());
    }

    public static Pages pages() {
        return pagesHashMap.get(Thread.currentThread().getName());
    }

    public static WebDriverRunner webDriverRunner() {
        return webDriverRunnerHashMap.get(Thread.currentThread().getName());
    }
}
