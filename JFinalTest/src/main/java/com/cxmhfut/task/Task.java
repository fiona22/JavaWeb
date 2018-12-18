package com.cxmhfut.task;

public class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Task Execute");
    }
}
