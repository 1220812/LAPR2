package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class Utils {

    static private <T> void showList(List<T> list, int len) {
        for (int i = 0; i < len; i++) {
            System.out.printf("%d. %s\n", i+1, list.get(i));
        }
        System.out.println("0. Exit");
    }


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

    static public boolean confirm(String message) {
        String input;
        do {
            input = Utils.readLineFromConsole("\n" + message + "\n");
        } while (!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("n"));

        return input.equalsIgnoreCase("s");
    }

    static public Object showAndSelectOne(List list, String header) {
        showList(list, header);
        return selectsObject(list);
    }

    static public int showAndSelectIndex(List list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }
    public static int showAndSelectIndex2(List<Announcement> announcement) {
        showList2(announcement);
        return selectsIndex2(announcement);

    }

    static public void showList2(List<Announcement> announcements){
        int index = 0;
        for (Object o : announcements) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println();
        System.out.println("0 - Cancel");
    }
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
    public static Boolean readBooleanFromConsole(String s)
    {
        String input;
        do {
            input = String.valueOf(Utils.readLineFromConsole(s));
        } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));

        return input.equalsIgnoreCase("y");
    }
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


}
