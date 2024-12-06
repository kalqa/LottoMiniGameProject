package GetProJava.MiniGames.Lotek;

import java.security.SecureRandom;
import java.util.*;

public class LottoGameMechanism {

    private static boolean validateNumber(int number) {
        return number >= 1 && number <= 99;
    }

    public static Set get6WinnigNumbers() {
        Set winningNumbers = new HashSet();
        SecureRandom secureRandomProperNumber = new SecureRandom();
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(secureRandomProperNumber.nextInt(99) + 1);
        }
        System.out.println("Winning numbers are:"+winningNumbers);
        return winningNumbers;
    }

    public static Set<Integer> get6NumbersFromUser() {
        Set<Integer> userNumbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 6 numbers, separated by whitespace:");
        String input = scanner.nextLine();

        String[] numbers = input.split("\\s+");

        try {
            if (numbers.length != 6) {
                throw new IllegalArgumentException("You must provide exactly 6 numbers!");
            }

            Arrays.stream(numbers).map(Integer::parseInt).forEach(userNumbers::add);
        } catch (NumberFormatException e) {
            System.out.println("Error: All values must be valid integers.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return userNumbers;
    }

    public static boolean checkIfUserWon() {
        if (get6WinnigNumbers().equals(get6NumbersFromUser())) {
            System.out.println("YOU WON!");
            return true;
        }
        else {
            System.out.println("Try next time :)");
            return false;
        }
    }



}
