import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bork extends Mover
{ 
    /**
     * Act - do whatever the Bork wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(12);
        if (getX()==599) //Gets rid of the bark if it goes to the right end of the screen
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
