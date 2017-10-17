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
    //private int maxPics;
    // private double energy;
    private boolean isAlive = true;
    private int startingx;
    private int startingy;
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
    }
    /**
     * Is returning the direction of the rover
     * Once the direction of the rover is given, it tells you where its moved
     * @param dir Direction
     * @param direction The direction the rover is moving in numbers
     * @param north,east,south,and west Moved in which direction 
     * @param null Value of zero, no variable 
     */
    private String getDirectionName(int dir) {
        if (isAlive) {
            if (dir == 0) {
                return "North";
            } else if (dir == 1) {
                return "North North";
            } else if (dir == 2) {
                return "North East";
            } else if (dir == 3) {
                return "North South";
            } else if (dir == 4) {
                return "North West";
            } else if (dir == 5) {
                return "East";
            } else if (dir == 6) {
                return "East North";
            } else if (dir == 7) {
                return "East South";
            } else if (dir == 8) {
                return "East west";
            } else {
                return null;
            }
        } else {
            System.out.println(name + " is disabled until further notice!");
            return null;
        }
    }          
    /**
    * The name of the rover is changed
    * @param Name the name of the rover 
    */
    public void setName(String name) {
        this.name = name; 
    }
    /** 
     * @param getName() Public string, that returns the rover name 
     */
    public String getName() {
        return name;
    } 
    /**
     * Calling rover String name this.x and this.y
     * @param teleport public function
     */
    public void teleport(int x, int y) {
        System.out.println(name + " just teleported to [" + x + "," + y + "].");
        this.x = x;
        this.y = y; 
    } 
    // methods - stuff the Rover can do
    /** 
     * Move functions
     * @param d Distance the rover is moving
     * @param dir Direction in which the rover is moving 
     * y = private int y, moves in the y direction
     * x = private int x, moves in the x direction 
     * Moves in 8 directions 
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
        System.out.println(name + " moved " + d + " places " + getDirectionName(dir) + ".");
    }
        // this.energy -= (1*d);
        // System.out.println(name + "moved" + getDirectionName(dir) + " by " + d);
        // adjustEnergy(d * -5);
     /**
      * rotateLeft() Moves the rover left
      */
     public void rotateLeft() {
        dir -= 1;
        if (dir < 0) {
            dir = 7;
        }
        System.out.println(name + " rotated to the left.");        
    }
    /** 
     * rotateRight() Moves the rover right
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
     * Rover is being turned in a positive or negative direction based on the int
     * Universal Rotation
     * Used int i, whenever it reaches 8 it'll stop the loop 
     * After the loop, it increments 1 by i++ which stops the loop once it meets 8
     * @param d How many times the rover should rotate 
     * @param math.abs(d) Returns the absolute value of the int
     */
    public void rotate(int d) {
        if (d >= 0) {
            for (int i = 0; i < d; i++) {
                rotateRight();
            }
        } else {
            d = Math.abs(d);
            for (int i = 0; i < d; i++) {
                rotateLeft();
            }
        }
    }
    /**
     * Returning the basic knowledge for the rover
     */
    public String toString() 
    {
        return "Rover[Name = " + name + ", X = " + x + ", Y = " + y + ", Direction = " + getDirectionName(dir) + ", Pictures = " + numPics +"]";
    }
    /**
     * Takes Pictures 
     * Can't take more than 3 pictures or memory will be full
     * @param takePicture() public function 
     * 
     */
    public void takePicture() {
        numPics += 1;
        if (numPics > 3) {
            System.out.println(" Memory is full, try posting pictures to instagram first and then try again.");
            numPics -= 1;
        } else {
            System.out.println(name + " just snapped a picture at [" + x + "," + y + "] using the sepia filter !");
        }
    }
    /**
     * Sends Pictures to "Instagram" 
     * @param transmitPicturs() public function 
     */
    public void transmitPictures() {
        System.out.println(name + " just posted " + numPics + " pictures to Insta.");
        numPics = 0;
    }
    /**
     * Rotates Rover in a negative and positive direction 
     * @param moveTo public function
     */
    public void moveTo(int x, int y) {
        if (dir != 0) {
            if (dir >= 0) {
                rotate (-dir);
            } else {
                rotate(dir);
            }
        }
        if (x >= 0) {
            rotate(2);
            move(x - this.x);
            rotate(-2);
        } else {
            rotate(6);
            move(Math.abs(x - this.x));
            rotate(-6); 
        }
        if (y >= 0) {
            move(y - this.y);
        } else {
            rotate(4);
            move(Math.abs(y - this.y));
            rotate(-4);
        }
    } 
    /**
     * Takes the rover home, to its original coordinates 
     */
    public void goHome() {
        moveTo(startingx, startingy);
    }
}