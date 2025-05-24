import greenfoot.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Sky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sky extends World
{
    private int tick;
    public static ArrayList<Integer> timeList = new ArrayList<Integer>();

    /**
     * Constructor for objects of class Sky.
     * 
     */
    public Sky()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        addObject(new Rocket(), 300, 300);
        addObject(new Counter(), 45, 389);
        createStars(100);
        setPaintOrder(Counter.class, Rocket.class);
        tick = 0;
    }
    
    public void started() {
        Counter.startTime = System.nanoTime();
    }
    
    public void stopped() {
        Counter.tempTime = Counter.playTime;
    }
    
    private void createStars(int num) {
        for (int i = 0; i < num; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Stars(), x, y);
        }
    }
    
    public void createRocks(int num) {
        for (int i = 1; i <= num; i++) {
            int x = Greenfoot.getRandomNumber(600);
            addObject(new Rock(), x, 0);
        }
    }
    
    public void updateRank(int n) {
        int time = (int) Counter.playTime;
        
        for (int i = 0; i < timeList.size(); i++) {
            if (time > timeList.get(i)) {
                timeList.add(i, time);
                if (timeList.size() > n) {
                    timeList.remove(n);
                }
                return;
            }
        }
        
        if (timeList.size() < n) {
            timeList.add(time);
        }
    }
    
    public void gameOver() {
        updateRank(3);
        addObject(new ScoreBoard(timeList), getWidth() / 2, getHeight() / 2);
        setPaintOrder(ScoreBoard.class, Counter.class, Rocket.class);
        Greenfoot.stop();
    }
    
    public void act() {
        tick++;
        if (tick == 60) {
            int num = Greenfoot.getRandomNumber((int) Counter.playTime / 5 + 1) + 1;
            createRocks(num);
            tick = 0;
        }
        if (Rocket.isBoom) gameOver();
    }
}
