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
    int counter = 10, count_enter = 0, eyes_counter1 = 50, eyes_counter2 = 100;
    boolean isActive = false;
    private TextPanel helloText, taskText, taskText2, taskText3, taskText4, taskText5;
    private GreenfootImage knight = getImage();
    private GreenfootImage knight_eyes = new GreenfootImage("knight44.png");
    private long timeStarted = System.currentTimeMillis();
    /**
     * Act - do whatever the Elder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addHiddenSprite();
        elderDialog();
        //blink();
        
        
    }
    
    public void blink(){
        eyes_counter1--;
        eyes_counter2--;
        if (eyes_counter1 <0){
            setImage(knight_eyes);
            
        }
        if (eyes_counter2 <0){
            setImage(knight);
            eyes_counter1 = 500;
            eyes_counter2 = 1000;
        }
        //System.out.println(timeStarted);
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - timeStarted;
        //System.out.println(currentTime);

        // if (elapsedTime / 1000 > 2 && elapsedTime / 1000 < 4 )
        // {
           // //timeStarted = currentTime;
            // setImage(knight_eyes);
        // }
        // if(elapsedTime / 1000 > 4){
            // setImage(knight);
            // elapsedTime = 0;
            // timeStarted = 0;
        // }
    }
    
        protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , 40, 10, 5, true);  
        getWorld().addObject(hs, getX(), getY()); 
    }
    
     public void elderDialog(){
        
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
                            taskText = new TextPanel("taskText");
                            getWorld().addObject(taskText, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 1;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 1 && counter <0){
                            counter = 30;
                            getWorld().removeObject(taskText);
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
                    }      
                   }
                }
            }
        }
    

}
