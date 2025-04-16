import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CellularAutomaton2D extends JFrame
{
    //sim settings
    private final int gridThickness = 0;
    private final byte FPS = 25;
    private final int size = 200;
    private final Color aliveColor = Color.black;
    private final Color deadColor = Color.white;

    //sim atribute
    private int cellSize;
    private Rules simRule;
    private int genCount;

    public byte[][] body = new byte[this.size][this.size];

    public CellularAutomaton2D(int gridSize, Rules simRule)
    {
        //Jframe instantiation
        this.setBackground(Color.gray);
        this.setSize(gridSize, gridSize);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //attribute
        this.simRule = simRule;
        this.cellSize = gridSize/size;
        this.genCount = 0;

        for (int i = 0; i < this.body.length; ++i)
        {
            for (int j = 0; j < this.body.length; ++j)
            {
                this.body[i][j] = 0;
            }
        }
        this.repaint();
    }

    public void paint(Graphics g)
    {
        this.setTitle("generation " + String.valueOf(this.genCount));
        this.setBackground(Color.gray);
        for (int x = 0; x < this.body.length; ++x)
        {
            for (int y = 0; y < this.body.length; ++y)
            {
                if(this.body[x][y] == 1)
                {
                    g.setColor(this.aliveColor);
                }
                else if (this.body[x][y] == 0)
                {
                    g.setColor(this.deadColor);
                }
                g.fillRect(x * (this.cellSize + this.gridThickness),y * (this.cellSize + this.gridThickness), this.cellSize, this.cellSize);
            }
        }
    }

    public final void refresh()
    {
        ++this.genCount;
        this.body = updateBody();
        this.repaint();
        try
        {
            Thread.sleep(1000/this.FPS);
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private byte[][] updateBody()
    {
        byte[][] cloneGrid = new byte[this.body.length][this.body.length];

        for (int x = 1; x < this.body.length - 1; ++x)
        {
            for (int y = 1; y < this.body.length - 1; ++y)
            {
                cloneGrid[x][y] = this.simRule.RulesExecutor(x, y,this);
            }
        }
        return cloneGrid;
    }

    /**
     * Count the amount of living neighbors around a predefined cell.
     * @param x The x coordinate of the cell.
     * @param y The y coordinate of the cell.
     * @return  Returns the amount of living neighbors around a predefined cell.
     */
    public final int countNeighbour(int x, int y)
    {
        int count = 0;
        for(int[] i : new int[][]{{1,1},{-1,-1},{-1,1},{1,-1},{1,0},{-1,0},{0,1},{0,-1}})
        {
            if(this.body[x + i[0]][y + i[1]] == 1)
            {
                ++count;
            }
        }
        return count;
    }

    /**
     * This methode apply a pattern to the body.
     * @param origin The origin of the pattern.
     * @param vectorsLst The list of coordinate that will make the pattern.
     */
    public final void applyPattern(int[] origin ,int[][] vectorsLst)
    {
        for (int[] vec : vectorsLst)
        {
            this.body[vec[0] + origin[0]][vec[1] + origin[1]] = 1;
        }
    }

    /**
     * This methode apply a pattern to the body.
     * @param origin The origin of the pattern.
     * @param vectorsLst The list of coordinate that will make the pattern.
     */
    public final void applyPattern(Vector2D origin , Vector2D[] vectorsLst)
    {
        for (Vector2D vec : vectorsLst)
        {
            this.body[vec.getX() + origin.getX()][vec.getY() + origin.getY()] = 1;
        }
    }

    /**
     * This methode set each body cell at a random state.
     */
    public final void randomise()
    {
        Random rand = new Random();
        for (int i = 0; i < this.body.length; ++i)
        {
            for (int j = 0; j < this.body.length; ++j)
            {
                this.body[i][j] =  (byte)(rand.nextBoolean() ?  1 : 0);
            }
        }
    }

    public final int getGenCount()
    {
        return genCount;
    }
}
