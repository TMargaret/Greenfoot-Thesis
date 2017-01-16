import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends SmoothMover
{
    private MyWorld myworld;
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        enterRoom();
       
    }  
    
    /**
     * Moving around with arrow keys
     */
    public void checkKeys(){
        //move left
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-3, getY());
        }
        //move right
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+3, getY());
        }
        //move up but until a specific border
        if (!canSee(Grass.class) & !canSee(Hut.class) & !canSee(mainHouse.class)){
            if (Greenfoot.isKeyDown("up")){
                setLocation(getX(), getY()-3);
            }
        }
        //move down
        if (Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+3);
        }
    }
    
    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
    /**
     * This collision detects if robot can enter the mainHouse room 
     * 
     */
    public void enterRoom()
    {
        if (canSee(mainHouse.class))
        {
            Greenfoot.setWorld(new mainHouseRoom());
        }
    }
    
    public void canSeeRobot(){
        if (canSee(Robot.class))
        {
            TextPanel tp = new TextPanel("BrokenHutMessage");
            myworld.addObject(tp, 40, 40);
        }
    }
    

    
    
    
}
