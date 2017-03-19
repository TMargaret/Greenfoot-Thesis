import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    int counter = 5, firstMessageFlag = 0;
    boolean isActive = false, hasInteracted = false, isTheDialogueDone = false, enableTextField = false;;
    private TextPanel textPanel, textPanel2;
    private HiddenSprite hs;
    private Elder myElder;
    TextField textField;
    String my_text = "";
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
                        if (counter<0 && !isActive){
                            counter = 30;
                            textPanel = new TextPanel("lockedDoor");
                            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            isActive = true;
                        }
                        // if (Greenfoot.isKeyDown("enter")){
                        // counter = 40;
                        // getWorld().removeObject(textPanel);
                        // firstMessageFlag = 1;
                        // }
                        if (isTheDialogueDone && !enableTextField){
                            counter = 30;
                            isActive = true;
                            enableTextField = true;
                            textField = new TextField(700, 45, Color.white , new Color(192,192,192), "Δημιούργησε ένα αντικείμενο Key και πάτα enter");
                            // String key_obj = Greenfoot.ask("Δημιούργησε ένα αντικείμενο Key");
                            // boolean is_equal = key_obj.equals("new Key();");
                            getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
                        }
                        if (Greenfoot.isKeyDown("enter") && counter<0){
                            my_text = textField.getText();
                            // textField.setText(" ");
                            System.out.println(my_text);
                            System.out.println(my_text.length());

                            if (my_text.contains("new Key();"))

                            // if (firstMessageFlag == 1)
                            {
                                getWorld().removeObject(this);
                                isActive = false;
                                break;
                            }
                            // else {
                                // textPanel2 = new TextPanel("warningForDoor");
                                // getWorld().addObject(textPanel2, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            // }
                        }

                        //try again
                        if (Greenfoot.isKeyDown("1")){
                            counter = 40;
                            getWorld().removeObject(textPanel2);
                            hasInteracted = false;
                        }
                        //talk with elder
                        if (Greenfoot.isKeyDown("2")){
                            getWorld().removeObject(textPanel2);
                            isTheDialogueDone = false;
                            myElder.setActive(false);

                        }
                    }
                }
            }
        }
    }

    public boolean getTextField(){
        return enableTextField;
    }

    public boolean getActive(){
        return isActive;
    }

    public int messageHasAppeared(){
        return firstMessageFlag;
    }

    public void setDoneWithElderDialogue(boolean getDoneWithElderDialogue){
        isTheDialogueDone = getDoneWithElderDialogue;
    }

}