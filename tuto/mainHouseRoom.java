import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mainHouseRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainHouseRoom extends World
{

    /**
     * Constructor for objects of class mainHouseRoom.
     * 
     */
    public mainHouseRoom()
    {
        super(1000, 600, 1);
        prepare();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void prepare()
    {
        // put your code here
        Robot robot = new Robot();
        addObject(robot,50, 50);
    }

}
