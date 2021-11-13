import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

public class Mover extends Actor
{ 
    private int gravity;    //The variable to store how strong gravity is pulling down
    public long lastAdded = System.currentTimeMillis(); //The variable to keep time
    public long lastAdded2 = System.currentTimeMillis(); //The variable to keep time
    
    public void switchImage(GreenfootImage firstImage, GreenfootImage secondImage)
    // Alternate the character's image between image1 and image2.
    // Makes the character look like they are walking.
    {
        if (getImage() == firstImage) 
        {
            setImage(secondImage);
        }
        else
        {
            setImage(firstImage);
        }
    }
    
    public void lookForGabe() //kills Gabe if the cats touch him
    {
        if ( isTouching(Gabe.class) ) 
        {
            removeTouching(Gabe.class);
            Greenfoot.playSound("Dog_Whimper.mp3");
            /*
             * Citation for the dog whimper
             * https://www.youtube.com/watch?v=NI_pkFIow54
            */
            
            getWorld().showText("Your game is hecking over!", 220, 150);
            getWorld().showText("Your final score: " + ((MyWorld)getWorld()).getScore() + " points", 220, 170);
            Greenfoot.stop();
        }
    }
    
    public void fall() //makes the gravity physics for when Gabe jumps
    {
        while (getY() <= 300){
            gravity = gravity - 2; //the longer he falls the faster he will fall
            setLocation(getX(), getY() - gravity);
        }
    }
    
    public void endScreen() //makes the cats disappear if they get to the left of the screen
    {
        if (getX()==0){
            getWorld().removeObject(this);
            return;
        }
    }
    
    public void spawn() //randomly spawns in a normal or laser cat
    {
        long curTime  = System.currentTimeMillis();
        int interval = ((int) Math.random()*5+2)*1000; //random number for when it will spawn
        if (curTime >= lastAdded + interval) //2000ms = 2s
        {
            int cat = Greenfoot.getRandomNumber(3); //decides what land cat to spawn
            if (cat==1){    //spawns a normal cat
                getWorld().addObject(new NormalCat(), 599, 300);
                lastAdded  = curTime;
            }
            else{   //spawns a laser cat
                getWorld().addObject(new LaserCat(), 599, 300);
                getWorld().addObject(new Laser(), 510, 265);
                Greenfoot.playSound("Lazer.mp3");
                /*
                 * Citation for the laser sound
                 * https://www.youtube.com/watch?v=A02KPEetuAM&index=35&list=PL1GZkw2FUKCiZSI636mf54HEr2CtDxvW_
                 */
           
                lastAdded  = curTime;
            }
        }

    }
    
    public void spawnJetpacks() //randomly spawns in a jetpack cat
    {
        long curTime  = System.currentTimeMillis();
        int interval2 = (4+Greenfoot.getRandomNumber(30))*1000; //random number for when it will spawn
        if (curTime >= lastAdded2 + interval2) //2000ms = 2s
        {
            getWorld().addObject(new JetpackCat(), 599, 150);
            lastAdded2  = curTime;
        }
    }
}
