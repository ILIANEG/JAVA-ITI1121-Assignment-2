public class HumanPlayer implements Player
{
  public void play(TicTacToeGame game)
  {
    if(game.gameState == GameState.PLAYING)
    {
      
    }
    else
    {
      System.out.println("ERROR: The game can not be played")
    }
  }
}
