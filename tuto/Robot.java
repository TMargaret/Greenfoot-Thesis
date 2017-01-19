import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends SmoothMover
{
    private Level_1 myworld;
    int counter = 10;
    boolean isActive = false;
    private TextPanel tp;
    //private int dx = 0, dy = 0;
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(5);  
    } 
    
    public void move(int moveAmt){
        // determine direction by keypress checking
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("right")) dx += 1;
        if (Greenfoot.isKeyDown("left")) dx -= 1;
        if (Greenfoot.isKeyDown("down")) dy += 1;
        if (Greenfoot.isKeyDown("up")) dy -= 1;
        
        //check for wall on each step of move in both vertical and horizontal directions
        for (int i = 0; i < moveAmt; i++)
        {
            setLocation(getX() + dx, getY());
            if ((getOneIntersectingObject(Wall.class) != null) || (getOneIntersectingObject(Grass.class) != null)){ 
                setLocation(getX() - dx, getY());
            }
            setLocation(getX(), getY() + dy);
            if ((getOneIntersectingObject(Wall.class) != null) || (getOneIntersectingObject(Grass.class) != null)){
                setLocation(getX(), getY() - dy);
            }
        }
    }
    
    /**
     * Moving around with arrow keys
     */
    // public void checkKeys(){
        // //move left
        // if (Greenfoot.isKeyDown("left")){
            // //setLocation(getX()-3, getY());
            // dx -= 1;
        // }
        // //move right
        // if (Greenfoot.isKeyDown("right")){
            // //setLocation(getX()+3, getY());
            // dx += 1;
        // }
        // //move up but until a specific border
       // if (!canSee(Grass.class) & !canSee(Hut.class) & !canSee(mainHouse.class)){
            // if (Greenfoot.isKeyDown("up")){
               // // setLocation(getX(), getY()-3);
               // dy -= 1;
            // }
        // }
        // //move down
        // if (Greenfoot.isKeyDown("down")){
            // //setLocation(getX(), getY()+3);
            // dy += 1;
        // }
            
        
    // }
    
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
