import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

//κλάση του τελικού πίνακα ScoreBoard ο οποίος χρησιμοποιείται είτε σε περίπτωση νίκης, είτε ήττας
//author M Kölling
//modifications Trifou Margaret

public class TextPanel extends Actor
{
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 540;
    public static final int HEIGHT = 330;
   // public static final int TOTAL_ANSWERS = 6;
    private String status = null;
    //private int iScore, lives, wrong_answers = 0;

    private GreenfootImage image;

    public TextPanel(String status)
    {
        this.status = status;
        //this.iScore = iScore;
       //wrong_answers = TOTAL_ANSWERS - iScore;
        makeImage("Έφαγες μεγάλη ποσότητα γρήγορου φαγητού\n και έχασες...");
    }
    
    private void makeText(){
        
    }


    private void makeImage(String title, String prefix, int iScore)
    //δημιουργείται η εικόνα του ScoreBoard
    {
        image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0,255,200, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 130, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.YELLOW);
        image.drawString(title, 30, 50);
        image.drawString(prefix + iScore, 60, 150);
        //ανάλογα με την περίπτωση εμφανίζεται το κατάλληλο μήνυμα
       // if ((status == "fail") || (status == "end_quiz")) image.drawString("Πάτα ENTER για να παίξεις ξανά", 60, 250);
       // if (status == "fail2") image.drawString("Πάτα ENTER για να παίξεις ξανά", 60, 250);
       // if (status == "win1") image.drawString("Πάτα ENTER για να επιστρέψεις\n στο μενού", 60, 250);
       // if (status == "win2") image.drawString("Πάτα ENTER για να επιστρέψεις\n στο μενού", 60, 250);
       // if ((status == "end_quiz") || (status == "end_quiz_win")) image.drawString("Λάθος απαντήσεις: " + wrong_answers, 60, 180);
       // if ((status == "end_quiz") || (status == "end_quiz_win")) image.drawString("Πάτα το MENOΥ για έξοδο", 60, 300);
        setImage(image);
        
    }
    
    private void makeImage(String title)
    //δημιουργείται η εικόνα του ScoreBoard
    {
        image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0,255,200, 128));
        image.fillRect(0, 0, image.getWidth(),image.getHeight());
        image.setColor(new Color(200, 130, 120, 128));
        image.fillRect(5, 5, image.getWidth()- 10, image.getHeight()-10);
        Font font = image.getFont();
        font = font.deriveFont(22.0f);
        image.setFont(font);
        image.setColor(Color.YELLOW);
        image.drawString(title, 5, 30);
        //image.drawString(prefix, 60, 150);
        //ανάλογα με την περίπτωση εμφανίζεται το κατάλληλο μήνυμα
        // if (status == "start") image.drawString("Πάτα ENTER", 200, 280);
        // if (status == "start1_1" | status == "start2_1") image.drawString("Πάτα το ΚΑΤΩ ΒΕΛΟΣ", 60, 300);
        // if (status == "start1_2") image.drawString("Πάτα SPACE για να ξεκινήσεις", 60, 300);
        // if (status == "start2") image.drawString("Πάτα ENTER", 200, 280);
        // if (status == "start_quiz") image.drawString("Πάτα ENTER", 200, 280);
        // if (status == "start_quiz2") image.drawString("Πάτα ENTER για να ξεκινήσεις", 60, 280);
        setImage(image);
 
    }

    public void act()
    {
        
    }
}