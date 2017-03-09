import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elder extends Actor
{
    private HiddenSprite hs;
    private int counter = 10, eyes_counter;
    private static boolean isActive = false;
    private static int count_enter = 0;
    private static boolean doneDialogue = false;
    private TextPanel helloText, taskText1, taskText2, taskText3, taskText4, taskText5, taskText6;
    private GreenfootImage knight = getImage();
    private GreenfootImage knight_eyes = new GreenfootImage("knight41.png");
    
    public Elder(){
        doneDialogue = false;
    }

    /**
     * Act - do whatever the Elder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        elderDialogue();
        blink();   
    }
    
    protected void addedToWorld(World w){
    addHiddenSprite();
}
    
    public void blink(){
    if (++eyes_counter == 150){
        eyes_counter = 0;
        setImage(knight);
    }
    else if (eyes_counter == 140){
        setImage(knight_eyes);
    }
}
    
    protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , 40, 10, 5, true);  
        getWorld().addObject(hs, getX(), getY()); 
    }
    
     public void elderDialogue(){
        
        if( hs.getWorld() != null ) {   
            List<Actor> things = hs.getHitBoxIntersections();    
            if( things.size() > 1 ) {      
                int infront = 0;      
                for(int i=0; i < things.size(); i++ ) {       
                    Actor a = things.get(i);        
                    if(a instanceof HiddenSprite)        
                    continue;        
                    if( a instanceof Robot) {  
                        counter--;
                        if (counter<0 && !isActive){
                            helloText = new TextPanel("welcomeMsg");
                            getWorld().addObject(helloText, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            isActive = true;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 0 && counter<0){
                            counter = 20;
                            getWorld().removeObject(helloText);
                            taskText1 = new TextPanel("taskText1");
                            getWorld().addObject(taskText1, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 1;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 1 && counter <0){
                            counter = 30;
                            getWorld().removeObject(taskText1);
                            taskText2 = new TextPanel("taskText2");
                            getWorld().addObject(taskText2, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 2;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 2 && counter <0){
                            counter = 30;
                            getWorld().removeObject(taskText2);
                            taskText3 = new TextPanel("taskText3");
                            getWorld().addObject(taskText3, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 3;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 3 && counter <0){
                            counter = 30;
                            getWorld().removeObject(taskText3);
                            taskText4 = new TextPanel("taskText4");
                            getWorld().addObject(taskText4, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 4;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 4 && counter <0){
                            counter = 30;
                            getWorld().removeObject(taskText4);
                            taskText5 = new TextPanel("taskText5");
                            getWorld().addObject(taskText5, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 5;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 5 && counter <0){
                            counter = 30;
                            getWorld().removeObject(taskText5);
                            taskText6 = new TextPanel("taskText6");
                            getWorld().addObject(taskText6, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 6;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 6 && counter <0){
                            counter = 30;
                            getWorld().removeObject(taskText6);
                            count_enter = 7;
                            doneDialogue = true;
                        }
                    }      
                   }
                }
            }
        }
        
        public boolean getDoneWithDialogue(){
            return doneDialogue;
        }
        
        public void setDialogue(boolean dialogue){
            doneDialogue = dialogue;
            count_enter = 0;
            isActive = false;
        }
    

}
