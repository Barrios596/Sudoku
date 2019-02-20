import kotlin.math.sqrt

class State(val grid: Array<IntArray>, val father: State?, val prevAction: Int) {

    val id: Int

    companion object {
        var solution = ArrayList<State>()
        var totalStates = 0
    }

    val pathCost: Int = if (father != null) father.pathCost + 1 else 0
    val next = nextSpace()
    val actions = returnActions(next)

    init {
        id = totalStates
        totalStates++
    }

    fun resetStaticVariables() {
        solution = ArrayList<State>()
        totalStates = 0
    }

    fun isSolvable(): Boolean {
        for (array in grid) {
            for (i in 0 until array.size) {
                if (array[i] != 0)
                    if (checkConflict(array[i], i, grid.indexOf(array))) return false
            }
        }
        return true
    }

    fun heuristic(): Int {
        var count = 0
        for (array in grid) {
            for (i in 0 until array.size) {
                if (array[i] == prevAction) count++
            }
        }
        return grid.size - count
    }

    private fun nextSpace(): Pair<Int, Int>? {
        val options = ArrayList<Pair<Int, Pair<Int, Int>>>()
        val length = grid.size

        for (array in grid) {
            for (i in 0 until length) {
                if (array[i] == 0) {
                    val position = Pair(i, grid.indexOf(array))
                    options.add(Pair(returnActions(position).size, position))
                }
            }
        }
        val sortedOptions = options.sortedWith(compareBy { it.first })
        return if (sortedOptions.isNotEmpty()) sortedOptions[0].second else null
    }

    private fun returnActions(position: Pair<Int, Int>?): ArrayList<Int> {
        val array = ArrayList<Int>()
        val out = ArrayList<Int>()
        for (i in 0 until grid.size) array.add(i + 1)

        if (position != null) {

            //check the box
            val boxSize = sqrt(grid.size.toDouble()).toInt()
            //use division to get the box's index (truncate) and then use box size
            val boxStartX = position.first / boxSize * boxSize
            val boxStartY = position.second / boxSize * boxSize

            for (i in boxStartY until boxStartY + boxSize) {
                for (j in boxStartX until boxStartX + boxSize) {
                    if (i != position.second || j != position.first) {
                        if (grid[i][j] != 0)
                            array[grid[i][j] - 1] = 0
                    }
                }
            }

            val row = grid[position.second]

            for ((index, value) in row.withIndex()) {
                if (value != 0 && index != position.first)
                    array[value - 1] = 0
            }

            for ((index, value) in grid.withIndex()) {
                if (value[position.first] != 0 && index != position.second)
                    array[value[position.first] - 1] = 0
            }
            for (action in array) {
                if (action != 0) out.add(action)
            }
        }
        else return ArrayList()
        return out
    }

    override fun toString(): String {
        val boxSize = sqrt(grid.size.toFloat()).toInt()
        var out = ""
        for (i in 0 until (grid.size + boxSize + 1)) {
            out += '-'
        }
        out += '\n'
        for ((indice, array) in grid.withIndex()) {
            out += '|'
            for ((index, i) in array.withIndex()) {
                out += if (i == 0) " " else "$i"
                if (index != 0)
                    if ((index + 1) % boxSize == 0) out += "|"
            }
            out += '\n'
            if (indice != 0)
                if ((indice + 1) % boxSize == 0) {
                    for (i in 0 until (grid.size + boxSize + 1)) {
                        out += '-'
                    }
                    out += '\n'
                }
        }
        return out
    }

    fun goalTest(): Boolean {
        for (array in grid) {
            for (i in array) {
                if (i == 0) return false
            }
        }
        return true
    }

    private fun checkConflict(num: Int, x: Int, y: Int): Boolean {
        //check the row
        val row = grid[y]
        for ((index, value) in row.withIndex()) {
            if (value == num && index != x)
                return true
        }

        //check the column
        for ((index, array) in grid.withIndex()) {
            if (array[x] == num && index != y)
                return true
        }

        //check the box
        val boxSize = sqrt(grid.size.toDouble()).toInt()
        //use division to get the box's index and then use box size
        val boxStartX = x / boxSize * boxSize
        val boxStartY = y / boxSize * boxSize

        for (i in boxStartY until boxStartY + boxSize) {
            for (j in boxStartX until boxStartX + boxSize) {
                if (i != y || j != x) {
                    if (grid[i][j] == num)
                        return true
                }
            }
        }

        return false
    }

    fun insertToSolution() {
        solution.add(this)
        if (this.id != 0)
            father!!.insertToSolution()
    }

    fun returnChildren(): ArrayList<State> {
        val children: ArrayList<State> = ArrayList()
        if (next != null) {
            for (action in actions) {
                if (action != 0) {
                    val newGrid = Array(grid.size) { IntArray(grid.size) }
                    for ((index, array) in grid.withIndex()) {
                        val row = IntArray(array.size)
                        for ((indice, value) in array.withIndex()) {
                            row[indice] = value
                        }
                        newGrid[index] = row
                    }
                    newGrid[next.second][next.first] = action
                    val state = State(newGrid, this, action)
                    children.add(state)
                }
            }
            return children
        }
        return ArrayList()
    }

    //fun returnGrid(): Array<IntArray> = grid

}