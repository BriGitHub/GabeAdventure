import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class JetpackCat extends Mover
{
    /**
     * Act - do whatever the jetpack cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timer = 0;
    
    public void act() 
    {
        if(timer == 0)
        {
            move(-8);
            lookForGabe();
            if ( isTouching(Bork.class) ) 
            {
                ((MyWorld)getWorld()).addScore(15);
                setImage(new GreenfootImage("cat3RIP.png"));
                Greenfoot.playSound("Cat_Meow.mp3");
                /*
                 * Citation for the cat meow
                 * https://www.youtube.com/watch?v=rdYE3Wm6jX8 
                 */
                
                timer = 10;
            }
            else
                endScreen();
        }
        else
            timer--;
            
        if(timer == 1)
            getWorld().removeObject(this);
    }
    
}
