package GetProJava.MiniGames.Lotek;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserNumberRetriever implements UserNumberRetrievable {

    @Override
    public Set<Integer> getSixNumbersFromUser(Scanner scanner) {
        Set<Integer> userNumbers = new HashSet<>();

        System.out.println("Enter 6 numbers from 1 to 99, separated by whitespace:");
        String input = scanner.nextLine();
        String[] numbers = input.split("\\s+");

        try {
            if (numbers.length != 6) {
                throw new IllegalArgumentException("You must provide exactly 6 numbers! Data has to be numbers.");
            }
            Arrays.stream(numbers).map(Integer::parseInt).peek(number -> {
                if (!validateNumber(number)) {
                    throw new IllegalArgumentException("Numbers have to be from 1 to 99!");
                }
            }).forEach(userNumbers::add);
            if (userNumbers.size() != 6) {
                throw new IllegalArgumentException("You must provide exactly 6 different numbers!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: All values must be valid integers.");
            throw e;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return userNumbers;
    }

    private boolean validateNumber(int number) {
        return number >= 1 && number <= 99;
    }
}
