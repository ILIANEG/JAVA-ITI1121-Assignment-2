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
			}
			else
			{
				allBranchesClosed = true;
			}
			branchIndex++;
		}
		return allGames;
	}

	private static LinkedList<TicTacToeGame> nextLevelBranch(LinkedList<TicTacToeGame> g)
	{
		LinkedList<TicTacToeGame> branch = new LinkedList<TicTacToeGame>();
		for(int i = 0; i < g.size(); i++)
		{
			TicTacToeGame curGame = g.get(i);
			for(int c = 0; c < curGame.lines * curGame.columns && curGame.getGameState() == GameState.PLAYING; c++)
			{
				if(curGame.valueAt(c) == CellValue.EMPTY)
				{
					TicTacToeGame gameToAdd = new TicTacToeGame(curGame, c);
					if(! branch.contains(gameToAdd))
					{
						branch.add(gameToAdd);
					}
				}
			}
		}
//		System.out.println("/*"+reverseRows().toString()+"*/");
		return branch;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////	
	//Method creates TicTaToeGame with reversed rows
	private TicTacToeGame reverseRows(TicTacToeGame game)
	{
		//Creating boradOfGame array that stores the board of passed in game
		CellValue[] boardOfGame = new CellValue[game.lines * game.columns];
		int count = 0;
		for(int i = 0; i < boardOfGame.length; i++)
		{
			boardOfGame[i] = game.valueAt(i);
		}
		//You need to populate this board in such way that the rows are reversed order
		CellValue[] revRowBoard = new CellValue[game.lines * game.columns];
		//CREATE AND IMPLEMENT ALGORYTHM THAT WILL USE boardOfGame TO POPULATE revRowBoard
		for (int a = game.lines - 1; a > -1; a--) for (int b = 0; b < game.columns; b++)
		{
			revRowBoard[count] = boardOfGame[game.lines*a+b];
			count++;
		}
		
		//If your revRowBoard is good, my new constructor (line #120 in TicTacToeGame.java) should take care about creating new game;
		return new TicTacToeGame(game, revRowBoard);
	}
	
	//Method creates TicTacToe with reversed columns
	private TicTacToeGame reverseColumns(TicTacToeGame game)
	{
		//Creating boradOfGame array that stores the board of passed in game
		CellValue[] boardOfGame = new CellValue[game.lines * game.columns];
		int count = 0;
		for(int i = 0; i < boardOfGame.length; i++)
		{
			boardOfGame[i] = game.valueAt(i);
		}
		//You need to populate this board in such way that the columns are reversed order
		CellValue[] revColBoard = new CellValue[game.lines * game.columns];
		//CREATE AND IMPLEMENT ALGORYTHM THAT WILL USE boardOfGame TO POPULATE revColBoard
		for (int e = 0; e < boardOfGame.length; e++)
		{
			revColBoard[e] = boardOfGame[e];
		}

		for (int c = 0; c < game.columns; c++) for (int d = game.lines - 1; d > -1; d--)
		{
			revColBoard[count] = boardOfGame[game.lines*c+d];
			count++;
		}
		return new TicTacToeGame(game, revColBoard);
	}
}
