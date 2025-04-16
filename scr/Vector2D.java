/**
 * @author Maximilien Notz
 * <p> This class aloud to create two-dimensional vector. The Vector is stored as two integer, x and y wich both represent vector cordinate.</p>
 */
public class Vector2D
{
    private int x;
    private int y;

    /**
     * Instantiate the vector.
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    public Vector2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Instantiate the vector, with the coordinate [0,0]
     */
    public Vector2D()
    {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Redefine the vector with the norm(the size) of the vector and its angle of elevation.
     * @param norm the norm of the vector.
     * @param angle the angle of the vector in gradient.
     * @return the new vector.
     */
    public Vector2D defVec(double norm, double angle)
    {
        this.x = (int)(Math.cos(angle) * norm);
        this.y = (int)(Math.sin(angle) * norm);
        return this;
    }

    /**
     * Return the x coordinate of the vector.
     * @return the x coordinate.
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Return the y coordinate of the vector.
     * @return the y coordinate.
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * set's the vector coordinate.
     * @param x the new x coordinate.
     * @param y the new y coordinate.
     */
    public void setCoordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the norm of the vector.
     */
    public double norm()
    {
        return Math.sqrt(x*x + y*y);
    }

    /**
     * Return elevation angle of the vector in gradient.
     * @return the elevation angle.
     */
    public double angle()
    {
        if(this.getX() != 0)
        {
            return Math.abs(Math.atan(this.y/this.x));
        }
        else
        {
            return 1.5707;//≈pi/2
        }
    }

    /**
     * Change the vector to the result of the addition between itself plus vec.
     * @param vec the vector added to the vector object.
     * @return the addition result of itself and the input vector.
     */
    public Vector2D add(Vector2D vec)
    {
        this.x += vec.getX();
        this.y += vec.getY();
        return this;
    }

    /**
     * Change the vector value to the result of the addition of itself plus the input vector.
     * @param X new vector x coordinate
     * @param Y new vector y coordinate
     * @return the addition result of itself and the input vector.
     */
    public Vector2D add(int X, int Y)
    {
        this.x += X;
        this.y += Y;
        return this;
    }

    /**
     * Change the vector value to the result of the subtraction of itself minus the input vector.
     * @param vec the subtrahend vector.
     * @return the subtraction result of itself and the input vector.
     */
    public Vector2D subtract(Vector2D vec)
    {
        this.x -= vec.getX();
        this.y -= vec.getY();
        return this;
    }

    /**
     * Change the vector value to the result of the subtraction of itself minus the input vector.
     * @param X the subtrahend vector x coordinate.
     * @param Y the subtrahend vector y coordinate.
     * @return the subtraction result of itself and the input vector.
     */
    public Vector2D subtract(int X, int Y)
    {
        this.x -= X;
        this.y -= Y;
        return this;
    }

    public Vector2D multiply(int x, int y)
    {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public Vector2D multiply(Vector2D vec)
    {
        this.x *= vec.getX();
        this.y *= vec.getY();
        return this;
    }

    /**
     * Return the coordinate of the vector in as a string. "[x,y]" this is the format, Such as "[x,y]", x = 0 and y = 50 then the output will be "[0,50]".
     * @return the coordinate of the vector in as a string.
     */
    @Override
    public String toString()
    {
        return "[" + this.getX() + "," + this.getY() + "]" + Thread.currentThread().getName();
    }

    /**
     * This methode return the vector as int array,
     * such that the return of the methode of a vector with the component following component: x = 2 and y = 5,
     * the return is {2,5}
     */
    public int[] toIntArray()
    {
        return new int[]{this.x, this.y};

    }
}