package br.com.driver;

import java.util.concurrent.Callable;

public class CallThread implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        System.out.println("I'm call!");
        return new Object();
    }
}
