fun main() {
    println("Welcome to Sudoku Sover.\n")
    println("Select the size of your sudoku:\n\n1. 4x4\n2. 9x9\n\n")
    var op = readLine()
    while (op != "1" && op != "2") {
        println("Unvalid option. Select either 1 or 2: ")
        op = readLine()
    }

    println("Now, please insert the string for the sudoku: ")
    var initialString = readLine()
    while (!initialString!!.matches("[0-9.]+".toRegex())) {
        println("Unvalid string. Use only numbers and '.' for spaces: ")
        initialString = readLine()
    }

    val squares = if (op == "1") 2 else 3
    val sudoku = Sudoku(squares, initialString)
    if (sudoku.isSolvable()) {
        val solution = sudoku.solve()
        var counter = 0
        for (state in solution)
            println("Step $counter: \n\n$state")
    }
    else
        println("The sudoku inserted is unsolvable.")

}