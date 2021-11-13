import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gabe extends Mover
{   
    //Create the variable specific to Gabe for how strong he is being pulled down
    private int gravity; 

    //Creates variables to make sure the user cannot just bark constantly
    private int reloadDelayCount = 70;
    private int coolDown = 70;
    
    //Creates all the images
    private boolean bark = false;
    private GreenfootImage image1 = new GreenfootImage("dog.png");
    private GreenfootImage image2 = new GreenfootImage("switchfootdog.png");
    private GreenfootImage image1b = new GreenfootImage("dogbark.png");
    private GreenfootImage image2b = new GreenfootImage("switchfootdogbark.png");
    
    public Gabe() //Create a doggo and initialize its image.
    {
        setImage(image1);
    }
    
    /**
     * Act - do whatever the Gabe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeypress();
        if(bark)    //makes the images switch so he looks like he is barking when he barks
        {
            if (getImage()==image1)
                switchImage(image2b, image1b);
            else
                switchImage(image1b, image2b);
            bark = false;
        }
        else    //walk normal if he is not barking
            switchImage(image1, image2);
        spawn();
        spawnJetpacks();
        if (getY() <= 295) //Makes Gabe fall untill he is back on the ground
        {
            gravity = gravity - 2;
            setLocation(getX(), getY() - gravity);
        }   
        if (Greenfoot.isKeyDown("space") && reloadDelayCount >= coolDown)  //makes gabe bark
        {
            Greenfoot.playSound("Dog_Bork.mp3");
            /*
             * Citation for the dog bark
             * https://www.youtube.com/watch?v=iuy-oOJCOoM 
            */
            
            bark = true;
            getWorld().addObject(new Bork(), getX()+47, getY()-27);
            reloadDelayCount=0;
        }
        if (reloadDelayCount <= 70){
            getWorld().showText("Bork cool-down: " + reloadDelayCount, 480, 370);
            if (reloadDelayCount == 70)
                getWorld().showText("Your bork is ready", 480, 370);   
        }   
        reloadDelayCount++;
    } 
    
    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            move(-12);
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            move(12);
        }
        if (!(getY() <= 295) && (Greenfoot.isKeyDown("up")))
        {
            //Gives the player the ability to jump if Gabe is on the ground with up arrow 
            gravity = 25; //This will make the character jump
            setLocation(getX(), getY() - gravity);
        }
    }
}
