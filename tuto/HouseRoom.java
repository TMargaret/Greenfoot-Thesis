import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mainHouseRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HouseRoom extends World
{
     

    /**
     * Constructor for objects of class mainHouseRoom.
     * 
     */
    public HouseRoom()
    {
        super(900, 500, 1);
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
        addObject(robot,100, 150);
        addWall();
    }
    
    public void addWall(){
        OuterWall outWall = new OuterWall();
        for (int i = 0; i < getWidth(); i+=outWall.getImage().getWidth()){
            addObject(new OuterWall(), i, outWall.getImage().getHeight()/2);
            addObject(new OuterWall(), i, getHeight() - outWall.getImage().getHeight()/2);
        }
        for (int i = 0; i < getHeight(); i+=outWall.getImage().getHeight()){
            addObject(new OuterWall(), 0, i - outWall.getImage().getHeight()/2 );
            addObject(new OuterWall(), getWidth()+ outWall.getImage().getWidth(), i - outWall.getImage().getHeight()/2 );
        }
    }
    
    

}
