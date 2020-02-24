import java.util.LinkedList;

public class ListOfGamesGenerator {
	
	//Function that will generate all possible games taking symmetry into consideration
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
	
	//method generates "branch" or level, based on previous level, in this version symmetry will be taken in consideration
	private static LinkedList<TicTacToeGame> nextLevelBranch(LinkedList<TicTacToeGame> g)
	{
		//Create new empty branch
		LinkedList<TicTacToeGame> branch = new LinkedList<TicTacToeGame>();
		//Iterate over every game of previous branch
		for(int i = 0; i < g.size(); i++)
		{
			TicTacToeGame curGame = g.get(i);
			//Iterate over every cell of the game
			for(int c = 0; c < curGame.lines * curGame.columns && curGame.getGameState() == GameState.PLAYING; c++)
			{
				if(curGame.valueAt(c) == CellValue.EMPTY)
				{
					TicTacToeGame gameToAdd = new TicTacToeGame(curGame, c);
					//Checks if game to be added is unique and no symmetrical identities found
					if(! branch.contains(gameToAdd)
						&& ! branch.contains(inverseBoard(gameToAdd))
						&& ! branch.contains(reverseRows(gameToAdd))
						&& ! branch.contains(reverseColumns(gameToAdd))
						&& ! branch.contains(reverseRows(reverseColumns(gameToAdd)))
						&& ! branch.contains(reverseRows(inverseBoard(gameToAdd)))
						&& ! branch.contains(reverseColumns(inverseBoard(gameToAdd)))
						&& ! branch.contains(reverseRows(reverseColumns(inverseBoard(gameToAdd))))
					  )
					{
						branch.add(gameToAdd);
					}
				}
			}
		}
		return branch;
	}
	
	//Method generates TicTacToeGame with reversed rows based on another TicTacToeGame
	private static TicTacToeGame reverseRows(TicTacToeGame game)
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
		//Algorythm that populates revRowBoard
		for (int a = game.lines - 1; a > -1; a--) for (int b = 0; b < game.columns; b++)
		{
			revRowBoard[count] = boardOfGame[game.lines*a+b];
			count++;
		}
		//New constructor (line #120 in TicTacToeGame.java) creates game by copying conditions of previous game and new board
		//Such approach allows to reuse the code which checks the existance of particular game in the branch
		return new TicTacToeGame(game, revRowBoard);
	}

	//Method generates TicTacToeGame with reversed columns based on another TicTacToeGame
	private static TicTacToeGame reverseColumns(TicTacToeGame game)
	{
		//Creating boradOfGame array that stores the board of passed in game
		CellValue[] boardOfGame = new CellValue[game.lines * game.columns];
		int count = 0;
		for(int i = 0; i < boardOfGame.length; i++)
		{
			boardOfGame[i] = game.valueAt(i);
		}
		CellValue[] revColBoard = new CellValue[game.lines * game.columns];
		//This loop reverse the columns of the board
		for (int c = 0; c < game.columns; c++) for (int d = game.lines - 1; d > -1; d--)
		{
			revColBoard[count] = boardOfGame[game.lines*c+d];
			count++;
		}
		return new TicTacToeGame(game, revColBoard);
	}
	//Creates a TicTacToeGame with columns = rows, rows = columns based on another TicTacToeGame
	private static TicTacToeGame inverseBoard(TicTacToeGame game)
	{
		CellValue[] boardOfGame = new CellValue[game.lines * game.columns];
		int count = 0;
		for(int i = 0; i < boardOfGame.length; i++)
		{
			boardOfGame[i] = game.valueAt(i);
		}
		CellValue[] inverseBoard = new CellValue[game.lines * game.columns];
		//turn columns into rows and rows into columns
		for(int c = 0; c < game.columns; c++) for(int l = 0; l < game.lines; l++)
		{
			inverseBoard[count] = boardOfGame[c + l * game.columns];
			count++;
		}
		return new TicTacToeGame(game, inverseBoard);
	}
}
