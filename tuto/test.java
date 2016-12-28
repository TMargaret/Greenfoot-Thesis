import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test extends mainHouseRoom
{
    private int yPos = getHeight();
    private int xPos = getWidth();
    OuterWall tileSize = new OuterWall();
    private int WidthOffset = 20; 
    private int HeightOffset = 20;

    /**
     * Constructor for objects of class test.
     * 
     */
    public test()
    {
        
        buildWallFrame();
    }
    
    
    private void buildWallFrame(){
        int sizeX = tileSize.getImage().getWidth();

        for (int i=WidthOffset; i < xPos; i+= sizeX)
        {
            addObject(new OuterWall(), i, HeightOffset);
        }
    }
}
