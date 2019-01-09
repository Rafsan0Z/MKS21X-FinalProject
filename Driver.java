import java.util.ArrayList;
public class Driver{

  private ArrayList<Integer> mistakes = new ArrayList<Integer>();
  private int[] dim = new int[2];

  public boolean checkAnswer(String[][] puzzle){
    for(int i = 0; i < dim[0]; i++){
      for(int j = 0; j < dim[1]; j++){
        if(!Mistake(i,j,puzzle)){return false;}
      }
    }
    return true;
  }

  public boolean Mistake(int row, int col, String[][] puzzle){
    if(puzzle[row][col] == "__"){return false;}
    if(Integer.parseInt(puzzle[row][col]) > 9 || Integer.parseInt(puzzle[row][col]) < 0){return false;}
    int num = Integer.parseInt(puzzle[row][col]);
    for(int i = 0; i < dim[0]; i++){
      ArrayList<Integer> rows = new ArrayList<Integer>();
      for(int j = 0; j < dim[1]; j++){
        if(i != row && j != col && !puzzle[i][j].equals("__")){rows.add(Integer.parseInt(puzzle[i][j]));}
        if(rows.contains(num)){
          mistakes.add(row);
          mistakes.add(col);
          return false;
        }
      }
    }
    return true;
  }

  public boolean add(int row, int col, int num, String[][] puzzle){
    puzzle[row][col] = " " + num;
    return true;
  }

  public boolean remove(int row, int col, String[][] puzzle){
    puzzle[row][col] = "__";
    return true;
  }

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

  public static String CustomPrint(String[][] puzzle){
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
    puzzle = question.getPuzzle();
    System.out.println(StandardPrint(puzzle));
  }

}
