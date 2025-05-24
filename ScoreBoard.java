import greenfoot.*;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    private static final Color backgroundColor = Color.PINK;
    private static final Color transparent = new Color(255, 255, 255, 0);
    
    public ScoreBoard(ArrayList<Integer> times) {
        List<GreenfootImage> lines = new ArrayList<GreenfootImage>();
        lines.add(new GreenfootImage("游戏结束", 48, Color.WHITE, transparent));
        
        for (int i = 0; i < times.size(); i++) {
            int time = times.get(i);
            String text = "第" + (i + 1) + "名：" + time + "秒";
            lines.add(new GreenfootImage(text, 48, Color.WHITE, transparent));
        }
        
        int width = 0;
        int height = 0;
        
        for (GreenfootImage line : lines) {
            height += line.getHeight();
            if (width < line.getWidth()) {
                width = line.getWidth();
            }
        }
        
        GreenfootImage image = new GreenfootImage(width + 20, height + 20);
        image.setColor(backgroundColor);
        image.fill();
        
        for (int i = 0, y = 10; i < lines.size(); i++) {
            GreenfootImage line = lines.get(i);
            image.drawImage(line, (image.getWidth() - line.getWidth()) / 2, y);
            y += line.getHeight();
        }
        
        setImage(image);
    }
    
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
