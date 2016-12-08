import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends SmoothMover
{
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
       
    }  
    
    public void checkKeys(){
        
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+3, getY());
        }
        if (!canSee(Grass.class)){
            if (Greenfoot.isKeyDown("up")){
                setLocation(getX(), getY()-3);
            }
        }
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
}
