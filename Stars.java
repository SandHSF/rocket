import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Stars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stars extends Actor
{
    public Stars() {
        GreenfootImage star = new GreenfootImage(4, 4);
        star.setColor(Color.WHITE);
        star.fillOval(1, 1, 4, 4);
        setImage(star);
    }
    
    /**
     * Act - do whatever the Stars wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + 1);
        if (getY() >= 395) {
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(x, 0);
        }
    }    
}
