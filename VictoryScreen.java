import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VictoryScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VictoryScreen extends World
{

    /**
     * Constructor for objects of class VictoryScreen.
     * 
     */
    public VictoryScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        message();
    }
    public void message(){
        /**
          * Show the end-of-game message on screen. If they end with a positive score.
          */
        showText("Time is up - you win!", 240, 25);
        showText("Congratulations, you got to your human!", 240, 45);
        showText("Your final score: " + MyWorld.getScore() + " points", 240, 65);
    }
}
