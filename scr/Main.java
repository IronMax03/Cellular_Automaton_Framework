public class Main
{
    public static void main(String[] args)
    {
        /*
        CellularAutomaton2D gameOfLife = new CellularAutomaton2D(800, RulesList.CONWAY_GAME_OF_LIFE);

        int[][] glider = new int[][]{{-1,1},{0,0},{1,0},{1,1},{1,2}};
        int[][] gliderGun = new int[][]{{0,3},{0,4},{1,3},{1,4},//square
                                        {10,2},{10,3},{10,4},{11,1},{12,0},{13,0},{11,5},{12,6},{13,6},{14,3},{16,3},{17,3},{16,2},{16,4},{15,1},{15,5},
                                        {20,4},{20,5},{21,4},{21,5},{20,6},{21,6},{22,7},{22,3}, {24,7}, {24,8},{24,3},{24,2},
                                        {24+10,5},{25+10,5},{24+10,6},{25+10,6}};

        for(int i = 0; i < 9; ++i)
        {
            gameOfLife.applyPattern(new int[]{2 + 20 * i, 90 + 10 * i}, gliderGun);
        }*/


        CellularAutomaton2D elementaryCellularAutomaton = new CellularAutomaton2D(800, RulesList.RULE_90);
        //elementaryCellularAutomaton.randomise();
        elementaryCellularAutomaton.applyPattern(new int[]{50,1}, new int[][]{{0,0}});

        try
        {
            Thread.sleep(5_000);
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }


        for (; ; )
        {
            //gameOfLife.refresh();
            elementaryCellularAutomaton.refresh();
        }


    }
}