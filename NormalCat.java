import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NormalCat extends Mover
{
    private int gravity;
    private int timer = 0;
    private GreenfootImage image1 = new GreenfootImage("cat1.png");
    private GreenfootImage image2 = new GreenfootImage("switchfootcat1.png");
    
    public NormalCat()
    {
        setImage(image1);
    }
    
    /**
     * Act - do whatever the normal cat wants to do. This method is called whenever
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
                ((MyWorld)getWorld()).addScore(5);
                setImage(new GreenfootImage("cat1RIP.png"));
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
            
        if(timer == 1){
            getWorld().removeObject(this);
        }
    } 
}
