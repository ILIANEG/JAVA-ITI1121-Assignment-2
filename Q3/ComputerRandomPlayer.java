import java.util.Random;

public class ComputerRandomPlayer implements Player
{
  public void play(TicTacToeGame game)
  {
    if(game.getGameState() == GameState.PLAYING)
    {
      System.out.println("Computer Player's turn");
      boolean played = false;
      while(!played)
      {
        Random randomIndex = new Random();
        int indexToPlay = randomIndex.nextInt(game.lines * game.columns);
        if(game.valueAt(indexToPlay) == CellValue.EMPTY)
        {
          game.play(indexToPlay);
          played = true;
        }
      }
    }
    else
    {
      System.out.println("ERROR: The game can not be played");
    }
  }
}
