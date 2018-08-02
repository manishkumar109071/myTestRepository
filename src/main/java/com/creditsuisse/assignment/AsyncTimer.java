package com.creditsuisse.assignment;

public class AsyncTimer implements Runnable {

    private static int processTime;
    @Override
    public void run() {

        int timeCounter = 0;
        while (true) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            this.processTime = timeCounter++;

            System.out.println(processTime);
        }
    }
}
