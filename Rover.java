/**
 * Functional Rover 
 * 
 * @author Carrington Jones 
 * @version (9/21/17)
 */

public class Rover {
    // fields
    private String name;
    private int x;
    private int y;
    private int dir; // 0=North, 1=East, 2=South, 3=West
    private int numPics; 
    // private double energy;
    private boolean isAlive = true;
    private int startingx;
    private int startingy;
    private int maxPics;
    
    /**
     * Constuctor(s)
     * 
     * @param name Naming the rover
     */
    public Rover(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = dir;
        // this.energy = 60;
        this.dir = 0;
        this.startingx = x;
        this.startingy = y; 
        this.maxPics = 3;
        
    }
    /**
     * Is returning the direction of the rover
     * 
     * @param dir Direction in numerical form 
     */
    private String getDirectionName() {
        if (isAlive) {
            if (dir == 0) {
                return "North";
                
            } else if (dir == 1) {
                return "North East";
                
            } else if (dir == 2) {
                return "East";
                
            } else if (dir == 3) {
                return "South East";
                
            } else if (dir == 4) {
                return "South";
                
            } else if (dir == 5) {
                return "South West";
                
            } else if (dir == 6) {
                return "West";
                
            } else if (dir == 7) {
                return "North West";
                
            } else {
                return null;
                
            }
        } else {
            System.out.println(name + " is disabled until further notice!");
            return null;
            
        }
    }          
    /**
    * Sets the name of the rover 
    * 
    * @param name The name of the rover 
    */
    public void setName(String name) {
        this.name = name; 
        
    }
    /** 
     * Public string that returns the rover name
     *
     * @return The name of the rover 
     */
    public String getName() {
        return name;
        
    } 
    /**
     * Teleports rover to a new location.
     * 
     * @param x new x coordinate 
     * @param y new y coordinate 
     */
    public void teleport(int x, int y) {
        System.out.println(name + " just teleported to (" + x + "," + y + ").");
        this.x = x;
        this.y = y; 
        
    } 
    // methods - stuff the Rover can do
    /** 
     * Basic move function
     * 
     * @param d Distance the rover is moving
     */
    public void move(int d) {
        if (dir == 0) {
            y += d;
            
        } else if (dir == 1) {
            x += d;
            y += d; 
            
        } else if (dir == 2) {
            x += d; 
            
        } else if (dir == 3) {
            x += d;
            y -= d;
            
            
        } else if (dir == 4) {
            y -= d;
            
        } else if (dir == 5) {
            x -= d;
            y -= d; 
            
            
        } else if (dir == 6) {
            x -= d;
            
        } else if (dir == 7) {
            x -= d;
            y += d;
            
            
        }
        System.out.println(name + " moved " + d + " places " + getDirectionName() + ".");
        
    }
        // this.energy -= (1*d);
        // System.out.println(name + "moved" + getDirectionName(dir) + " by " + d);
        // adjustEnergy(d * -5);
        
     /**
      * Moves the rover in a left direction
      */
     public void rotateLeft() {
        dir -= 1;
        
        if (dir < 0) {
            dir = 7;
            
        }
        System.out.println(name + " rotated to the left.");    
        
    }
    /** 
     * Moves the rover in a right 
     */
    public void rotateRight()
    {
        dir += 1;
        
        if (dir == 8) {
            dir = 0;
            
        }
        System.out.println(name + " rotated to the right.");  
        
    }
    /**
     * The rover is being turning in a positive or negative direction using a integer
     *
     * @param n How many times the rover will rotate 
     */
    public void rotate(int n) {
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                rotateRight();
                
            }
        } else {
            n = Math.abs(n);
            
            for (int i = 0; i < n; i++) {
                rotateLeft();
                
            }
        }
    }
    /**
     * @return basic info about the rover 
     */
    public String toString() 
    {
        return "Rover(Name: " + name + ", X = " + x + ", Y = " + y + ", Direction: " + getDirectionName() + ", Pictures: " + numPics +")";
       
    }
    /**
     * Takes pictures at coordinates 
     */
    public void takePicture() {
        if (numPics < maxPics) {
            System.out.println(name + " just snapped a picture at (" + x + "," + y + ") using the sepia filter !");
            numPics += 1;
            
        } else {
            System.out.println(" Memory is full, try posting pictures to instagram first and then try again.");
            
        }
    }
    /**
     * Sends Pictures to "Instagram"  
     */
    public void transmitPictures() {
        System.out.println(name + " just posted " + numPics + " pictures to Insta.");
        numPics = 0;
        
    }
    /**
     * Moves the rover to new coordinates
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public void moveTo(int x, int y) {
        if (dir != 0) {
            if (dir >= 0) {
                rotate (-dir);
                
            } else {
                rotate(dir);
                
            }
        }
        if (x >= this.x) {
            rotate(3);
            move(x - this.x);
            rotate(-3);
            
        } else {
            rotate(5);
            move(Math.abs(x - this.x));
            rotate(-5); 
            
        }
        if (y >= this.y) {
            move(y - this.y);
            
        } else {
            rotate(6);
            move(Math.abs(y - this.y));
            rotate(-6);
            
        }
    } 
    /**
     * Takes rover to original coordinates 
     */
    public void goHome() {
        moveTo(startingx, startingy);
        
    }
}