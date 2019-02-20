# Sudoku

## Description

This is a Kotlin project that implements an A* (a-star) algorithm for solving any solvable sudoku game of size 4x4 or 9x9. There are two options of classes for running this project: `Main.kt` and `SudokuGUI.java`, both of them use the same algorithm from `Sudoku.kt`. The first one runs in console/terminal, while the second one is a graphical user interface. In both of them you will be asked to input the size and a string that will represent the initial state of the sudoku (for empty spaces, insert a dot '.'). Example, taken from `Main.kt`:

![capture1](https://user-images.githubusercontent.com/20327882/53068756-2fecc000-349f-11e9-97e9-7cae1bb327f4.PNG)

The algorithm shows all of the steps for filling the sudoku grid. For example, these are the two final steps for the input shown above:

![capture2](https://user-images.githubusercontent.com/20327882/53068920-bd301480-349f-11e9-8254-4b57ab9d6734.PNG)

The class `SudokuGUI.java` works in a likely way:

![capture3](https://user-images.githubusercontent.com/20327882/53068999-0e400880-34a0-11e9-8e65-068ca4f9fe69.PNG)

Hope this helps you out, enjoy!
