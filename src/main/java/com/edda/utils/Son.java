package com.edda.utils;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Son extends Father implements Callable<Integer> {

    public static int getFatherId(){
        return 2;
    }

    private int count = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Son son = new Son();

        Integer i = 100;
        int ii = i;
        Integer iii = 100;
        System.out.println(i.hashCode()+"-"+iii.hashCode());
        System.out.println(i==iii);
//        for(int i = 0; i<1000;i++) {
//            FutureTask<Integer> futureTask = new FutureTask<>(son);
//            new Thread(futureTask).start();
//        }
//        System.out.println("返回值="+futureTask.get());
    }

    @Override
    public Integer call() {
        for(int i=0;i<100;i++){
                count++;
            System.out.println(Thread.currentThread().getName()+"-"+count);
        }
        return count;
    }
}
