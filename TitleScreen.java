import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    private static int amountTime;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Greenfoot.start();
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("1")){
            amountTime = 2050; //Easy Mode (half of normal's time)
            Greenfoot.setWorld(new MyWorld());
        }
        else if (Greenfoot.isKeyDown("2")){
            amountTime = 4100; //Normal Mode (half of hard's time)
            Greenfoot.setWorld(new MyWorld());
        }
        else if (Greenfoot.isKeyDown("3")){
            amountTime = 8200; //Hard Mode (the whole song)
            Greenfoot.setWorld(new MyWorld());
        }
    }
    
    public static int getTime() //Gives the world the amount of time for each difficulty
    {
        return amountTime;
    }
}
