

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

public class TerminalDemo {

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

	public static String TwelvePrint(String[][] puzzle){
    String result = "-------------------" + "\n";
    for(int i = 0; i < 12; i++){
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
	    long lastTime =  System.currentTimeMillis();
	    long currentTime = lastTime;
	    long timer = 0;

			StandardSudoku question = new StandardSudoku(17);
			String[][] puzzle = question.getPuzzle();
			boolean[][] list = Untouched(puzzle);

			CustomSudoku newQues = new CustomSudoku(12);
			String[][] Puzzle = newQues.getPuzzle();
			boolean[][] list2 = Untouched(Puzzle);

	    while(running){

				while(inputmode == 1){
					Scanner in = new Scanner(System.in);
					int row = in.nextInt();
					int col = in.nextInt();
					int num = in.nextInt();
					question.add(row,col,num);
					in.close();
					inputmode = 0;
				}
				while(inputmode == 2){
					Scanner in = new Scanner(System.in);
					int row = in.nextInt();
					int col = in.nextInt();
					if(list[row][col]){
						putString(50,3,terminal, "This number cannot be changed!",Terminal.Color.WHITE,Terminal.Color.GREEN);
					}
					else{
					question.remove(row,col);
					in.close();
					inputmode = 0;
				}
			}
				while(inputmode == 3){
					boolean solved = question.checkAnswer();
					putString(1,5,terminal, "Puzzle solved?: " + solved,Terminal.Color.WHITE,Terminal.Color.GREEN);
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

		/*			if (key.getKind() == Key.Kind.ArrowLeft) {
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
					} */

	        //YOU CAN PUT DIFFERENT SETS OF BUTTONS FOR DIFFERENT MODES!!!



	        //only for the game mode.
	        if(mode == 0){
	          if (key.getKind() == Key.Kind.Escape) {
	            terminal.exitPrivateMode();
	            running = false;
	          }
	        }

					if(mode >= 2){
						if(key.getCharacter() == 'a'){
							inputmode = 1;
						}
						else if(key.getCharacter() == 'r'){
							inputmode = 2;
						}
						else if(key.getCharacter() == 'm'){
							inputmode = 3;
						}
						else if(key.getCharacter() == 'l'){
							inputmode = 4;
						}
						else if(key.getCharacter() == 'g' ){
							inputmode = 5;
						}
					}


	        //for all modes
	        if (key.getCharacter() == ' ') {
	          mode++;
	          mode%=5;//2 modes
	          terminal.clearScreen();
	          lastTime = System.currentTimeMillis();
	          currentTime = System.currentTimeMillis();
	        }
	      }

	      terminal.applySGR(Terminal.SGR.ENTER_BOLD);
	      putString(1,1,terminal, "This is mode "+mode,Terminal.Color.WHITE,Terminal.Color.RED);
	      terminal.applySGR(Terminal.SGR.RESET_ALL);


	      if(mode==0){
					String logo = "         ##########        " + "\n" +
					           		"						  ###           " + "\n" +
												"							###           " + "\n" +
												"							###           " + "\n" +
												"							###           " + "\n" +
												"					###########       ";
	        lastTime = currentTime;
	        currentTime = System.currentTimeMillis();
	        timer += (currentTime -lastTime);//add the amount of time since the last frame.
	        //DO GAME STUFF HERE
	        putString(500,25,terminal, logo,Terminal.Color.BLACK,Terminal.Color.YELLOW);
	        putString(3,5,terminal, "Press Space to Play the Game!",Terminal.Color.WHITE,Terminal.Color.RED);

	      }else if (mode == 1){

					String writing = "1. Standard 9 by 9 puzzle. Press Space to play" + "\n" + "\n" +
													 " 2. Custom 10 by 10 puzzle. Press Space twice to play" + "\n" + "\n" +
													 " 3. Custom 12 by 12 puzzle. Press Space three times to play";

	        terminal.applySGR(Terminal.SGR.ENTER_BOLD,Terminal.SGR.ENTER_BLINK);
	        putString(1,3,terminal, "Please Choose A Puzzle",Terminal.Color.RED,Terminal.Color.WHITE);
					putString(1,5,terminal, writing,Terminal.Color.RED,Terminal.Color.WHITE);
	        terminal.applySGR(Terminal.SGR.RESET_ALL);

	      }else if(mode == 2){
					lastTime = currentTime;
	        currentTime = System.currentTimeMillis();
	        timer += (currentTime -lastTime);//add the amount of time since the last frame.
	        putPuzzle(terminal,StandardPrint(puzzle),Terminal.Color.WHITE,Terminal.Color.WHITE);
					putString(1,3,terminal, "timer:" +timer,Terminal.Color.WHITE,Terminal.Color.GREEN);
				  putString(3,5,terminal, "inputmode "+inputmode,Terminal.Color.WHITE,Terminal.Color.RED);
				}else if(mode == 3){
					putString(1,3,terminal, "Intermediate mode",Terminal.Color.WHITE,Terminal.Color.GREEN);
				}else if(mode == 4){
					terminal.applySGR(Terminal.SGR.ENTER_BOLD,Terminal.SGR.ENTER_BLINK);
	        putPuzzle(terminal,TwelvePrint(Puzzle),Terminal.Color.WHITE,Terminal.Color.WHITE);
	        terminal.applySGR(Terminal.SGR.RESET_ALL);
					putString(1,3,terminal, "timer:" +timer,Terminal.Color.WHITE,Terminal.Color.GREEN);
				  putString(3,5,terminal, "inputmode "+inputmode,Terminal.Color.WHITE,Terminal.Color.RED);
				}

	    }
		}

}
