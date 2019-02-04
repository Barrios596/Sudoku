import java.util.*
import kotlin.math.pow

class Sudoku(private val squares: Int, initialArray: IntArray) {

    private val numMax: Int
    private val states = Stack<State>()
    private val initialState: State

    init {
        this.numMax = squares.toFloat().pow(2).toInt()
        this.initialState = State(initialArray)
        states.push(initialState)
    }

    fun isSolvable(): Boolean {
        return true
    }

    fun solve() {

    }

}