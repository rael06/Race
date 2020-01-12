package edu.perso.race.model;

import java.util.Random;

public class Car extends Thread implements Runnable {
    private int restDistance;
    private int id;
    private boolean finished;

    public Car(int id) {
        restDistance = Race.getInstance().getDistance();
        this.id = id;
        finished = false;
    }

    @Override
    public void run() {
        int sectionDistance;
        while (restDistance > 0) {
            sectionDistance = new Random().nextInt(16);
            try {
                sleep(sectionDistance);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            restDistance -= 0.5;
            //System.out.println(this);
        }
        restDistance = 0;
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "Car n°" + id;
    }

    public int getRestDistance() {
        return restDistance;
    }

    public int getCarId() {
        return id;
    }
}
