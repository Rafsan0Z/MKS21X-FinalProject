# MKS21X-FinalProject

How to play Sudoku:

1. In the main menu, if C is pressed then all the controls are shown. These are used in all the puzzles. The next page can be reached by pressing space

2. In the second page, it list all the puzzles available in the game. They can each be reached by pressing space

3. To start add you must press a. Then you must enter the row, column and number in that order and press enter everytime a number is added

4. To remove a number you only need to enter the row and column.

Here are the bugs of the game:

1. The game doesnt give an answer to a puzzle

Development Log

01/04/19: Added all the files described in the prototype. Sudoku abstract class along with StandardSudoku and CustomSudoku which both 
extends Sudoku. Constructors and abstract class were added for each subclass but not implemented. An empty Driver class has also been added.

01/05/19:

01/06/19: Add method and Mistake method updated in Driver file. I also added an ArrayList to keep track of the mistakes in Sudoku. I also added the remove method which removes a number from the puzzle.

01/07/19: InputNums in StandardSudoku implemented, but only works on even dimensions. Driver is updated to test both CustomSudoku and StandardSudoku. Small mistakes in all the files corrected and toString method changed to PrintPuzzle.

01/08/19: Write InputNums for CustomSudoku. I also wrote code in Driver to test PrintPuzzle and InputNums method of both StandardSudoku and CustomSudoku. InputNums for StandardSudoku needs to be fixed and more helper methods and private field added.

01/09/19:

01/10/19:

01/11/19:

01/12/19:

01/13/19:

01/14/19: I updated the StandardSudoku mode and introduced methods to print a CustomSudoku in Terminal. For the moment, the method only prints a 12 by 12 puzzle. I created another mode for the 12 by 12 puzzle and getpuzzle in CustomSudoku file to aid in printing. I also added remove and add method to the file. 

01/15/19:

01/16/19: ListMistake and printMistake method created to find mistakes and print them on the screen. The main menu containing all controlls info created and getSize methods added to both Sudoku files. After several test, I found some mistake in the Mistake method in StandardSudoku and also solved the problem in adding (by taking away Scanner close). 

01/17/19: The blinking effect corrected and messages added to indicate what action is taking place

01/18:19: Fixed mistakes in function and filename. Studying the algorithms needed to solve a Standard 9 by 9 Sudoku puzzle

01/19/19:

01/20/19:

01/21/19:

01/22/19:



