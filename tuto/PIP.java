import greenfoot.*;
import java.awt.Color;

/**
 *       An actor object that captures the current visual state of a world object.  A world object is passed to this object in the constructor call.
 * <br />
 * <br />That world (usually not the world that this actor is placed into) can be controlled through the methods of this class.  
 * <l>
 *      <li>For 'Run' and 'Pause', use the 'run' and 'pause' methods (or the 'setActiveState' method) on the PIP object.</li>
 *      <li>For 'Step', use the 'step' method on the PIP object.</li>
 * </l>
 * 
 * <h3>NOTE: DO NOT MODIFY THIS CLASS</h3>
 * 
 *       AUTHOR: danpost
 * <br />DATE: February 10, 2014
 */
public class PIP extends Actor
{
    private World minor; // the world to display in the image of this PIP object
    private Class[] paintOrder; // the paint order of the world to display
    private boolean activeState; // the current active state of this actor which runs the world that is displayed
    Sensor sensor = new Sensor(); // to detect all objects in minor world window (Sensor is an inner class of this class -- see at bottom)
    int minorWidth, minorHeight, minorCellSize; // values often used made more easily accessable

    /**
     *       creates the picture-in-picture object
     *
     * @param minorWorld the world object to portray
     * @param classes the paint order of the world to portray
     */
    public PIP(World minorWorld, Class[] classes)
    {
        // save arguments to instance fields
        minor = minorWorld;
        paintOrder = classes;
        // save minor world dimensions
        minorCellSize = minor.getCellSize();
        minorWidth = minor.getWidth()*minorCellSize;
        minorHeight = minor.getHeight()*minorCellSize;
        // set image of sensor
        sensor.setImage(new GreenfootImage(minorWidth+minorCellSize*2, minorHeight*minorCellSize*2));
        // create the base image of the PIP object
        GreenfootImage image = new GreenfootImage(minorWidth+11, minorHeight+11);
        // paint the background of the base image white
        image.setColor(Color.white);
        image.fill();
        // create the picture frame
        image.setColor(Color.black);
        image.drawRect(0, 0, minorWidth+10, minorHeight+10);
        image.drawRect(1, 1, minorWidth+8, minorHeight+8);
        image.drawRect(4, 4, minorWidth+2, minorHeight+2);
        // set the base image as the current image of this PIP object
        setImage(image);
        // update the picture of this PIP object (display the given world)
        updateImage();
    }
    
    /**
     *       controls the running state of the displayed world
     */
    public void act()
    {
        if (!activeState) return;
        for (Object obj : minor.getObjects(null))
        {
            Actor actor = (Actor)obj;
            if (actor.getWorld() != null) actor.act();
        }
        minor.act();
        updateImage();
    }        

    /**
     *       updates the picture of the given world within the image of this PIP object
     */
    private void updateImage()
    {
        GreenfootImage view = new GreenfootImage(minor.getBackground());
        for (Object obj : sensor.getIntersectors(null))
        {
            Actor actor = (Actor)obj;
            if(!isPaintOrderActor(actor))
            {
                int x = actor.getX()*minorCellSize+minorCellSize/2;
                int y = actor.getY()*minorCellSize+minorCellSize/2;
                GreenfootImage img = getActorImage(actor);
                view.drawImage(img, x-img.getWidth()/2, y-img.getHeight()/2);
            }
        }
        for(int i=1; i<=paintOrder.length; i++) for(Object obj: sensor.getIntersectors(paintOrder[paintOrder.length-i]))
        {
            Actor actor = (Actor)obj;
            int x = actor.getX()*minorCellSize+minorCellSize/2;
            int y = actor.getY()*minorCellSize+minorCellSize/2;
            GreenfootImage img = getActorImage(actor);
            view.drawImage(img, x-img.getWidth()/2, y-img.getHeight()/2);
        }
        getImage().drawImage(view, 5, 5);
    }
    
    /**
     *       returns the image of an actor within the displayed world
     *
     * @param actor the actor whose image is to be placed within the displayed world
     * @return a GreenfootImage object showing the current visual state of an actor
     */
    private GreenfootImage getActorImage(Actor actor)
    {
        GreenfootImage actorImg = actor.getImage();
        int w = actorImg.getWidth();
        int h = actorImg.getHeight();
        int max = Math.max(w, h);
        GreenfootImage image = new GreenfootImage(max*2, max*2);
        image.drawImage(actorImg, max-actorImg.getWidth()/2, max-actorImg.getHeight()/2);
        image.rotate(actor.getRotation());
        return image;
    }
        
    /**
     *       determines whether an actor is an instance of a class contained in the paint order of the displayed world
     *
     * @param actor an actor from within the world that is displayed
     * @return the state of the class of a given actor being contained within the paint order array
     */
    private boolean isPaintOrderActor(Actor actor)
    {
        for(int i=0; i<paintOrder.length; i++) if(actor.getClass().equals(paintOrder[i])) return true;
        return false;
    }

    /**
     *       sets the active state of this PIP object; use this as an alternative to using the 'run' and 'pause' methods
     *
     * @param newActiveState the active state to set this PIP object to
     */
    public void setActiveState(boolean newActiveState)
    {
        activeState = newActiveState;
    }
    
    /**
     *       gets the current active state of this PIP object
     *
     * @return the current active state of this PIP object
     */
    public boolean getActiveState()
    {
        return activeState;
    }
    
    /**
     *       activates this PIP object, setting the displayed world into a running state
     */
    public void run()
    {
        setActiveState(true);
    }
    
    /**
     *       pauses this PIP object, setting the displayed world into a stopped state
     */
    public void pause()
    {
        setActiveState(false);
    }
    
    /**
     *       executes one cycle of the displayed world
     */
    public void step()
    {
        if (activeState) return;
        activeState = true;
        act();
        activeState = false;
    }
    
    /**
     * Sensor class (Object>Actor>PIP$Sensor): an object used to cover the window of the minor world of this PIP object to
     * facilitate getting actors in the viewable area.  This effectively diminishes the amount of lag on unbounded worlds.
     */
    private class Sensor extends Actor
    {
        /**
         *       called by the PIP object when updating its displayed image to get a list of all actors in the viewable
         *       window of its minor world
         *       
         *       NOTE: the image of the sensor is created by the PIP object after creating the sensor.
         *
         * @param cls the class of objects to look for (use 'null' to list all viewable objects)
         * @return the list of objects of the specified class (or all classes if specified as 'null') in the viewable
         *         area of the minor world
         */
        public java.util.List getIntersectors(Class cls)
        {
            minor.addObject(this, minor.getWidth()/2, minor.getHeight()/2); // adds sensor into minor world
            java.util.List objects = getIntersectingObjects(cls); // gets list of objects
            minor.removeObject(this); // removes sensor from minor world
            return objects; // returns list of objects
        }
    }
}