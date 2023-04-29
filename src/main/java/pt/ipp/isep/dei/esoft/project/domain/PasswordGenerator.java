package pt.ipp.isep.dei.esoft.project.domain;

public class PasswordGenerator {

    public static String generatePassword() {
        StringBuilder passwordBuilder = new StringBuilder();
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] capitalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int randomLetter;
        int randomCapitalLetter;
        int randomNumber;
        for (int i = 0; i < 7; i++) {
            if (i < 3) {
                randomCapitalLetter = (int) (Math.random() * 26);
                passwordBuilder.append(capitalLetters[randomCapitalLetter]);
            } else if (i < 5) {
                randomNumber = (int) (Math.random() * 10);
                passwordBuilder.append(numbers[randomNumber]);
            } else {
                randomLetter = (int) (Math.random() * 26);
                passwordBuilder.append(letters[randomLetter]);
            }
        }
        return passwordBuilder.toString();
    }

}
