package edu.perso.race.model;

import java.util.Random;

public class Car implements Runnable {
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
            sectionDistance = new Random().nextInt(1000) + 200;
            try {
                Thread.sleep(sectionDistance);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            restDistance -= sectionDistance;
            //System.out.println(this);
        }
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "Voiture n°" + id;
    }

    public int getRestDistance() {
        return restDistance;
    }

    public int getId() {
        return id;
    }
}
