import java.util.LinkedList;

public class ListOfGamesGenerator {
	//Gethod generates the list of lists of all possible games that can be played at any "reachable" level
	public static LinkedList<LinkedList<TicTacToeGame>> generateAllGames(int lines, int columns, int winLength)
	{
		//Creates an empty list of lists
		LinkedList<LinkedList<TicTacToeGame>> allGames = new LinkedList<LinkedList<TicTacToeGame>>();
		//Create new "empty" game
		TicTacToeGame game = new TicTacToeGame(lines, columns, winLength);
		//Add "empty" game to the allgame list
		allGames.add(new LinkedList<TicTacToeGame>());
		allGames.get(0).add(game);
		
		boolean allBranchesClosed = false;
		int branchIndex = 0;
		//loop generates new "branches" or levels until no more populated levels can be created
		while (!allBranchesClosed)
		{
			LinkedList<TicTacToeGame> branch = nextLevelBranch(allGames.get(branchIndex));
			if (branch.isEmpty() == false) allGames.add(branch);
			else allBranchesClosed = true;
			branchIndex++;
		}
		return allGames;
	}

	//method generates "branch" or level, based on previous level
	private static LinkedList<TicTacToeGame> nextLevelBranch(LinkedList<TicTacToeGame> g)
	{
		//Create new empty branch
		LinkedList<TicTacToeGame> branch = new LinkedList<TicTacToeGame>();
		//Iterate over every game of previous branch
		for (int i = 0; i < g.size(); i++)
		{
			TicTacToeGame curGame = g.get(i);
			//Iterate over every cell of the game
			for (int c = 0; c < curGame.lines * curGame.columns && curGame.getGameState() == GameState.PLAYING; c++)
			{
				//Create new game with played cell if the cell is empty
				if(curGame.valueAt(c) == CellValue.EMPTY)
				{
					TicTacToeGame gameToAdd = new TicTacToeGame(curGame, c);
					//adds game to branch if no identical games are already exist in given branch
					if (! branch.contains(gameToAdd)) branch.add(gameToAdd);
				}
			}
		}
		return branch;
	}
}
