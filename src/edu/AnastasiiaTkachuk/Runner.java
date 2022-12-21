package edu.AnastasiiaTkachuk;


import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        threadPoolMethod();
    }

    private static void threadPoolMethod() throws InterruptedException {
        ExecutorService threadExecutor = Executors.newFixedThreadPool(2);

        Scanner console = new Scanner(System.in);
        while(console.hasNextInt()){
            int seconds = console.nextInt();
            if(seconds < 0 ){
                break;
            }
            threadExecutor.submit(() ->{
                try {
                    Thread.sleep(seconds*1000L);
                    System.out.println("Поток спал " + seconds + " секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadExecutor.shutdown();
        threadExecutor.awaitTermination(1L, TimeUnit.MINUTES);
    }
}
