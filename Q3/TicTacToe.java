import java.util.LinkedList;

public class TicTacToe{
	

	public static void main(String[] args){

        StudentInfo.display();

        int lines = 3;
        int columns = 3;
        int win = 3;

	//Only 3x3 game will be generated	
        LinkedList<LinkedList<TicTacToeGame>> allGames;
		allGames = ListOfGamesGenerator.generateAllGames(lines,columns,win);
		int total = 0;
		int level = 0;
		int wonByX = 0;
		int wonByO = 0;
		int isADraw = 0;
		for(LinkedList<TicTacToeGame> list: allGames){
			System.out.print("======= level " + level + " =======: " + list.size() + " element(s)");
			total += list.size();
			level++;
			int unfinishedGames = 0;
			for(TicTacToeGame game: list){
				if(game.getGameState() == GameState.XWIN) {
					wonByX++;
				} else if (game.getGameState() == GameState.OWIN) {
					wonByO++;
				} else if (game.getGameState() == GameState.DRAW) {
					isADraw++;
				} else {
					unfinishedGames++;
				}
			}
			System.out.println (" (" + unfinishedGames + " still playing)");
		}
		System.out.println("that's " + total + " games");
		System.out.println(wonByX + "  won by X");
		System.out.println(wonByO + "  won by O");
		System.out.println(isADraw + " draw");


	}
}
