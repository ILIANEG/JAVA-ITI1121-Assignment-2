import java.io.Console;

public class HumanPlayer implements Player
{
  public void play(TicTacToeGame game)
  {
    if(game.getGameState() == GameState.PLAYING)
    {
      System.out.println("Human Player's turn");
      System.out.println(game.toString());
      if(game.getLevel() % 2 == 0)
      {
        System.out.print("X to play: ");
      }
      else
      {
        System.out.print("O to play: ");
      }
      Console console = System.console();
      console = System.console();
			String StringToPlay = console.readLine();
      int toPlay = Integer.parseInt(StringToPlay);
      game.play(toPlay - 1);
    }
    else
    {
      System.out.println("ERROR: The game can not be played");
    }
  }
}
