package edu.perso.race.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Race {
    private static Race instance = null;
    private int distance;
    private Car[] cars;
    private int nbCar;

    private Race() {
    }

    public void initRace(int distance, int nbCar) {
        this.distance = distance;
        this.nbCar = nbCar;
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

//    public void check() {
//        while (Arrays.stream(cars).noneMatch(Car::isFinished)) {
//            Arrays.sort(cars, new SortByRestDistance());
//        }
//    }

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

class SortByRestDistance implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getRestDistance() - o2.getRestDistance();
    }
}
