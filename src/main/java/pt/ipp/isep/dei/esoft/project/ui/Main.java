package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        Repositories repository = Repositories.getInstance();
        try {
            repository = Utils.deserialize();
        } catch (Exception e) {
            System.out.println("Error deserializing");
            e.printStackTrace();
        }
        repository = Repositories.getInstance();

        try {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Repositories repo = Repositories.getInstance();
        try {
            Utils.serialize(repo);
        } catch (IOException e) {
            System.out.println("Failed to serialize repositories");
            e.printStackTrace();
        }
      }
}
