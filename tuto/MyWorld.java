import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addGrass();
        addRoad();

        Place place = new Place();
        addObject(place,129,287);

        Place place2 = new Place();
        addObject(place2,883,280);

        mainHouse my_mainHouse = new mainHouse();
        addObject(my_mainHouse,506,303);

        Robot robot = new Robot();
        addObject(robot,79,525);

     
    }
    
    /**
     * Adds the walkable paths
     */
    public void addRoad(){
        //creates a new array that holds the road actor
        Road[] roadArray=new Road[25];
        Road[] roadArray2=new Road[25];
        
        //iteration in order to build a horizontal path
        for(int j=0;j<roadArray.length;j++){
            roadArray[j]=new Road();
            roadArray2[j]=new Road();
            addObject(roadArray[j],j*roadArray[j].getImage().getWidth(),getHeight()- roadArray[j].getImage().getHeight()/2);
            addObject(roadArray2[j],j*roadArray[j].getImage().getWidth(),getHeight()- roadArray[j].getImage().getHeight());
        }
              
    }
     
    
    public void addGrass(){
        //creates a new array that holds the grass actor
        Grass[] grass =new Grass[25];
        Grass[] grass2 =new Grass[25];
        
        //iteration in order to build a horizontal path
        for(int j=0;j<grass.length;j++){
            grass[j]=new Grass();
            grass2[j]=new Grass();
            addObject(grass[j],j*grass[j].getImage().getWidth(),getHeight()/2);
            addObject(grass2[j],j*grass[j].getImage().getWidth(),getHeight()/2 + grass[j].getImage().getHeight()/2);
            
            
        }
    }
}
