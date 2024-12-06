package GetProJava.MiniGames.Lotek;

import java.security.SecureRandom;
import java.util.*;


public class LottoGameMechanism {

    private static boolean validateNumber(int number) {
        return number >= 1 && number <= 99;
    }

    public static Set<Integer> get6WinnigNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        SecureRandom secureRandomProperNumber = new SecureRandom();
        while (winningNumbers.size() != 6) {
            winningNumbers.add(secureRandomProperNumber.nextInt(99) + 1);
        }
        return winningNumbers;
    }

    public static Set<Integer> get6NumbersFromUser(Scanner scanner) {
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


    public static void showResult() {
        System.out.println("CHECKING RESULT");
        String res;
        Set<Integer> winningNumbers = get6WinnigNumbers();

        Set<Integer> userNumbers = get6NumbersFromUser(new Scanner(System.in));
        if (userNumbers.size() == 6) {

            winningNumbers.retainAll(userNumbers);

            int properNumbers = winningNumbers.size();
            switch (properNumbers) {
                case 3: {
                    res = infoAboutWinning(properNumbers, 10);
                    System.out.println(res);
                    break;
                }
                case 4: {
                    res = infoAboutWinning(properNumbers, 100);
                    System.out.println(res);
                    break;
                }
                case 5: {
                    res = infoAboutWinning(properNumbers, 3500);
                    System.out.println(res);
                    break;
                }
                case 6: {
                    res = infoAboutWinning(properNumbers, 1000_000);
                    System.out.println(res);
                    break;
                }
                case 1, 2: {
                    res = infoAboutWinning(properNumbers, 0);
                    System.out.println(res);
                    break;
                }
                default: {
                    res = "GAME HAS BEEN ENDED. You have 0 numbers right";
                    System.out.println(res);
                    break;
                }
            }
        }
    }

    public static String infoAboutWinning(int properNumbers, int price) {
        return "You won " + price + "zl! You have " + properNumbers + " numbers right.";
    }

}
