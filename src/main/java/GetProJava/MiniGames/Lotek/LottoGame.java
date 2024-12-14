package GetProJava.MiniGames.Lotek;

import GetProJava.MiniGames.MiniGame;
import GetProJava.MiniGames.MiniGameName;

public class LottoGame implements MiniGame, MiniGameName {
    private final static String nameOfMiniGame = "Lotto";
    private final LottoResultShower lottoResultShower;

    public LottoGame(LottoResultShower lottoResultShower) {
        this.lottoResultShower = lottoResultShower;
    }

    @Override
    public String play() {
        welcomeUser();
        String resultMessage = playLottoGame();
        byeUser();
        return resultMessage;
    }

    private void welcomeUser() {
        System.out.println("Game " + getNameOfMiniGame() + " started");
    }

    private void byeUser() {
        System.out.println("Game " + getNameOfMiniGame() + " started");
    }

    @Override
    public String getNameOfMiniGame() {
        return nameOfMiniGame;
    }

    private String playLottoGame() {
        try {
            return lottoResultShower.showResult();
        } catch (Exception e) {
            System.out.println("You cannot play with that data.");
            return "ended program with exception";
        }
    }
}
