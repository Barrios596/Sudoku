class State(private val grid: IntArray) {

    fun heuristic(option: Int): Int {
        return 0
    }

    fun actions(): IntArray {
        return IntArray(0)
    }

    override fun toString(): String {
        return super.toString()
    }

    fun goalTest(): Boolean {
        return false
    }

    fun result(option: Int): State? {
        return null
    }

}