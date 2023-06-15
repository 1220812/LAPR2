package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.DevTeamUI;
import pt.ipp.isep.dei.esoft.project.ui.console.DisplayPropertiesUI;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthenticationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenuUI implements Runnable {

    private static final String SERIALIZATION_FILENAME = "serializationFile";

    public MainMenuUI() throws IOException {
    }
    public static void serialize(Repositories repo) throws IOException {


        FileOutputStream file = new FileOutputStream(SERIALIZATION_FILENAME);
        ObjectOutputStream out = new ObjectOutputStream(file);
        // Method for serialization of object
        out.writeObject(repo);

        out.close();
        file.close();

        System.out.println("Object has been serialized");
    }

    public static Repositories deserialize() throws IOException, ClassNotFoundException {
        // Reading the object from a file
        FileInputStream file = new FileInputStream(SERIALIZATION_FILENAME);
        ObjectInputStream in = new ObjectInputStream(file);

        // Method for deserialization of object
        Repositories repo = (Repositories)in.readObject();

        in.close();
        file.close();

        return repo;
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Do Login", new AuthenticationUI()));
        options.add(new MenuItem("Know the Development Team", new DevTeamUI()));
        options.add(new MenuItem("Display properties", new DisplayPropertiesUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);

    }
}
