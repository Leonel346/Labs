//affiliation.java
public enum Affiliation {
    AVENGERS,
    JUSTICE_LEAGUE,
    X_MEN,
    FANTASTIC_FOUR
}

//Hero.java
public class Hero {
    private String name;
    private int powerLevel;
    private Affiliation affiliation;

    public Hero(String name, int powerLevel, Affiliation affiliation) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.affiliation = affiliation;
    }

    public String getName() {
        return powerLevel;
    }
    
    public int getPowerLevel() {
        return affiliation;
    }

    @Override
    public String toString() {
        return name + " (Power: " + powerLevel + ", Team: " + affiliation + ")";
    }
}

//HeroManager.java
import java.util.*;

public class HeroManager {
    private ArrayList<Hero> heroes = new ArrayList<>();

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public boolean removeHero(String name) {
        return heroes.removeIf(h -> h.getName().equalsIgnoreCase(name));
    }

    public void bubbleSortByPower() {
        for(int i = 0; i < heroes.size() - 1; i++) {
            for (int j = 0; j < heroes.size() - i - 1; j++) {
                if (heroes.get(j).getPowerLevel() > heroes.get(j + 1).getPowerLevel()) {
                    Collections.swap(heroes, j, j + 1);
                }
            }
        }
    }

    public void insertionSortByPower() {
        for (int i = 1; i < heroes.size(); i++) {
            Hero key = heroes.get(i);
            int j = i - 1;
            while (j >=0 && heroes.get(j).getPowerLevel() > key.getPowerLevel()) {
                heroes.set(j + 1, heroes.get(j));
                j--;
            }
            heroes.set(j + 1, key);
        }
    }

    public void displayHeroes() {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    public void displayAs2DArray() {
        String[][] heroData = new String[heroes.size()][3];
        for (int i = 0; i < heroes.size(); i++) {
            Hero h = heroes.get(i);
            heroData[i][0] = h.getName();
            heroData[i][1] = Integer.toString(h.getPowerLevel());
            heroData[i][2] = h.getAffiliation().toString();
        }
        System.out.println(Arrays.deepToString(heroData));
    }
}

//Main.java
public class Main {
    public static void main(String[] args) {
        HeroManager manager = new HeroManager();

        //Add initial heroes
        manager.addHero(new Hero("Spider-Man", 85, Affiliation.AVENGERS));
        manager.addHero(new Hero("Batman", 90, Affiliation.JUSTICE_LEAGUE));
        manager.addHero(new Hero("Wolverine", 88, Affiliation.X_MEN));
        manager.addHero(new Hero("Invisible Woman", 75, Affiliation.FANTASTIC_FOUR));

        System.out.println("--- Original List ---");
        manager.displayHeroes();

        System.out.println("\n--- Bubble Sort by Power ---");
        manager.bubbleSortByPower();
        manager.displayHeroes();

        // Reset order
        manager = new HeroManager();
        manager.addHero(new Hero("Spider-Man", 85, Affiliation.AVENGERS));
        manager.addHero(new Hero("Batman", 90, Affiliation.JUSTICE_LEAGUE));
        manager.addHero(new Hero("Wolverine", 88, Affiliation.X_MEN));
        manager.addHero(new Hero("Invisible Woman", 75, Affiliation.FANTASTIC_FOUR));

        System.out.println("\n--- Remove Batman ---");
        manager.insertionSortByPower();
        manager.displayHeroes();

        System.out.println("\n--- Add Wonder Woman ---");
        manager.addHero(new Hero("Wonder Woman", 92, Affiliation.JUSTICE_LEAGUE));
        manager.displayHeroes();

        System.out.println("\n--- Display as 2D Array ---");
        manager.displayAs2DArray();
    }
}
