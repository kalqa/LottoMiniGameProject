package GetProJava.MiniGames.Lotek;

import GetProJava.MiniGames.MiniGame;
import GetProJava.MiniGames.MiniGameManager;

public class LottoGameApplication extends MiniGameManager implements MiniGame {
    private final static String nameOfMiniGame = "Lotto";

    public LottoGameApplication() {
        super(nameOfMiniGame);
        super.start();
    }

    public void playLottoGame() {
        try {
            LottoGameMechanism.showResult();
        } catch (Exception e) {
            System.out.println("You cannot play with that data.");
        }
    }

}
