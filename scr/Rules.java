@FunctionalInterface
public interface Rules
{
    /**
     * This methode contains the Rules of the cellular automaton. This methode is call to define the future state of a cell.
     * @param x The x coordinate of the cell.
     * @param y The y coordinate of the cell.
     * @param This This parameter aloud the methode to access to the cellular, This variable use for example to access the 2D array to look at the state of the neighbors.
     * @return This methode return the future state of the current cell.
     */
    byte RulesExecutor(int x, int y, CellularAutomaton2D This);
}