import java.util.Scanner;

public class HumanPlayer implements Player
{
  public void play(TicTacToeGame game)
  {
    if(game.gameState == GameState.PLAYING)
    {
      if(game.getLevel() % 2 == 0)
      {
        String message = "X to play: "
      }
      else
      {
        String message = "O to play: "
      }
      Scanner input = new Scanner(System.in);
      System.out.print(message);
      int toPlay = reader.nextInt();
      reader.close();
      game.play(toPlay);
    }
    else
    {
      System.out.println("ERROR: The game can not be played")
    }
  }
}
