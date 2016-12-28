import greenfoot.*;
import java.awt.Color;

public class Major extends World
{
    PIP pip; // keeps a reference on a PIP object
    PIP pip2; // keeps a reference on another PIP object
    boolean wDown; // tracks the down state of the '1' key (wombat PIP control)
    boolean sDown; // tracks the down state of the '2' key (ship PIP control)
    Actor mouseActor; // holds the actor being dragged
    int mouseOffX, mouseOffY; // holds the offsets of mouse location from center of object being dragged
    
    public Major()
    {
        super(1000, 600, 1);
        // paint background of this world with color green
        GreenfootImage background = getBackground();
        background.setColor(Color.black);
        background.fill();
        // ***********************************   MAIN CODE   ****************************
        // World minor = new WombatWorld(); // create the minor world to be display inside of this world
        // Class[] order = { Wombat.class }; // list the paint order of the minor world here
        // pip = new PIP(minor, order); // create the pip object
        // addObject(pip, 110, 110); // add new PIP object into this world
        // // ******************************************************************************
        // World space = new Space();
        // Class[] order2 = { Ship.class };
        // pip2 = new PIP(space, order2);
        // addObject(pip2, 690, 110);
        HouseRoom houseRoom = new HouseRoom();
        Class[] order = {HouseRoom.class};
        pip = new PIP(houseRoom, order);
        addObject(pip, getWidth()/2, getHeight()/2);
        // *******************************************************************************
        // add instruction text to background of this world
        // GreenfootImage text;
        // text = new GreenfootImage("Use mouse to drag the Picture-in-picture objects", 32, Color.black, new Color(0, 0, 0, 0));
        // background.drawImage(text, 400-text.getWidth()/2, 260);
        // text = new GreenfootImage("Use '1' key to start and stop the wombat world", 32, Color.black, new Color(0, 0, 0, 0));
        // background.drawImage(text, 400-text.getWidth()/2, 300);
        // text = new GreenfootImage("Use '2' key to start and stop the ship world", 32, Color.black, new Color(0, 0, 0, 0));
        // background.drawImage(text, 400-text.getWidth()/2, 340);
        // text = new GreenfootImage("Use 'w', 'a', 's', and 'd' to control wombat", 32, Color.black, new Color(0, 0, 0, 0));
        // background.drawImage(text, 400-text.getWidth()/2, 380);
        // text = new GreenfootImage("Use 'left' and 'right' arrow keys to turn ship", 32, Color.black, new Color(0, 0, 0, 0));
        // background.drawImage(text, 400-text.getWidth()/2, 420);
        // text = new GreenfootImage("Use 'space' key to have the ship fire a shot", 32, Color.black, new Color(0, 0, 0, 0));
        // background.drawImage(text, 400-text.getWidth()/2, 460);
    }
    
    public void act()
    {
        // control running state the wombat PIP objects
        // if (!wDown && Greenfoot.isKeyDown("1"))
        // {
            pip.setActiveState(!pip.getActiveState());
            // wDown = true;
        // }
        // if (wDown && !Greenfoot.isKeyDown("1")) wDown = false;
        // // control running state the ship PIP objects
        // if (!sDown && Greenfoot.isKeyDown("2"))
        // {
            // pip2.setActiveState(!pip2.getActiveState());
            // sDown = true;
        // }
        // if (sDown && !Greenfoot.isKeyDown("2")) sDown = false;
        // // control dragging of PIP objects
        // if (Greenfoot.mousePressed(null) && mouseActor == null)
        // {
            // MouseInfo mouse = Greenfoot.getMouseInfo();
            // if (mouse.getActor() == null || mouse.getActor().getClass() != PIP.class) return;
            // mouseActor = mouse.getActor();
            // mouseOffX = mouseActor.getX()-mouse.getX();
            // mouseOffY = mouseActor.getY()-mouse.getY();
            // removeObject(mouseActor);
            // addObject(mouseActor, mouse.getX()+mouseOffX, mouse.getY()+mouseOffY);
        // }
        // if (mouseActor != null && Greenfoot.mouseDragged(mouseActor))
        // {
            // MouseInfo mouse = Greenfoot.getMouseInfo();
            // mouseActor.setLocation(mouse.getX()+mouseOffX, mouse.getY()+mouseOffY);
        // }
        // if (mouseActor != null && Greenfoot.mouseClicked(mouseActor)) mouseActor = null;
    }
}