

//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {

	public static boolean[][] Untouched(String[][] list){
		boolean[][] untouchables = new boolean[list.length][list.length];
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list[i].length; j++){
				if(list[i][j] != "__"){
						untouchables[i][j] = true;
				}
			}
		}
		return untouchables;
	}

	public static ArrayList<String> ListMistakes(StandardSudoku list){
		ArrayList<String> error = new ArrayList<String>();
		for(int i = 0; i < list.getSize(); i++){
			for(int j = 0; j < list.getSize(); j++){
				if(list.Mistake(i,j)){
					error.add("" + i + "," + j);
				}
			}
		}
		return error;
	}

	public static void printMistakes(ArrayList<String> error, Terminal t){
		for(int i = 0; i < error.size(); i++){
			int num1 = error.get(i).charAt(0);
			int num2 = error.get(i).charAt(2);
			putString(42,3+i,t, error.get(i) ,Terminal.Color.WHITE,Terminal.Color.GREEN);
		}
	}

	public static String StandardPrint(String[][] puzzle){
		String result = "";
		for(int i = 0; i < 9; i++){
			if((i+3) % 3 == 0){
				result += "-----------------------" + "\n";
			}
			result += "|";
			for(int j = 0; j < 9; j++){
				result += puzzle[i][j];
				if((j+1) % 3 == 0){
					result += "|";
				}
				if(j == 8){
					result += "\n";
				}
			}
		}
		return result;
	}

	public static String CustomPrint(String[][] puzzle, int size){
    String result = "-------------------" + "\n";
    for(int i = 0; i < size; i++){
			if((i+3) % 3 == 0){
				result += "-----------------------" + "\n";
			}
      result += "|";
      for(int j = 0; j < 12; j++){
        result += puzzle[i][j];
				if((j+1) % 3 == 0){
					result += "|";
				}
        if(j == 11){result += "\n";}
      }
    }
    return result;
  }

	public static void putString(int r, int c,Terminal t, String s){
	    t.moveCursor(r,c);
	    for(int i = 0; i < s.length();i++){
	      t.putCharacter(s.charAt(i));
	    }
	  }

	  public static void putString(int r, int c,Terminal t,
	        String s, Terminal.Color forg, Terminal.Color back ){
	    t.moveCursor(r,c);
	    t.applyBackgroundColor(forg);
	    t.applyForegroundColor(Terminal.Color.BLACK);

	    for(int i = 0; i < s.length();i++){
	      t.putCharacter(s.charAt(i));
	    }
	    t.applyBackgroundColor(Terminal.Color.DEFAULT);
	    t.applyForegroundColor(Terminal.Color.DEFAULT);
	  }

		public static void putPuzzle(Terminal t,
				 String puzzle, Terminal.Color forg, Terminal.Color back ){
		 t.moveCursor(1500,25);
		 t.applyBackgroundColor(forg);
		 t.applyForegroundColor(Terminal.Color.BLACK);

		 for(int i = 0; i < puzzle.length();i++){
			 t.putCharacter(puzzle.charAt(i));
		 }
		 t.applyBackgroundColor(Terminal.Color.DEFAULT);
		 t.applyForegroundColor(Terminal.Color.DEFAULT);
	 }
	  public static void main(String[] args) {

	    Terminal terminal = TerminalFacade.createTextTerminal();
	    terminal.enterPrivateMode();

	    TerminalSize size = terminal.getTerminalSize();
	    terminal.setCursorVisible(false);

	    boolean running = true;
	    int mode = 0;
			int inputmode = 0;
			boolean setup = false;
	    long lastTime =  System.currentTimeMillis();
	    long currentTime = lastTime;
	    long timer = 0;

			String modemessage = "";

			StandardSudoku question = new StandardSudoku(17);
			String[][] puzzle = question.getPuzzle();
			boolean[][] list = Untouched(puzzle);

			CustomSudoku newQues = new CustomSudoku(12);
			String[][] Puzzle = newQues.getPuzzle();
			int size2 = newQues.getSize();
			boolean[][] list2 = Untouched(Puzzle);

			CustomSudoku puzz3 = new CustomSudoku(16);
			String[][] Puzz3 = puzz3.getPuzzle();
			int size3 = puzz3.getSize();
			boolean[][] list3 = Untouched(Puzz3);

			Scanner in = new Scanner(System.in);

			int x = 10;
			int y = 10;

	    while(running){

				while(inputmode == 1){
					int row = in.nextInt();
					int col = in.nextInt();
					int num = in.nextInt();
					question.add(row,col,num);
					inputmode = 0;
				}
				while(inputmode == 2){
					int row = in.nextInt();
					int col = in.nextInt();
					if(list[row][col]){
						putString(33,3,terminal, "This number cannot be changed!",Terminal.Color.WHITE,Terminal.Color.GREEN);
						inputmode = 0;
					}
					else{
					question.remove(row,col);
					putString(31,3,terminal, "",Terminal.Color.WHITE,Terminal.Color.GREEN);
					inputmode = 0;
				}
			}
				while(inputmode == 3){
					boolean solved = question.checkAnswer();
					putString(21,5,terminal, "Puzzle solved?: " + solved,Terminal.Color.WHITE,Terminal.Color.GREEN);
					inputmode = 0;
				}
				while(inputmode == 4){
					ArrayList<String> data = ListMistakes(question);
					printMistakes(data,terminal);
					inputmode = 0;
				}
				while(inputmode == 5){
					putString(21,5,terminal, "Did you really think I would give you the answer?",Terminal.Color.WHITE,Terminal.Color.GREEN);
					inputmode = 0;
				}
				terminal.applyBackgroundColor(Terminal.Color.WHITE);
				terminal.applyForegroundColor(Terminal.Color.BLACK);
				//applySGR(a,b) for multiple modifiers (bold,blink) etc.
				terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
				terminal.putCharacter('\u00a4');
				//terminal.putCharacter(' ');
				terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
				terminal.applyForegroundColor(Terminal.Color.DEFAULT);
				terminal.applySGR(Terminal.SGR.RESET_ALL);

	      Key key = terminal.readInput();
	      if (key != null)
	      {

					if (key.getKind() == Key.Kind.ArrowLeft) {
						terminal.moveCursor(x,y);
						terminal.putCharacter(' ');
						x--;
					}

					if (key.getKind() == Key.Kind.ArrowRight) {
						terminal.moveCursor(x,y);
						terminal.putCharacter(' ');
						x++;
					}

					if (key.getKind() == Key.Kind.ArrowUp) {
						terminal.moveCursor(x,y);
						terminal.putCharacter(' ');
						y--;
					}

					if (key.getKind() == Key.Kind.ArrowDown) {
						terminal.moveCursor(x,y);
						terminal.putCharacter(' ');
						y++;
					}

	        //YOU CAN PUT DIFFERENT SETS OF BUTTONS FOR DIFFERENT MODES!!!



	        //only for the game mode.
	        if(mode == 0){
	          if (key.getKind() == Key.Kind.Escape) {
	            terminal.exitPrivateMode();
	            running = false;
	          }
						if(key.getCharacter() == 'C'){
							setup = true;
						}
						if(key.getCharacter() == 'X'){
							setup = false;
						}
	        }

					if(mode >= 2){
						if(key.getCharacter() == 'a'){
							modemessage = "Adding";
							inputmode = 1;
						}
						else if(key.getCharacter() == 'r'){
							modemessage = "Removing";
							inputmode = 2;
						}
						else if(key.getCharacter() == 'm'){
							modemessage = "Checking Puzzle";
							inputmode = 3;
						}
						else if(key.getCharacter() == 'l'){
							modemessage = "Listing Mistakes";
							inputmode = 4;
						}
						else if(key.getCharacter() == 'g' ){
							modemessage = "Outputing answer";
							inputmode = 5;
						}
					}

					if(inputmode == 0){
						modemessage = "Playing";
					}

	        //for all modes
	        if (key.getCharacter() == ' ') {
	          mode++;
	          mode%=6;//6 modes
	          terminal.clearScreen();
	          lastTime = System.currentTimeMillis();
	          currentTime = System.currentTimeMillis();
	        }
	      }

	      terminal.applySGR(Terminal.SGR.ENTER_BOLD);
	      putString(1,1,terminal, "This is mode "+mode,Terminal.Color.WHITE,Terminal.Color.RED);
	      terminal.applySGR(Terminal.SGR.RESET_ALL);


	      if(mode==0){
					String logo1 = "          ##########        " + "\n";
					String logo2 = "						  ###           " + "\n";
					String logo3 = "							###           " + "\n";
					String logo4 = "							###           " + "\n";
					String logo5 = "							###           " + "\n";
					String logo6 = "					###########       ";
	        lastTime = currentTime;
	        currentTime = System.currentTimeMillis();
	        timer += (currentTime -lastTime);//add the amount of time since the last frame.
	        //DO GAME STUFF HERE
	        putString(3,3,terminal, "Press Space to Play the Game!",Terminal.Color.WHITE,Terminal.Color.RED);
					putString(3,4,terminal, "Press 'C' to view the controls", Terminal.Color.WHITE,Terminal.Color.RED);

					while(setup){
						putString(3,5,terminal, "1. Press 'a' to add number",Terminal.Color.WHITE,Terminal.Color.RED);
						putString(3,6,terminal, "2. Press 'r' to remove number", Terminal.Color.WHITE,Terminal.Color.RED);
						putString(3,7,terminal, "3. Press 'm' to check if the puzzle is solved", Terminal.Color.WHITE,Terminal.Color.RED);
						putString(3,8,terminal, "4. Press 'l' to list the number of mistakes", Terminal.Color.WHITE,Terminal.Color.RED);
						putString(3,9,terminal, "5. Press 'g' to recieve the answer(this doesnt work yet!)", Terminal.Color.WHITE,Terminal.Color.RED);
						setup = false;
					}

	      }else if (mode == 1){

					String writing = "1. Standard 9 by 9 puzzle. Press Space to play" + "\n" + "\n" +
													 " 2. Custom 12 by 12 puzzle. Press Space twice to play" + "\n" + "\n" +
													 " 3. Custom 16 by 16 puzzle. Press Space three times to play";

	        putString(1,3,terminal, "Please Choose A Puzzle",Terminal.Color.RED,Terminal.Color.WHITE);
					putString(1,5,terminal, writing,Terminal.Color.RED,Terminal.Color.WHITE);
	        terminal.applySGR(Terminal.SGR.RESET_ALL);

	      }else if(mode == 2){
					lastTime = currentTime;
	        currentTime = System.currentTimeMillis();
	        timer += (currentTime -lastTime);//add the amount of time since the last frame.
	        putPuzzle(terminal,StandardPrint(puzzle),Terminal.Color.WHITE,Terminal.Color.WHITE);
					putString(1,3,terminal, "This is the 9 by 9 Sudoku Puzzle",Terminal.Color.WHITE,Terminal.Color.GREEN);
				  putString(3,5,terminal, "Now: "+ modemessage,Terminal.Color.WHITE,Terminal.Color.RED);
			  }else if(mode == 3){
	        putPuzzle(terminal,CustomPrint(Puzzle,size2),Terminal.Color.WHITE,Terminal.Color.WHITE);
	        terminal.applySGR(Terminal.SGR.RESET_ALL);
					putString(1,3,terminal, "This is the 12 by 12 Sudoku puzzle",Terminal.Color.WHITE,Terminal.Color.GREEN);
				  putString(3,5,terminal, "",Terminal.Color.WHITE,Terminal.Color.RED);
				}else if(mode == 4){
					putPuzzle(terminal,CustomPrint(Puzz3,size3),Terminal.Color.WHITE,Terminal.Color.WHITE);
					putString(1,3,terminal,"This is the 16 by 16 Sudoku puzzle", Terminal.Color.WHITE,Terminal.Color.GREEN);
					putString(3,5,terminal, "This is still in development!",Terminal.Color.WHITE,Terminal.Color.RED);
				}
				else if(mode == 5){
					putString(1,3,terminal,"This is the 20 by 20 Sudoku puzzle", Terminal.Color.WHITE,Terminal.Color.GREEN);
					putString(3,5,terminal, "This is still in development!",Terminal.Color.WHITE,Terminal.Color.RED);
				}
	    }
		}

}
