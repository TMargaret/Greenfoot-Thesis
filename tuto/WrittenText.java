import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WrittenText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WrittenText extends Actor
{
    /**
     * Act - do whatever the WrittenText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WrittenText(){
    }   
    
    public String brokenHut(){
        
        return "Η καλύβα αυτή φαίνεται ετοιμόρροπη.\nΚαλύτερα να τη φτιάξω πριν μπω.";
    }
    
    public String enteringRoom(){
        return "Είσοδος στο σπίτι...";
    }
    
    public String exitRoom(){
        return "Έξοδος...";
    }
    
    public String roomEntranceText(){
        return "Τι περίεργο σπίτι! \nΑ να κι ένας άνθρωπος!\nΑς του μιλήσω, μπορεί να με βοηθήσει.";
    }
    
    public String welcomeMsg(){
        return "Καλώς ήρθες στον πλανήτη μου Objectus!\n\nΕίμαι ο πλανητάρχης Objectis και μπορώ \nνα σε "+
        "βοηθήσω να φύγεις αρκεί να κάνεις \nκάτι για μένα.";
    }
    
}
