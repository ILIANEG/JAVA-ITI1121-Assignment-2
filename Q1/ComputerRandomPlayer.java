import java.util.Random;


public class ComputerRandomPlayer implements Player
{	
	//implements method play() for Human Player, if current game can be played
	public void play(TicTacToeGame game)
	{
		if (game.getGameState() == GameState.PLAYING)
		{
			System.out.println("Player 2's turn");
			boolean played = false;
			//Randomly playing the non-empty cell
			while (!played)
			{
				Random randomIndex = new Random();
				int indexToPlay = randomIndex.nextInt(game.lines * game.columns);
				if (game.valueAt(indexToPlay) == CellValue.EMPTY)
				{
					game.play(indexToPlay);
					played = true;
				}
			}
		}
		else System.out.println("ERROR: The game can not be played");
	}
}
