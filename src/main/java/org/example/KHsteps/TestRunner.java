package org.example.KHsteps;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestRunner {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable testRunner = () -> {
            try {

                ProcessBuilder processBuilder = new ProcessBuilder("mvn", "test");
                processBuilder.directory(new java.io.File("C:\\Users\\Dolpheen\\IdeaProjects\\klanhaboru"));
                processBuilder.inheritIO();
                Process process = processBuilder.start();
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };


        executorService.scheduleAtFixedRate(testRunner, 0, 20, TimeUnit.MINUTES);
    }
}