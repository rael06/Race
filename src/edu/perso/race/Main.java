package edu.perso.race;
import edu.perso.race.model.Race;
import edu.perso.race.views.UIRace;

public class Main {

    public static void main(String[] args) {
        Race race = Race.getInstance();
        race.initRace(5000, 10);

        new UIRace();
    }
}
