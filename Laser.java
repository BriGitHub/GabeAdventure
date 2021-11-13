import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Citation for the laser image 
 * 
 * http://commando2.wikia.com/wiki/File:Glenos-G_160_bullet.png
 */
public class Laser extends Mover
{
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-10);
        if ( isTouching(Gabe.class) ) 
            ((MyWorld)getWorld()).addScore(-1);
        endScreen();
    }    
}
