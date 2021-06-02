package vop.sprinterTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadCSV{

    private final File file;
    private final Map<String, Set<Sprinter>> map = new HashMap<>();

    public ReadCSV(String fileName) {
        file = new File(getClass().getResource(fileName).getPath());
    }

    public Map<String, Set<Sprinter>> getMap() {
        return map;
    }

    public void readFile() {

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            String header = scanner.nextLine();

            while (scanner.hasNext()) {
                String[] values = scanner.nextLine().split(",");
                Sprinter sprinter = new Sprinter(
                        Integer.parseInt(values[4]),
                        Integer.parseInt(values[0]),
                        Integer.parseInt(values[1]),
                        values[5],
                        values[6],
                        values[9]);
                if (map.containsKey(sprinter.getCountry())) {
                    map.get(sprinter.getCountry()).add(sprinter);
                } else {
                    Set<Sprinter> oneValueSet = new TreeSet<>();
                    oneValueSet.add(sprinter);
                    map.put(sprinter.getCountry(), oneValueSet);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int timeToSeconds(String halfTime){
        int timeInSeconds = 0;
        String[] time = halfTime.split(":");
        timeInSeconds += Integer.parseInt(time[0]) * 60 * 60;
        timeInSeconds += Integer.parseInt(time[1]) * 60;
        timeInSeconds += Integer.parseInt(time[2]);
        return timeInSeconds;
    }

    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV("challenge.csv");

        readCSV.readFile();

        Set<Sprinter> uSSprinters = readCSV.getMap().get("United States");
        uSSprinters.forEach(System.out::println);
    }

}
