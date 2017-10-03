
/**
 * Write a description of class Rover here.
 * 
 * @author Carrington Jones 
 * @version (9/21/17)
 */
public class Rover
{
    // fields
    private String name;
    private int x;
    private int y;
    private int dir; // 0=North, 1=East, 2=South, 3=West
    private int numPics; 
    private int maxPics;
    private double energy;
    private boolean isAlive; 

    // constructor(s)
    public Rover(String name, int x, int y, int dir) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isAlive = true; 
        this.energy = 60;
        this.maxPics = 15;
        this.numPics = 0; 
    }
    /**
     * The name of the rover is changed
     * @param Name the name of the rover 
     */
    public void setName(String name) {
        this.name = name; 
    }
    
    
    // methods - stuff the Rover can do
    public void move(int w)
    {
        if (dir == 0)
        {
            y += w;
        }
        else if (dir == 1)
        {
            x += w;
        }
        else if (dir == 2)
        {
            y -= w;
        }
        else 
        {
            x -= w;
        }
        
        this.energy -= (1*w);
        
        
        //System.out.println(name + "moved" + getDirectionName(dir) + " by " + w);
        //adjustEnergy(w * -5); 
    }
    
    public void rotateLeft() 
    {
        dir -= 1;
        
        if (dir < 0)
        {
            dir = 3;
        }
        
        System.out.println(name + " turned to the left");        
    }
    
    public void rotateRight()
    {
        dir += 1;
        
        if (dir == 4)
        {
            dir = 0;
        }
        
        System.out.println(name + " turned to the right");        
    }

    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + "]";
    }
}
