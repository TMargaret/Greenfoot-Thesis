import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    int counter = 5, firstMessageFlag = 0;
    boolean isActive = false, hasInteracted = false;
    private TextPanel textPanel, textPanel2;
    private HiddenSprite hs;
    private Elder myElder = new Elder();
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!isActive && hasInteracted){
            hasInteracted = false;
        }
        if (myElder.getDoneWithDialogue()){
            isActive = true;
            firstMessageFlag = 1;
        }
        canSeeRobot();
    } 

    protected void addedToWorld(World w)
    {
        addHiddenSprite();
    }

    protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , 50, 0, 0, true);  
        getWorld().addObject(hs, getX(), getY()); 
    }

    public void canSeeRobot(){
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
                        if (counter<0 && !isActive && !hasInteracted){
                            textPanel = new TextPanel("lockedDoor");
                            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            isActive = true;
                        }
                        if (Greenfoot.isKeyDown("enter")){
                            counter = 40;
                            getWorld().removeObject(textPanel);
                            firstMessageFlag = 1;
                        }
                        if ((firstMessageFlag == 1)){
                            if (myElder.getDoneWithDialogue() && !hasInteracted){
                                
                                hasInteracted = true;
                                String key_obj = Greenfoot.ask("Δημιούργησε ένα αντικείμενο Key");
                                boolean is_equal = key_obj.equals("new Key();");

                                if (is_equal)
                                {
                                    getWorld().removeObject(this);
                                    isActive = false;
                                    break;
                                }else {
                                    textPanel2 = new TextPanel("warningForDoor");
                                    getWorld().addObject(textPanel2, getWorld().getWidth()/2, getWorld().getHeight()/2);
                                }
                            }
                            if (Greenfoot.isKeyDown("1")){
                                System.out.println("yes");
                                getWorld().removeObject(textPanel2);
                                hasInteracted = false;
                            }
                            if (Greenfoot.isKeyDown("2")){
                                getWorld().removeObject(textPanel2);
                                myElder.setDialogue(false);

                            }
                        }
                    }
                }
            }
        }
    }

}