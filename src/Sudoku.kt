import kotlin.collections.ArrayList
import kotlin.math.pow

class Sudoku(squares: Int, initialString: String) {

    private val numMax: Int = squares.toFloat().pow(2).toInt()
    private val initialState: State

    init {
        this.initialState = State(setInitialState(initialString), null, 0)
    }

    private fun setInitialState(string: String): Array<IntArray> {
        var counter = 0
        val grid = Array(numMax) { IntArray(numMax) }
        for (intArray in grid) {
            for (i in 0 until numMax) {
                intArray[i] = if (string[counter] == '.') 0 else string[counter].toInt() - 48
                counter++
            }
        }
        return grid
    }

    fun isSolvable() = this.initialState.isSolvable()

    fun solve() = this.initialState.solve()

}