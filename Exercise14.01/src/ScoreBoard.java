import java.util.Observable;
import java.util.Observer;

public class ScoreBoard implements Observer
{
 private FootballGame game;
 public ScoreBoard(FootballGame game)
 {
 this.game = game;
 showScore();
 game.addObserver(this);
 }
 public void showScore()
 {
 System.out.println("SCOREBOARD: " + game.getScore());
 }
@Override
public void update(Observable arg0, Object arg1) {
	showScore();
}
}
