import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LaserCat extends Mover
{
    private int gravity;
    private int timer = 0;
    private GreenfootImage image1 = new GreenfootImage("cat2.png");
    private GreenfootImage image2 = new GreenfootImage("switchfootcat2.png");
    
    public LaserCat()
    {
        setImage(image1);
    }
    
    /**
     * Act - do whatever the laser cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer == 0)
        {
            move(-8);
            fall();
            switchImage(image1, image2);
            lookForGabe();
            if ( isTouching(Bork.class) ) 
            {
                ((MyWorld)getWorld()).addScore(10);
                setImage(new GreenfootImage("cat2RIP.png"));
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
