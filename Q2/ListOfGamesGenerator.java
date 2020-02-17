import java.util.LinkedList;

public class ListOfGamesGenerator {


   /**
	* generates all different games for the specified
	* parameters. Each game is recorded only once.
	* once a game is finished, it is not extended further
	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
    * @return
    * a list of lists of game instances, ordered by levels
  	*/
	public static LinkedList<LinkedList<TicTacToeGame>> generateAllGames(int lines, int columns, int winLength)
	{
		LinkedList<LinkedList<TicTacToeGame>> allGames = new LinkedList<LinkedList<TicTacToeGame>>();
		TicTacToeGame game = new TicTacToeGame(lines, columns, winLength);
		allGames.add(new LinkedList<TicTacToeGame>());
		allGames.get(0).add(game);
		boolean allBranchesClosed = false;
		int branchIndex = 0;
		while(!allBranchesClosed)
		{
			LinkedList<TicTacToeGame> branch = nextLevelBranch(allGames.get(branchIndex));
			if(branch.isEmpty() == false)
			{
				allGames.add(branch);
				System.out.println(allGames.size());
			}
			else
			{
				allBranchesClosed = true;
			}
			branchIndex++;
		}
		for(TicTacToeGame g : allGames.get(allGames.size() - 1))
		{
			System.out.println(g.toString());
		}
		return allGames;
	}

	private static LinkedList<TicTacToeGame> nextLevelBranch(LinkedList<TicTacToeGame> g)
	{
		LinkedList<TicTacToeGame> branch = new LinkedList<TicTacToeGame>();
		for(int i = 0; i < g.size(); i++)
		{
			for(int c = 0; c < g.get(i).lines * g.get(i).columns; c++)
			{
				if(g.get(i).getGameState() == GameState.PLAYING && g.get(i).valueAt(c) == CellValue.EMPTY)
				{
					boolean inList = false;
					TicTacToeGame gameToAdd = new TicTacToeGame(g.get(i), c);
					for(int a = 0; a < branch.size(); a++)
					{
						if(gameToAdd.equals(branch.get(a)))
						{
							inList = true;
							break;
						}
					}
					if(! inList)
					{
						branch.add(gameToAdd);
					}
				}
			}
		}
		return branch;
	}
}
