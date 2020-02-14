import java.util.Random;

public class HumanPlayer implements Player
{
  public void play(TicTacToeGame game)
  {
    if(game.gameState == GameState.PLAYING)
    {
      Random randomIndex = new Random();
      int toPlay = randomIndex.nextInt(game.lines * game.columns);
      game.play(toPlay)
    }
    else
    {
      System.out.println("ERROR: The game can not be played")
    }
  }
}
