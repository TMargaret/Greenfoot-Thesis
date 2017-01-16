import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elder extends Actor
{
    /**
     * Act - do whatever the Elder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        createDialog();
    }    
    
    public void createDialog(){
        Label text = new Label("Hello", 5);
    }
}
