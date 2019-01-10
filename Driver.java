import java.util.ArrayList;
import java.util.Scanner;
public class Driver{

  private int[] dim = new int[2];

  public int levelcounter(String stage){
    if(stage == "E"){return 21;}
    if(stage == "M"){return 19;}
    if(stage == "H"){return 17;}
    return 0;
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

  public static String CustomPrint(int length, int width, String[][] puzzle){
    String result = "-------------------" + "\n";
    for(int i = 0; i < width; i++){
      result += "|";
      for(int j = 0; j < length; j++){
        result += puzzle[i][j];
        if(j == length - 1){result += "\n";}
      }
    }
    return result;
  }

  public static void main(String[] args){
/*    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to Sudoku!")
    System.out.println("Choose the difficulity: E for Easy, M for Medium and H for Hard");
    String level = input.nextLine(); This will become the final code!
    int count = levelcounter(level);
    input.close();
    */
    String[][] puzzle;
    StandardSudoku question = new StandardSudoku(17);
    puzzle = new String[9][9];
    Scanner input = new Scanner(System.in);
    System.out.println("Provide input coordinates and num");
    int row = input.nextInt();
    int col = input.nextInt();
    int num = input.nextInt();
    question.add(row,col,num);
    puzzle = question.getPuzzle();
    System.out.println(StandardPrint(puzzle));
    System.out.println(question.Mistake(0 , 1));
  }

}
