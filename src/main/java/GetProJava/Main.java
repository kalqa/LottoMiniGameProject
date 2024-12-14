package GetProJava;

import GetProJava.MiniGames.Lotek.LottoGame;
import GetProJava.MiniGames.Lotek.LottoResultShower;
import GetProJava.MiniGames.Lotek.UserNumberRetriever;
import GetProJava.MiniGames.Lotek.WinningNumberGenerator;


public class Main {
    public static void main(String[] args) {
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        UserNumberRetriever userNumberRetriever = new UserNumberRetriever();
        LottoResultShower lottoResultShower = new LottoResultShower(winningNumberGenerator, userNumberRetriever);
        LottoGame app = new LottoGame(lottoResultShower);
        String result = app.play();
        System.out.println(result);
    }
}