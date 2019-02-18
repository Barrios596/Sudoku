import kotlin.collections.ArrayList
import kotlin.math.pow

class Sudoku(squares: Int, initialString: String) {

    private val numMax: Int = squares.toFloat().pow(2).toInt()
    private val initialState: State
    private val frontier = HashMap<Int, State>()
    private val explored = HashMap<Int, State>()

    init {
        this.initialState = State(setInitialState(initialString), null, 0)
        frontier[this.initialState.id] = this.initialState
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

    fun solve(): ArrayList<State> {
        var count = 0
        while (frontier.size > 0) {
            val sortedFrontier = frontier.toList().sortedBy { it.second.heuristic() + it.second.pathCost }
            //println("sorted frontier:")
            /*for (state in sortedFrontier){
                print("${state.second.id},")
            }*/
            //println()
            //println()
            val selected = sortedFrontier[0].second
            explored[selected.id] = selected

            if (selected.goalTest()) {
                selected.insertToSolution()
                return State.solution
            }
            else {
                for (child in selected.returnChildren()) {
                    if (!explored.containsKey(child.id)) {
                        /*println(child.toString())
                        println()
                        */if (child.returnChildren().size > 0 || child.goalTest()){
                            frontier[child.id] = child
                        }
                    }
                }
                frontier.remove(selected.id)
            }
            count++
        }
        return ArrayList()
    }
}