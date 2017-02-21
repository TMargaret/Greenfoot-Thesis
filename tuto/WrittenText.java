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
    
    public String taskText(){
        return "Υπάρχουν δύο καλύβες έξω, οι οποίες \nχρειάζονται ανακατασκευή.\n\n"+
        "Για να τις φτιάξεις θα χρειαστείς τις\nεξής πρώτες ύλες:\nΞύλο, Πηλό και Άχυρο.";
    }
    public String taskText2(){
        return "Προκειμένου να λάβεις αυτές τις πρώτες\nύλες, θα πρέπει να τις δημιουργήσεις."
        +"\n\nΗ δημιουργία πρώτων υλών, μοιάζει πολύ\nμε τη δημιουργία αντικειμένων (objects)\nστον"
        +" κόσμο των προγραμματιστών.";
    }
    
    public String taskText3(){
        return "Αρχικά, ας ονομάσουμε τις πρώτες ύλες,\n\"κλάσεις\"."
        +"\n\nΓια παράδειγμα:\nη κλάση Ξύλο,\nη κλάση Πηλός,\nη κλάση Άχυρο.";
    }
    
    public String taskText4(){
        return "Στη συνέχεια, για να δημιουργήσεις\nκάποια πρώτη ύλη, αρκεί να \"καλέσεις\""
        +"\nτην αντίστοιχη κλάση ως εξής:\n\n π.χ\n new Wood();";
    }
    
    public String taskText5(){
        return "new Wood();\n\nΤο \"new\" υποδηλώνει τη δημιουργία του\nνέου αντικειμένου, της κλάσης Wood()."
        +"\nΟι παρενθέσεις συνοδεύουν πάντα μια\nκλάση.\nΤο ερωτηματικό μπαίνει απαραίτητα στο\nτέλος κάθε γραμμής κώδικα!";
    }
    
}
