import java.util.*;

public class Main {
    public static void main(String[] args) {
        // create the horses
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse('P', "PIPPI LONGSTOCKING", 0.6));
        horses.add(new Horse('K', "KOKOMO", 0.6));
        horses.add(new Horse('E', "EL JEFF", 0.4));

        // start the race
        Race race = new Race(horses, 20); 
        race.startRace();
    }
}
