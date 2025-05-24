import greenfoot.*;

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = Greenfoot.getRandomNumber(10);
        turn(x);
        setLocation(getX(), getY() + 1);
        if (getY() >= getWorld().getHeight() - 20) {
            getWorld().removeObject(this);
        }
    }    
}
