package edu.perso.race.model;

public class Race {
    private static Race instance = null;
    private int distance = 0;
    private Car[] cars;

    private Race() {
    }

    public void init(int distance, int nbCar) {
        this.distance = distance;
        cars = new Car[nbCar];
        for (int i = 0; i < nbCar; i++) {
            cars[i] = new Car(i + 1);
        }
    }

    public void start() {
        for (Car car : cars) {
            new Thread(car).start();
        }
    }

    public static Race getInstance() {
        return instance = instance == null ? new Race() : instance;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getDistance() {
        return distance;
    }
}
