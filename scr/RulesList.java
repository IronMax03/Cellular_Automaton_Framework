/**
 * This class holds some cellular automaton rules.
 */
public abstract class RulesList
{
    public static final Rules CONWAY_GAME_OF_LIFE = (int x, int y, CellularAutomaton2D This) ->
    {
        int neighborCount = This.countNeighbour(x, y);
        if(This.body[x][y] == 0 && neighborCount == 3)
        {
            return (byte) 1;
        }
        else if (This.body[x][y] == 1 && !(neighborCount == 3 || neighborCount == 2))
        {
            return (byte) 0;
        }
        else
        {
            return This.body[x][y];
        }
    };

    public static final Rules RULE_90 = (int x, int y, CellularAutomaton2D This) ->
    {
        byte[][] inputPattern = new byte[][]{   {1, 1, 1},{1, 1, 0},
                                                {1, 0, 1},{1, 0, 0},
                                                {0, 1, 1},{0, 1, 0},
                                                {0, 0, 1},{0, 0, 0}};
        byte[] outputPattern = new byte[]{0, 1, 0, 1, 1, 0, 1, 0};//{false, true, false, true, true, false, true, false}

        int i = 0;
        for (; i < inputPattern.length; ++i)
        {
            if(y != This.getGenCount()+1) break;
            else if(This.body[x-1][y-1] == inputPattern[i][0] && This.body[x][y-1] == inputPattern[i][1] && This.body[x+1][y-1] == inputPattern[i][2])
            {
                return outputPattern[i];
            }
        }
        return This.body[x][y];
    };
}
