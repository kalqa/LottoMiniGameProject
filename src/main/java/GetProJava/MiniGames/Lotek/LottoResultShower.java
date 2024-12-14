package GetProJava.MiniGames.Lotek;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class LottoResultShower {

    private final NumberGenerator winningNumberGenerator;
    private final UserNumberRetrievable userNumberRetriever;

    public LottoResultShower(NumberGenerator winningNumberGenerator, UserNumberRetrievable userNumberRetriever) {
        this.winningNumberGenerator = winningNumberGenerator;
        this.userNumberRetriever = userNumberRetriever;
    }

    public String showResult() {
        Set<Integer> winningNumbers = winningNumberGenerator.generateSixWinningNumbers();
        Set<Integer> allWinningNumbers = new HashSet<>(winningNumbers);
        Set<Integer> userNumbers = userNumberRetriever.getSixNumbersFromUser(new Scanner(System.in));
        System.out.println("CHECKING RESULT");
        winningNumbers.retainAll(userNumbers);
        int properNumbers = winningNumbers.size();
        switch (properNumbers) {
            case 3: {
                String res = infoAboutWinning(properNumbers, 10, userNumbers, allWinningNumbers);
                System.out.println(res);
                return res;
            }
            case 4: {
                String res = infoAboutWinning(properNumbers, 100, userNumbers, allWinningNumbers);
                System.out.println(res);
                return res;
            }
            case 5: {
                String res = infoAboutWinning(properNumbers, 3500, userNumbers, allWinningNumbers);
                System.out.println(res);
                return res;
            }
            case 6: {
                String res = infoAboutWinning(properNumbers, 1000_000, userNumbers, allWinningNumbers);
                System.out.println(res);
                return res;
            }
            case 1, 2: {
                String res = infoAboutWinning(properNumbers, 0, userNumbers, allWinningNumbers);
                System.out.println(res);
                return res;
            }
            default: {
                String res = "GAME HAS BEEN ENDED. You have 0 numbers right";
                System.out.println(res);
                return res;
            }
        }
    }

    private String infoAboutWinning(int properNumbers, int price, Set<Integer> userNumbers, Set<Integer> allWinningNumbers) {
        System.out.println("Your numbers:" + userNumbers);
        System.out.println("Numbers which has won:" + allWinningNumbers);
        return "You won " + price + "zl! You have " + properNumbers + " numbers right.";
    }

}
