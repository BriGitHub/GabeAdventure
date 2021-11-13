import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Citation of the image used fot MyWorld
 * http://aaees.net/room-red/ (Custom Room Red Red Walls Room Interior)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     */
    public int time;    //the amount of time to last to get to the end of the hallway
    private static int score;  //the player's score
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Greenfoot.playSound("Gabe_Song.mp3");
        /*
         * Citation for the background song
         * https://www.youtube.com/watch?v=c--etqIJcow
         */
        score = 0;
        time = 0;
        showScore();
        showTime();
        addObject(new Gabe(), 128, 300); //Sets up Gabe so the player can start imediatly
    }
    public void act()
    {
        countTime();    
    }
    /**
     * Add some points to our current score. (May be negative.)
     * If the score falls below 0, you can still get to the end of the game but you won't "win".
     */
    public void addScore(int points)
    {
        score = score + points;
        showScore();
    }
    
    public static int getScore ()
    {
        return score;
    }
    
    /**
     * Show our current score on screen.
     */
    private void showScore() 
    {
        showText("Score: " + score, 80, 45);    
    }

    /**
     * Count down the game time and display it. Stop the game 
     * with a winning message when time is up.
     */
    private void countTime()
    {
        time++;
        showTime();
        if (time == TitleScreen.getTime())
        {
            if (getScore()>0)
            {
                Greenfoot.setWorld(new VictoryScreen());
                Greenfoot.stop();
            }
            else
            {
                showText("Get hecking good kid!", 220, 150);
                showText("Your final score: " + getScore() + " points", 220, 170);
                Greenfoot.stop();
            }
        }
    }

    /**
     * Show the remaining game time on screen.
     */
    private void showTime()
    {
        showText("Time: " + time, 80, 25);
    }
}

