import greenfoot.*;

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int rocketX;
    public static int rocketY;
    public static boolean isBoom;
    
    public Rocket() {
        isBoom = false;
        turn(-90);
    }
    
    public void act() 
    {
        // Add your action code here.
        rocketX = getX();
        rocketY = getY();
        
        control();
        touched();
    }        
    
    public void control() {
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) setLocation(getX() - 5, getY());
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) setLocation(getX() + 5, getY());
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) setLocation(getX(), getY() - 5);
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) setLocation(getX(), getY() + 5);
    }
    
    public void touched() {
        if (getOneObjectAtOffset(0, 0, Rock.class) != null) {
            isBoom = true;
            setImage("explosion.png");
            Greenfoot.playSound("Explosion.wav");
        }
    }
}
