class State(val grid: Array<IntArray>, val father: State?, val prevAction: Int) {

    companion object {
        var iterations = 0
    }

    val pathCost: Int = if (father != null) father.pathCost + 1 else 0
    val next = nextSpace()
    val actions = returnActions()

    init {
        iterations++
        println(pathCost)
        println("next: ${next?.first}, ${next?.second}")
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
        val x: Int
        val y: Int
        val length = grid.size

        for (array in grid) {
            for (i in 0 until length) {
                if (array[i] == 0) {
                    y = grid.indexOf(array)
                    x = i
                    return Pair(x, y)
                }
            }
        }
        return null
    }

    private fun returnActions(): ArrayList<Int> {
        val array = ArrayList<Int>()
        for (i in 0 until grid.size) array.add(i + 1)
        if (next != null) {
            val row = grid[next.second]

            for ((index, value) in row.withIndex()) {
                if (value != 0 && index != next.first)
                    array[value - 1] = 0
            }

            for ((index, value) in grid.withIndex()) {
                if (value[next.first] != 0 && index != next.second)
                    array[value[next.first] - 1] = 0
            }
        } else return ArrayList()
        for (i in array) print(i)
        println()
        return array
    }

    override fun toString(): String {
        var out = ""
        for (i in 0 until (grid.size * 2 + 1)) {
            out += '-'
        }
        out += '\n'
        for (array in grid) {
            out += '|'
            for (i in array) {
                out += "$i|"
            }
            out += '\n'
            for (i in 0 until (grid.size * 2 + 1)) {
                out += '-'
            }
            out += '\n'
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
        val row = grid[y]
        for ((index, value) in row.withIndex()) {
            if (value == num && index != x)
                return true
        }

        for ((index, array) in grid.withIndex()) {
            if (array[x] == num && index != y)
                return true
        }
        return false
    }

    fun solve(): ArrayList<State> {
        if (isSolvable()) {
            if (goalTest()) {
            } else {
                val children = returnChildren()
                if (children.size > 0) {
                    children.sortBy { it.heuristic() }
                    for (child in children) {
                        child.solve()
                    }
                }
            }
        }
        return ArrayList()
    }

    fun returnChildren(): ArrayList<State> {
        val children: ArrayList<State> = ArrayList()
        if (next != null) {
            for (action in actions) {
                if  (action != 0){

                    val newGrid = grid.copyOf()
                    newGrid[next.second][next.first] = action
                    val state = State(newGrid, this, action)
                    children.add(state)
                    println()
                    println("antes de agregar a children:\n$children")
                }
            }
            return children
        }
        return ArrayList()
    }
}