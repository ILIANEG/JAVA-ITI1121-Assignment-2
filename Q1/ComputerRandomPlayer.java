import java.util.Random;

public class HumanPlayer implements Player
{
  private int[] 
  public void play(TicTacToeGame game)
  {
    if(game.gameState == GameState.PLAYING)
    {
      boolean played = False;
      while(!played)
      {
        Random randomIndex = new Random();
        int indexToPlay = randomIndex.nextInt(game.lines * game.columns);
        if(game.valueAt(indexToPlay) == CellValue.EMPTY)
        {
          game.play(indexToPlay);
          played = True;
        }
      }
    }
    else
    {
      System.out.println("ERROR: The game can not be played")
    }
  }
}
