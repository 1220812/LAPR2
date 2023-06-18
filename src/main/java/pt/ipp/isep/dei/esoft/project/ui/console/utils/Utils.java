package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Utils.
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class Utils {

    private static final String SERIALIZATION_FILENAME = "serializationFile";

    static private <T> void showList(List<T> list, int len) {
        for (int i = 0; i < len; i++) {
            System.out.printf("%d. %s\n", i+1, list.get(i));
        }
        System.out.println("0. Exit");
    }


    /**
     * List and select one t.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the t
     */
    static public <T> T listAndSelectOne(List<T> list) {
        int len = list.size();
        int option;
        do {
            showList(list, len);
            option = readIntegerFromConsole("Select one: ");
        } while(option < 0 || option > len);

        if (option == 0) {
            return null;
        } else {
            return list.get(option-1);
        }
    }

    /**
     * Read line from console string.
     *
     * @param prompt the prompt
     * @return the string
     */
    static public String readLineFromConsole(String prompt) {
        try {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Read integer from console int.
     *
     * @param prompt the prompt
     * @return the int
     */
    static public int readIntegerFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                int value = Integer.parseInt(input);

                return value;
            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Read double from console double.
     *
     * @param prompt the prompt
     * @return the double
     */
    static public double readDoubleFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                double value = Double.parseDouble(input);

                return value;
            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Read date from console date.
     *
     * @param prompt the prompt
     * @return the date
     */
    static public Date readDateFromConsole(String prompt) {
        do {
            try {
                String strDate = readLineFromConsole(prompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Confirm boolean.
     *
     * @param message the message
     * @return the boolean
     */
    static public boolean confirm(String message) {
        String input;
        do {
            input = Utils.readLineFromConsole("\n" + message + "\n");
        } while (!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("n"));

        return input.equalsIgnoreCase("s");
    }

    /**
     * Show and select one object.
     *
     * @param list   the list
     * @param header the header
     * @return the object
     */
    static public Object showAndSelectOne(List list, String header) {
        showList(list, header);
        return selectsObject(list);
    }

    /**
     * Show and select index int.
     *
     * @param list   the list
     * @param header the header
     * @return the int
     */
    static public int showAndSelectIndex(List list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }

    /**
     * Show and select index 2 int.
     *
     * @param announcement the announcement
     * @return the int
     */
    public static int showAndSelectIndex2(List<Announcement> announcement) {
        showList2(announcement);
        return selectsIndex2(announcement);

    }

    /**
     * Show list 2.
     *
     * @param announcements the announcements
     */
    static public void showList2(List<Announcement> announcements){
        int index = 0;
        for (Object o : announcements) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println();
        System.out.println("0 - Cancel");
    }

    /**
     * Selects index 2 int.
     *
     * @param announcements the announcements
     * @return the int
     */
    static public int selectsIndex2(List<Announcement> announcements) {
        String input;
        Integer value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            try {
                value = Integer.valueOf(input);
            } catch (NumberFormatException ex) {
                value = -1;
            }
        } while (value < 0 || value > 4);

        return value - 1;
    }


    /**
     * Show list.
     *
     * @param list   the list
     * @param header the header
     */
    static public void showList(List list, String header) {
        System.out.println(header);

        int index = 0;
        for (Object o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println();
        System.out.println("0 - Cancel");
    }

    /**
     * Selects object object.
     *
     * @param list the list
     * @return the object
     */
    static public Object selectsObject(List list) {
        String input;
        Integer value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            value = Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0) {
            return null;
        } else {
            return list.get(value - 1);
        }
    }

    /**
     * Selects index int.
     *
     * @param list the list
     * @return the int
     */
    static public int selectsIndex(List list) {
        String input;
        Integer value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            try {
                value = Integer.valueOf(input);
            } catch (NumberFormatException ex) {
                value = -1;
            }
        } while (value < 0 || value > list.size());

        return value - 1;
    }

    /**
     * Read boolean from console boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public static Boolean readBooleanFromConsole(String s)
    {
        String input;
        do {
            input = String.valueOf(Utils.readLineFromConsole(s));
        } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));

        return input.equalsIgnoreCase("y");
    }

    /**
     * List and select many list.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the list
     */
    static public <T> List<T> listAndSelectMany(List<T> list) {
        int len = list.size();
        int option;
        do {
            showList(list, len);
            option = readIntegerFromConsole("Select one: ");
        } while(option < 0 || option > len);

        if (option == 0) {
            return null;
        } else {
            return list.subList(0, option);
        }
    }

    /**
     * Serialize.
     *
     * @param repo the repo
     * @throws IOException the io exception
     */
    public static void serialize(Repositories repo) throws IOException {


        FileOutputStream file = new FileOutputStream(SERIALIZATION_FILENAME);
        ObjectOutputStream out = new ObjectOutputStream(file);
        // Method for serialization of object
        out.writeObject(repo);

        out.close();
        file.close();

        System.out.println("Object has been serialized");
    }

    /**
     * Deserialize repositories.
     *
     * @return the repositories
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static Repositories deserialize() throws IOException, ClassNotFoundException {
        // Reading the object from a file
        FileInputStream file = new FileInputStream(SERIALIZATION_FILENAME);
        ObjectInputStream in = new ObjectInputStream(file);

        // Method for deserialization of object
        Repositories repo = (Repositories)in.readObject();
        repo.getAuthenticationRepository().initializeFacade();
        in.close();
        file.close();

        return repo;
    }
}
