import greenfoot.*;
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    public static long startTime;
    public static long tempTime;
    public static long playTime;
    
    public Counter() {
        startTime = 0;
        playTime = 0;
        tempTime = 0;
        showTime(0);
    }
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        countTime();
        showTime(playTime);
    }    
    
    public void countTime() {
        long thisTime = System.nanoTime();
        playTime = tempTime + (thisTime - startTime) / 1000000000L;
    }
    
    public void showTime(long time) {
        GreenfootImage im = new GreenfootImage(100, 30);
        Font font = new Font("Arial", Font.BOLD, 20);
        im.setFont(font);
        im.setColor(Color.RED);
        im.drawString("Time: " + time, 10, 20);
        setImage(im);
    }
}
