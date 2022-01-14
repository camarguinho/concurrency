package br.com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecute {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(() -> 1);
        callables.add(() -> 2);

        try {
            Thread.sleep(100);
            //System.out.println(exec.invokeAny(callables));
            System.out.println(exec.invokeAll(callables));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } /*catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        exec.shutdown();
    }
}
