import java.io.Console;

public class HumanPlayer implements Player
{
	//implements play for player, which will display the board and expect valid input
	public void play(TicTacToeGame game)
	{
		if (game.getGameState() == GameState.PLAYING)
		{
			System.out.println("Player 1's turn");
			System.out.println(game.toString());
			//checks if X or O plays and prints respective message
			if (game.getLevel() % 2 == 0) System.out.print("X to play: ");
			else System.out.print("O to play: ");
			boolean played = false;
			//will ask player for input untill the valid one is provided
			while(! played)
			{
				Console console = System.console();
				console = System.console();
				String StringToPlay = console.readLine();
				int toPlay = Integer.parseInt(StringToPlay);
				if(game.valueAt(toPlay - 1) == CellValue.EMPTY && 0 < toPlay && toPlay < gamle.lines * game.columns )
				{
					game.play(toPlay - 1);
					played = true;
				}
				else
				{
					System.out.println("Invalid input, please try to play another cell");
				}
			}
			
		}
		else System.out.println("ERROR: The game can not be played");
	}
}

