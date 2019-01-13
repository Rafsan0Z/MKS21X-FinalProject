

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

			int x = 10;
			int y = 10;

	    Terminal terminal = TerminalFacade.createTextTerminal();
	    terminal.enterPrivateMode();

	    TerminalSize size = terminal.getTerminalSize();
	    terminal.setCursorVisible(false);

	    boolean running = true;
	    int mode = 0;
	    long lastTime =  System.currentTimeMillis();
	    long currentTime = lastTime;
	    long timer = 0;

			StandardSudoku question = new StandardSudoku(17);
			String[][] puzzle = question.getPuzzle();

	    while(running){

				terminal.moveCursor(x,y);
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
	        }

	        //for all modes
	        if (key.getCharacter() == ' ') {
	          mode++;
	          mode%=3;//2 modes
	          terminal.clearScreen();
	          lastTime = System.currentTimeMillis();
	          currentTime = System.currentTimeMillis();
	        }
	      }

	      terminal.applySGR(Terminal.SGR.ENTER_BOLD);
	      putString(1,1,terminal, "This is mode "+mode,Terminal.Color.WHITE,Terminal.Color.RED);
	      terminal.applySGR(Terminal.SGR.RESET_ALL);


	      if(mode==0){
	        lastTime = currentTime;
	        currentTime = System.currentTimeMillis();
	        timer += (currentTime -lastTime);//add the amount of time since the last frame.
	        //DO GAME STUFF HERE
	        putString(1,3,terminal, "Welcome to Sudoku",Terminal.Color.WHITE,Terminal.Color.GREEN);
	        putString(3,5,terminal, "Time: "+timer,Terminal.Color.WHITE,Terminal.Color.RED);

	      }else if (mode == 1){

	        terminal.applySGR(Terminal.SGR.ENTER_BOLD,Terminal.SGR.ENTER_BLINK);
	        putString(1,3,terminal, "Not game, just a pause!",Terminal.Color.RED,Terminal.Color.WHITE);
	        terminal.applySGR(Terminal.SGR.RESET_ALL);

	      }else if(mode == 2){
					terminal.applySGR(Terminal.SGR.ENTER_BOLD,Terminal.SGR.ENTER_BLINK);
	        putPuzzle(terminal,StandardPrint(puzzle),Terminal.Color.WHITE,Terminal.Color.WHITE);
	        terminal.applySGR(Terminal.SGR.RESET_ALL);
					putString(1,3,terminal, "x position:" +x,Terminal.Color.WHITE,Terminal.Color.GREEN);
				  putString(3,5,terminal, "y position: "+y,Terminal.Color.WHITE,Terminal.Color.RED);
					if(key != null){
						boolean yes = false;
						if(key.getKind() == Key.Kind.Insert){yes=true;}
						while(yes){
							if(Character.isDigit(key.getCharacter())){
								int row = Character.getNumericValue(key.getCharacter());
								int col = Character.getNumericValue(key.getCharacter());
								int num = Character.getNumericValue(key.getCharacter());
							}
								terminal.moveCursor(x,y);
								question.add(row,col,num);
								x++;
								yes = false;
							}
						}
				}

	    }


	  }
}
