import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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

        Place place = new Place();
        addObject(place,129,287);

        Place place2 = new Place();
        addObject(place2,883,280);

        Place2 place22 = new Place2();
        addObject(place22,506,303);

        Robot robot = new Robot();
        addObject(robot,79,525);
        
        Road road = new Road();
        addObject(road,129,392);
 
    }
    
    public void addRoad(){
    }
     
    
    public void addGrass(){
        Grass grass = new Grass();
        addObject(grass,665,260);
        Grass grass2 = new Grass();
        addObject(grass2,705,266);
        Grass grass3 = new Grass();
        addObject(grass3,745,264);
        Grass grass4 = new Grass();
        addObject(grass4,630,263);
        Grass grass5 = new Grass();
        addObject(grass5,602,267);
        Grass grass6 = new Grass();
        addObject(grass6,401,272);
        Grass grass7 = new Grass();
        addObject(grass7,370,270);
        Grass grass8 = new Grass();
        addObject(grass8,353,258);
        Grass grass9 = new Grass();
        addObject(grass9,337,277);
        Grass grass10 = new Grass();
        addObject(grass10,321,266);
        Grass grass11 = new Grass();
        addObject(grass11,313,280);
        Grass grass12 = new Grass();
        addObject(grass12,299,274);
        Grass grass13 = new Grass();
        addObject(grass13,292,263);
        Grass grass14 = new Grass();
        addObject(grass14,275,277);
        Grass grass15 = new Grass();
        addObject(grass15,260,287);
        Grass grass16 = new Grass();
        addObject(grass16,252,281);
        Grass grass17 = new Grass();
        addObject(grass17,252,256);
        Grass grass18 = new Grass();
        addObject(grass18,246,280);
        Grass grass19 = new Grass();
        addObject(grass19,243,296);
        Grass grass20 = new Grass();
        addObject(grass20,22,274);
        grass19.setLocation(4,269);
        grass20.setLocation(9,319);
        grass19.setLocation(28,321);
        grass18.setLocation(242,319);
        grass16.setLocation(270,321);
        grass15.setLocation(300,319);
        grass14.setLocation(324,317);
        grass15.setLocation(300,319);
        grass14.setLocation(324,321);
        grass17.setLocation(346,320);
        grass13.setLocation(372,320);
        grass12.setLocation(769,325);
        grass6.setLocation(736,325);
        grass8.setLocation(698,325);
        grass11.setLocation(663,330);
        grass8.setLocation(701,326);
        grass11.setLocation(665,327);
        grass9.setLocation(632,329);
        grass7.setLocation(352,265);
        grass2.setLocation(988,321);
        grass5.setLocation(989,336);
        grass2.setLocation(990,302);
        grass5.setLocation(988,320);
        grass3.setLocation(987,263);
        grass2.setLocation(990,289);
        grass3.setLocation(987,272);
        grass2.setLocation(991,325);
        grass3.setLocation(987,287);
        grass5.setLocation(988,299);
        grass2.setLocation(989,341);
        grass2.setLocation(989,321);
        grass5.setLocation(983,361);
        grass2.setLocation(989,304);
        grass3.setLocation(985,328);
        grass2.setLocation(988,295);
        grass3.setLocation(989,305);
        grass5.setLocation(990,321);
        grass4.setLocation(616,328);
        grass.setLocation(620,319);
        grass7.setLocation(385,321);
        grass10.setLocation(348,312);
        grass11.setLocation(667,331);
        grass9.setLocation(655,311);
        grass11.setLocation(655,317);
        grass8.setLocation(693,313);
        grass6.setLocation(727,314);
        grass12.setLocation(765,317);
        Grass grass21 = new Grass();
        addObject(grass21,664,336);
        Grass grass22 = new Grass();
        addObject(grass22,706,335);
        Grass grass23 = new Grass();
        addObject(grass23,756,339);
        grass21.setLocation(658,327);
        grass22.setLocation(700,326);
        grass23.setLocation(751,329);
        grass22.setLocation(700,327);
        grass23.setLocation(738,324);
        Grass grass24 = new Grass();
        addObject(grass24,782,336);
        grass24.setLocation(777,326);
        
        Grass grass25 = new Grass();
        addObject(grass25,22,336);
        
        Grass grass26 = new Grass();
        addObject(grass26,241,335);
        
        Grass grass27 = new Grass();
        addObject(grass27,276,334);
        
        Grass grass28 = new Grass();
        addObject(grass28,309,333);
        
        Grass grass29 = new Grass();
        addObject(grass29,345,333);
        
        Grass grass30 = new Grass();
        addObject(grass30,381,336);
        grass5.setLocation(979,322);
        
        Grass grass31 = new Grass();
        addObject(grass31,998,330);
        
        Grass grass32 = new Grass();
        addObject(grass32,674,333);
        
        Grass grass33 = new Grass();
        addObject(grass33,412,336);
        
    }
}
