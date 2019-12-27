package edu.perso.race.views;


import java.util.Comparator;

public class SortByUICarRestDistance implements Comparator<UICar> {
    @Override
    public int compare(UICar o1, UICar o2) {
        return o1.getCar().getRestDistance() - o2.getCar().getRestDistance();
    }
}
