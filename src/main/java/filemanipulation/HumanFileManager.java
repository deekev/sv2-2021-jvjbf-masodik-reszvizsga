package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try {
            humans = createHuman(Files.readAllLines(path));
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            List<String> males = filterMales(humans);
            Files.write(path, males);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    private List<Human> createHuman(List<String> datas) {
        List<Human> humans = new ArrayList<>();
        for (String s: datas) {
            String[] temp = s.split(";");
            humans.add(new Human(temp[0], temp[1]));
        }
        return humans;
    }

    private List<String> filterMales(List<Human> humans) {
        List<String> males = new ArrayList<>();
        for (Human actual: humans) {
            if (actual.getIdentityNumber().startsWith("1") || actual.getIdentityNumber().startsWith("3")) {
                males.add(actual.getName() + ";" + actual.getIdentityNumber());
            }
        }
        return males;
    }
}
