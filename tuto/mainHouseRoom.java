import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mainHouseRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainHouseRoom extends World
{
    Robot robot;
    int counter = 100;
    boolean isActive = false;
    private TextPanel textPanel;

    /**
     * Constructor for objects of class mainHouseRoom.
     * 
     */
    public mainHouseRoom()
    {
        super(1000, 600, 1);
        prepare();
    }
    
    public void act(){
        exitRoom();
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
        GreenfootImage image = new GreenfootImage(getWidth(), getHeight());
        image.setColor(java.awt.Color.BLACK);
        image.fill();
        setBackground(image);

        addWall();

        robot = new Robot();
        addObject(robot,80, 90);

        Elder elder = new Elder();
        addObject(elder,900,500);

    }
    
    public void addWall(){
        Wall[] wall = new Wall[25];
        Wall[] wall2 = new Wall[25];
        
        for(int j=0; j<wall.length; j++){
            wall[j]=new Wall();
            wall2[j] = new Wall();
            addObject(wall[j],j*wall[j].getImage().getWidth(), wall[j].getImage().getHeight()/2);
            addObject(wall2[j],j*wall2[j].getImage().getWidth(), getHeight() - wall[j].getImage().getHeight()/2);
        }
        
        //builds the vertical paths
        for(int i=0; i<=getHeight(); i+= 40)
        {
            Wall wall_vert = new Wall();
            addObject(wall_vert, getWidth(),i);
        }
        
        //builds the vertical paths
        for(int i=150; i<=getHeight(); i+= 40)
        {
            Wall wall_vert2 = new Wall();
            addObject(wall_vert2, 0 ,i );
        }
        
    }
    
    public void exitRoom(){
        if (robot.isAtEdge()){
            counter--;
            if (!isActive){
                textPanel = new TextPanel("exitRoom");
                addObject(textPanel, getWidth()/2, getHeight()/2);
                isActive = true;
            }
        }
            if (counter < 0){
                removeObject(textPanel);
                Greenfoot.setWorld(new Level_1());
            }      
        }
}
