import java.util.Random;

public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters line  and column
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

   
        try{
            if (args.length >= 2) {
                lines = Integer.parseInt(args[0]);
                if(lines<2){
                    System.out.println("Invalid argument, using default...");
                    lines = 3;
                }
                columns = Integer.parseInt(args[1]);
                if(columns<2){
                    System.out.println("Invalid argument, using default...");
                    columns = 3;
                }
            }
            if (args.length >= 3){
                win = Integer.parseInt(args[2]);
                if(win<2){
                    System.out.println("Invalid argument, using default...");
                    win = 3;
                }
            } 
            if (args.length > 3){
                System.out.println("Too many arguments. Only the first 3 are used.");
            } 

        } catch(NumberFormatException e){
            System.out.println("Invalid argument, using default...");
            lines   = 3;
            columns  = 3;
            win = 3;
        }
    }
   private playTheGame()
   {
      game = new TicTacToeGame(lines, columns, win)
      HumanPlayer humanPlayer = new HumanPlayer;
      ComputerRandomPlayer computerPlayer = new ComputerRandomPlayer;
      Player[] players = {humanPlayer, computerPlayer};
      Random randomIndex = new Random();
      int playerIndex = randomIndex.nextInt(2);
      while(game.gameState == GameState.)
      {
         
      }
       
   }
   private cycleIndex(int curIndex)
   {
      if(currIndex == 1)
      {
         return 0;
      }
      else
      {
         return 1;
      }
   }
   private String printTheMessage(TicTacToeGame currentGame)
   {
      if(currentGame.getGameState() == GameState.PLAYING)
      {
         if(currentGame.getLevel() % 2 == 0)
         {
            System.out.print("X to play: ");
         }
         else
         {
            System.out.print("O to play: ");
         }
      }
      else
      {
         if(currentGame.getGameState() == GameState.XWIN)
         {
            System.out.println("Result: XWIN");
         }
         else if(currentGame.getGameState() == GameState.OWIN)
         {
            System.out.println("Result: OWIN");
         }
         else
         {
            System.out.println("Result: DRAWN");
         }
      }
   }
}
