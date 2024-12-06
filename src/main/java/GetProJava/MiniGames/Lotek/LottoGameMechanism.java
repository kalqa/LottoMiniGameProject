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
            winningNumbers.add(secureRandomProperNumber.nextInt(1, 99) + 1);
        }
        System.out.println("Winning numbers are:"+winningNumbers);
        return winningNumbers;
    }

    public static Set<Integer> get6NumbersFromUser() {
        Set<Integer> userNumbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 6 numbers to check if you won.");
        int i = 0;
        while (i < 6) {
            try {
                System.out.println("Number" + (i + 1) + ":");
                int number = scanner.nextInt();
                if (validateNumber(number)) {
                    userNumbers.add(number);
                    i++;
                }
                else {
                    System.out.println("Number out of range!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input data!");
                break;
            } catch (NoSuchElementException e) {
                System.out.println("ERROR! No data!");
                break;
            }
        }
        scanner.close();
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
