/**
 * Runs rover
 * 
 * @author (Carrington Jones) 
 * @version (9/21/17)
 */
import java.util.Scanner;

public class RoverRunner
{
    public static void main(String[] args)
    {
        SimpleScanner input = new SimpleScanner();
        
        Rover r1 = new Rover("Yoda");
        Rover r2 = new Rover("Spirit");
        Rover r3 = new Rover("R2-D2");
        Rover r4 = new Rover ("BRUHHH");
        
        RoverGroup group = new RoverGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        
        boolean running = true;
        String exitCommand = "stop";
        
        while (running) {
            System.out.print("Type Rover Name Here: ");
            String name = input.readString();
            
            Rover actor = group.find(name);
            
            if (actor != null) {
                System.out.println("Type a menu number here:");
                System.out.println("(1) Rover Movement");
                System.out.println("(2) Rotation to the right");
                System.out.println("(3) Rotation to the left");
                System.out.println("(4) Teleportation");
                System.out.println("(5) Go Home");
                System.out.println("(6) Take a fire instagram picture");
                System.out.println("(7) Add cool Sepia filter to picture");
                System.out.println("(8) Post picture to instagram");
                String command = input.readString();
                
                if (command.equals("1")) {
                    System.out.println(" Type a x coordinate to move the Rover: ");
                    int x = input.readInt();
                    System.out.println(" Type a y coordinate to move the Rover: ");
                    int y = input.readInt();
                    actor.moveTo(x, y);
                    
                } else if (command.equals("2")) {
                    actor.rotateRight();
                    
                } else if (command.equals("3")) {
                    actor.rotateLeft();
                    
                } else if (command.equals("4")) {
                    System.out.println(" Type a rover x coordinate to teleport: ");
                    int x = input.readInt();
                    System.out.println(" Type a rover y coordinate to teleport:  ");
                    int y = input.readInt();
                    actor.teleport(x, y);
                    
                } else if (command.equals("5")) {
                    actor.goHome();
                    
                } else if (command.equals("6")) {
                    actor.takePicture();
                    
                } else if (command.equals("7")) {
                    System.out.println("Add the Sepia Filter to " +  name  + "'s instagram photo!");
                    String filter = input.readString();
                    actor.takePicture();
                    
                } else if (command.equals("8")) {
                    actor.transmitPictures();
                    
                } else { 
                    System.out.println(" Failed: Command doesnt exist. ");
                    
                }
                System.out.println(actor);
                
           } else if (name.equals(exitCommand)) {
                running = false; 
                
           } else {
                System.out.println(" Failed: " + name + " could not be found.");
                
           }
            System.out.println();
            
        }
        System.out.println("ADIOS.");
        
    }
}