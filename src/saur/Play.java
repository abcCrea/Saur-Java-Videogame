// <abc Crea 2020> - <Oscar Eduardo Ochoa Velasco>

package saur;

import Typography.Fonts;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;


public class Play extends javax.swing.JFrame 
{
   //Menu variable
   boolean Menu = true;
   
   //Window dimensions
   int X = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
   int Y = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    //Arrow coordinates for do the Animations
   int yB2, yA1;
   
   //Player coordinates for move the Character
   int xp1, yp1;
   
   //Sound
   AudioClip getcherry;
   AudioClip death;
   AudioClip select;
   
   //Logo
   ImageIcon Logo = new ImageIcon(getClass().getResource("/Imagens/abc_Crea.png"));    
   
   //Sprites   
   //Character
   ImageIcon Saur_Left1 = new ImageIcon(getClass().getResource("/Imagens/Saur_L1.png"));     
   ImageIcon Saur_Left2 = new ImageIcon(getClass().getResource("/Imagens/Saur_L2.png"));
   ImageIcon Saur_Right1 = new ImageIcon(getClass().getResource("/Imagens/Saur_R1.png"));
   ImageIcon Saur_Right2 = new ImageIcon(getClass().getResource("/Imagens/Saur_R2.png"));
   
   //Enemies
   ImageIcon Cherry = new ImageIcon(getClass().getResource("/Imagens/Cherry.png"));     
   ImageIcon Ice = new ImageIcon(getClass().getResource("/Imagens/Ice.png"));     
  
   //Enemies coordinates
   int yE1, yE2, yE3, yE4;     
   
   //Timer variable
   //If you want a faster displacement of the enemies decrease this variable only on *BEGIN Function*
   int tempo = 170;
   
   //Random variable
   int RandomNumber;
   
   //Typography variable
   Fonts font;
   
   //Score variable
   int Score = 0;
   
    //Pause variable    
    int PauseMode = 0;
    
    //Background color variable
    int EachFive = 0;
    int ChangeColor = 0;
    
    //Speed variable
    boolean Speed = true;
    boolean NoMove = false;
    
    //Record variable
    int Record;
   
   //Enemy timer falling
   boolean DeathVar = false;
   Timer Fall = new Timer(tempo, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {       
      yE1= E1.getY();
      yE2= E2.getY();
      yE3= E3.getY();
      yE4= E4.getY();     
      if(DeathVar == true)
      {
          yE1 = -(Y/4); 
          yE2 = -(Y/4); 
          yE3 = -(Y/4); 
          yE4 = -(Y/4);
          E1.setVisible(true);
          E2.setVisible(true);
          E3.setVisible(true);
          E4.setVisible(true);        
          Random();
          DeathVar = false;
          Collisions.start();
          Score1.setVisible(false);     
      }    
      E1.setLocation((X / 2) - (Y / 2), yE1 + (Y / 12));
      E2.setLocation((X / 2) - (Y / 4), yE2 + (Y / 12));
      E3.setLocation((X / 2), yE3 + (Y / 12));
      E4.setLocation((X / 2) + (Y / 4), yE4 + (Y / 12));
    }
    });
   
  //Collisions timer
   Timer Collisions = new Timer(100, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {       
      xp1 = P1.getX();
      yE1 = E1.getY();
      yE2 = E2.getY();
      yE3 = E3.getY();
      yE4 = E4.getY();      
      switch(RandomNumber)
      {
       case 1:
       if(yE1 > (Y/2) && xp1 == (X / 2) - (Y / 2))            
        {
            Hide();
            ChangeVar = 1;           
            Change.start();               
            ScorePlus();            
            DeathVar = true;
            Collisions.stop();
        } 
       else if(yE1 > (Y/2) && xp1 != (X / 2) - (Y / 2))
       {      
           yE1 = -(Y/4); 
           yE2 = -(Y/4); 
           yE3 = -(Y/4); 
           yE4 = -(Y/4);
           Hide();
           Fall.stop();
           Collisions.stop();
           Death.start();
       }
       break;
       case 2:
       if(yE2 > (Y/2) && xp1 == (X / 2) - (Y / 4))            
        {
            Hide();
            ChangeVar = 1;           
            Change.start();              
            ScorePlus();
            DeathVar = true;
            Collisions.stop();
        }  
       else if(yE3 > (Y/2) && xp1 != (X / 2))  
       {
           yE1 = -(Y/4); 
           yE2 = -(Y/4); 
           yE3 = -(Y/4); 
           yE4 = -(Y/4);
           Hide();
           Fall.stop();
           Collisions.stop();
           Death.start();
       }
       break;
       case 3:
       if(yE3 > (Y/2) && xp1 == (X / 2))            
        {
            Hide();
            ChangeVar = 1;           
            Change.start();              
            ScorePlus();
            DeathVar = true;
            Collisions.stop();
        }  
       else if(yE3 > (Y/2) && xp1 != (X / 2))
       {
           yE1 = -(Y/4); 
           yE2 = -(Y/4); 
           yE3 = -(Y/4); 
           yE4 = -(Y/4);
           Hide();
           Fall.stop();
           Collisions.stop();
           Death.start();
       }
       break;
       case 4:
       if(yE4 > (Y/2) && xp1 == (X / 2) + (Y / 4))            
        {
            Hide();
            ChangeVar = 1;            
            Change.start();              
            ScorePlus();
            DeathVar = true;
            Collisions.stop();
        }
       else if(yE4 > (Y/2) && xp1 != (X / 2) + (Y / 4))  
       {
           yE1 = -(Y/4); 
           yE2 = -(Y/4); 
           yE3 = -(Y/4); 
           yE4 = -(Y/4);
           Hide();
           Fall.stop();
           Collisions.stop();
           Death.start();
       }
       break;
      }          
    }
    });
    
   
   
    //Location variable
    int P1side = 2;
    int ChangeVar;
    //Change timer 
   Timer Change = new Timer(100, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {       
     switch(P1side)
     {
         case 1:
             if(ChangeVar <= 2)
             {
                ImageIcon Saur_L1 = new ImageIcon(Saur_Left1.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));
                P1.setIcon(Saur_L1);
             }
             else
             {
                ImageIcon Saur_L2 = new ImageIcon(Saur_Left2.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));
                P1.setIcon(Saur_L2);    
                Change.stop();
             }
         break;
         
         case 2: 
             if(ChangeVar <= 2)
             {
                ImageIcon Saur_R1 = new ImageIcon(Saur_Right1.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));                                 
                P1.setIcon(Saur_R1);
             }
             else
             {
                ImageIcon Saur_R2 = new ImageIcon(Saur_Right2.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));
                P1.setIcon(Saur_R2);    
                Change.stop();
             }
         break;
     }
     ChangeVar ++;
    }
    });
   
   //Death timer
   int DeathChange = 1;
   Timer Death = new Timer(200, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {   
     death.play();
     switch(DeathChange)
     {
         case 1:
             P1.setVisible(false);
             DeathChange = 2;
         break;
         
         case 2: 
             P1.setVisible(true);
             DeathChange = 1;
         break;
     }  
     NoMove = true;
     xp1 = P1.getX();
     yp1 = P1.getY();
     P1.setLocation(xp1, yp1 + (Y / 32));
     if(yp1 >= Y)
     {
        Death.stop();
        Score1.setVisible(false);
        GameOver.setVisible(true);
        Pause.setFont(font.Fonts(font.g1,0,Y/12));
        Pause.setText("TRY AGAIN");
        Pause.setVisible(true);        
        S1.setVisible(true);
        S2.setVisible(true);        
        Yes.setVisible(true);
        No.setVisible(true);
        Record1.setVisible(true);
        Record2.setVisible(true);
        P1side = 1;        
      if(Score > Record)
      {
         try 
        {
            CreateXML();
        }
         catch (ParserConfigurationException ex) 
        {
         Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        } 
         catch (TransformerException ex) 
        {
         Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
      }     
     }
    }
    });
      

   //New Record timer
   int newrecord = 1;
   Timer NewRecord = new Timer(200, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {      
     Record1.setText("NEW RECORD");
     switch(newrecord)
     {
         case 1:
             Record1.setVisible(false);
             newrecord = 2;
         break;
         
         case 2: 
             Record1.setVisible(true);
             newrecord = 1;
         break;
     }      
    }
    });
   
    //Press timer
   int press = 1;
   Timer PRESS = new Timer(250, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {         
     switch(press)
     {
         case 1:
             Sub.setVisible(false);             
             press = 2;
         break;
         
         case 2: 
             Sub.setVisible(true);             
             press = 1;
         break;
     }      
    }
    });
   
   //Up timer
   int up = 1;
   int idle = 1;
   Timer Up = new Timer(50, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {      
     yA1 = P2.getY();
     if(yA1 > Y - Y/3 && idle == 1)
     {
     P2.setLocation((X / 2) - (Y / 8), yA1 - (Y / 48));
     }
     else
     {
         if(idle <= 20)
         {
        ImageIcon Saur_R1 = new ImageIcon(Saur_Right1.getImage().getScaledInstance(P2.getWidth(), P2.getHeight(), Image.SCALE_DEFAULT));
        P2.setIcon(Saur_R1);
         }
         else if(idle > 20 && idle < 40)
         {
        ImageIcon Saur_R2 = new ImageIcon(Saur_Right2.getImage().getScaledInstance(P2.getWidth(), P2.getHeight(), Image.SCALE_DEFAULT));
        P2.setIcon(Saur_R2); 
         }
         else if(idle > 40)
         {
            if(yA1 < Y)
            {
             P2.setLocation((X / 2) - (Y / 8), yA1 + (Y / 48));             
            }                      
         }
         idle ++;
     }
    }
    });
   
   
     //Background timer - Change the Background Color
    int Colore = 0;
    Timer Curtain = new Timer(50, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {         
      yB2 = B2.getY();
      switch(Colore)
      {
          case 1:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(124,55,206));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(124,55,206));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;
          case 2:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(164,55,206));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(164,55,206));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;
          case 3:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(206,55,188));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(206,55,188));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;
          case 4:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(206,55,55));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(206,55,55));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;
          case 5:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(206,115,55));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(206,115,55));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;
          case 6:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(197,206,55));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(197,206,55));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;
          case 7:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(124,206,55));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(124,206,55));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;
          case 8:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(15,144,24));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(15,144,24));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;     
          case 9:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(55,190,240));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(55,190,240));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;  
          case 10:
            if(yB2 < 0)
          {
          B2.setBackground(new Color(55,93,206));
          B2.setLocation(X/2 - Y/2, yB2 + (Y / 48));
          }
            if(yB2 == 0)
          {
          B3.setBackground(new Color(55,93,206));
          B2.setLocation((X / 2) - (Y / 2), - Y); 
          } 
          break;
      }     
    }
    });
    
   //Main timer - Increase the Colore variable for specify the new change of background color   
   Timer Home = new Timer(5000, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {         
      idle = 1; 
      if(Colore == 10)
      {
          Colore = 1;
      }
      else
      {
      Colore ++;
      }
    }
    });
   
    public Play() 
    {
        //Remove the edges
        this.setUndecorated(true);
 
        initComponents();
        
        //Maximize the window
        this.setExtendedState(MAXIMIZED_BOTH);
        
        //Color the window completely black
        this.getContentPane().setBackground(new Color(0,0,0));
        
        //Backgound size and location
        B1.setBounds((X / 2) - (Y / 2), 0, Y, Y);   
        
         //Icon
        setIconImage(new ImageIcon(getClass().getResource("/Imagens/Saur.png")).getImage());
        
        //Score label
        font = new Fonts();
        Score1.setFont(font.Fonts(font.g1,0,Y/5));                   
        Score1.setForeground(Color.WHITE);       
        Score1.setHorizontalAlignment(JTextField.CENTER);                                       
        Score1.setBounds((X / 2) - (Y / 4), Y/4, Y / 2, Y / 4);        
            
        //Pause label
        Pause.setFont(font.Fonts(font.g1,0,Y/10));
        Pause.setForeground(Color.YELLOW);
        Pause.setBounds(X/2 - Y/4, Y/3, Y/2, Y/4);
        Pause.setHorizontalAlignment(JTextField.CENTER);        
        
        //Try again menu
        Yes.setFont(font.Fonts(font.g1,0,Y/12));       
        Yes.setBounds(X/2 - Y/2, Y/2, Y/2, Y/4);
        Yes.setHorizontalAlignment(JTextField.CENTER);        
        No.setFont(font.Fonts(font.g1,0,Y/12));   
        No.setBounds(X/2, Y/2, Y/2, Y/4);
        No.setHorizontalAlignment(JTextField.CENTER);       
        
        //Score in Pause Scene
        S1.setFont(font.Fonts(font.g1,0,Y/12));
        S1.setForeground(Color.WHITE);
        S1.setBounds(X/2 - Y/4, Y/40, Y/2, Y/4);
        S1.setHorizontalAlignment(JTextField.CENTER);
        S1.setText("SCORE");        
        S2.setFont(font.Fonts(font.g1,0,Y/12));
        S2.setForeground(Color.WHITE);
        S2.setBounds(X/2 - Y/4, Y/8, Y/2, Y/4);
        S2.setHorizontalAlignment(JTextField.CENTER);        
        
        //Game Over Font
        GameOver.setBackground(new Color(0,0,0,200));
        GameOver.setBounds((X / 2) - (Y / 2), 0, Y, Y); 
        
        //Record label
        Record1.setFont(font.Fonts(font.g1,0,Y/12));
        Record1.setForeground(Color.BLUE);
        Record1.setBounds(X/2 - Y/4, 3*Y/5, Y/2, Y/4);
        Record1.setHorizontalAlignment(JTextField.CENTER);
        Record2.setFont(font.Fonts(font.g1,0,Y/12));
        Record2.setForeground(Color.WHITE);
        Record2.setBounds(X/2 - Y/4, 5*Y/7, Y/2, Y/4);
        Record2.setHorizontalAlignment(JTextField.CENTER);   

        //Backgound size and location
        B3.setBounds((X / 2) - (Y / 2), 0, Y, Y); 
        B3.setBackground(new Color(55,93,206));
        
        //Background change
        B2.setBounds((X / 2) - (Y / 2), - Y, Y, Y); 
        B2.setBackground(new Color(124,55,206));
        
        //Menu
        Title.setFont(font.Fonts(font.g1,0,Y/5));                   
        Title.setForeground(Color.WHITE);       
        Title.setHorizontalAlignment(JTextField.CENTER);                                       
        Title.setBounds((X / 2) - (Y / 4), Y/6, Y / 2, Y / 4);
        Title.setText("SAUR");
        
        Sub.setFont(font.Fonts(font.g1,0,Y/16));                   
        Sub.setForeground(Color.YELLOW);       
        Sub.setHorizontalAlignment(JTextField.CENTER);                                       
        Sub.setBounds((X / 2) - (Y / 2), Y/3, Y, Y / 4);
        Sub.setText("PRESS ENTER TO CONTINUE");
        
        Sub1.setFont(font.Fonts(font.g1,0,Y/18));                   
        Sub1.setForeground(Color.ORANGE);       
        Sub1.setHorizontalAlignment(JTextField.CENTER);                                       
        Sub1.setBounds((X / 2) - (Y / 2), 5*Y/12, Y, Y / 4);
        Sub1.setText("PRESS X TO EXIT");
        
        P2.setBounds((X / 2) - (Y / 8), Y, Y / 3, Y / 3);              
        ImageIcon Saur_R2 = new ImageIcon(Saur_Right2.getImage().getScaledInstance(P2.getWidth(), P2.getHeight(), Image.SCALE_DEFAULT));
        P2.setIcon(Saur_R2);
        
        P3.setBounds((9*X / 14), Y/200, Y / 4, Y / 8);              
        ImageIcon Logo1 = new ImageIcon(Logo.getImage().getScaledInstance(P3.getWidth(), P3.getHeight(), Image.SCALE_DEFAULT));
        P3.setIcon(Logo1);       
        
        //Sounds
        getcherry = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/Coin.wav")); 
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/Select.wav")); 
        death = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/Death.wav")); 
        
        //Read Record Function
        ReadXML();
        
        //Timers Initializing
        Home.start();
        Up.start();
        PRESS.start();  
        Curtain.start();
                
    }
    
    //Begin Game function
    void Begin()
    {
        Home.stop();
        Up.stop();
        PRESS.stop();  
        Curtain.stop();
        B2.setVisible(false);
        B3.setVisible(false);
        P2.setVisible(false);
        Sub.setVisible(false);  
        Sub1.setVisible(false); 
        P3.setVisible(false);
        Title.setVisible(false);
        
         //Color the background completely blue
        B1.setBackground(new Color(55,190,240));
        
        //Timer speed
        //Decrease this variable for enemy faster displacement 
        tempo = 175;
        Fall.setDelay(tempo);
        
        //Location variable
        P1side = 2;
        
        //Background color variable
        EachFive = 0;
        ChangeColor = 0;
        
        //Speed variable
        Speed = true;
        NoMove = false;
        Score = 0;
        
        //Enemy timer falling
        DeathVar = false;
                       
        //Player size and location
        P1.setBounds((X / 2) - (Y / 4), Y - (Y / 4), Y / 4, Y / 4);              
        ImageIcon Saur_R2 = new ImageIcon(Saur_Right2.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));
        P1.setIcon(Saur_R2);
        P1.setVisible(true);
        
         // Transparent 16 x 16 pixel cursor image
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Create a new blank cursor
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
        cursorImg, new Point(0, 0), "blank cursor");
        // Set the blank cursor
        this.getContentPane().setCursor(blankCursor);
        
        //Enemies size and location
        E1.setBounds((X / 2) - (Y / 2), 0, Y / 5, Y / 5);
        E2.setBounds((X / 2) - (Y / 4), 0, Y / 5, Y / 5);
        E3.setBounds((X / 2), 0, Y / 5, Y / 5);
        E4.setBounds((X / 2) + (Y / 4), 0, Y / 5, Y / 5);    
        E1.setVisible(true);
        E2.setVisible(true);
        E3.setVisible(true);
        E4.setVisible(true);
        
        //Pause label
        Pause.setFont(font.Fonts(font.g1,0,Y/10));
        Pause.setText("PAUSE");
        Pause.setVisible(false);
        
        //Try again menu
        Yes.setForeground(Color.YELLOW);
        Yes.setText("<YES>");
        Yes.setVisible(false); 
        No.setForeground(Color.WHITE);
        No.setText("<NO>");
        No.setVisible(false);
        
        //Score in Pause Scene
        S1.setVisible(false);
        S2.setText("0");
        S2.setVisible(false);
        Score1.setText("0");  
        Score1.setVisible(false);
        
        //Game Over Font
        GameOver.setVisible(false); 
        
        //Record label
        Record1.setText("RECORD");
        Record1.setVisible(false);        
        Record2.setVisible(false);
        
        //Random Function
        Random();
        
        //Enemy timer falling
        Fall.start();
        
        //Collisions timer
        Collisions.start();               
        
    }

    //Random function Set the good object (Cherry) on a random place
    void Random()
    {
      //Random variable
      RandomNumber = (int)(Math.random()*4+1);
      ImageIcon Cherry_E = new ImageIcon(Cherry.getImage().getScaledInstance(E1.getWidth(), E1.getHeight(), Image.SCALE_DEFAULT));
      ImageIcon Ice_E = new ImageIcon(Ice.getImage().getScaledInstance(E1.getWidth(), E1.getHeight(), Image.SCALE_DEFAULT));       
      switch(RandomNumber)
      {
          case 1:
          E1.setIcon(Cherry_E);
          E2.setIcon(Ice_E);
          E3.setIcon(Ice_E);
          E4.setIcon(Ice_E);
          break;
          case 2:
          E1.setIcon(Ice_E);
          E2.setIcon(Cherry_E);
          E3.setIcon(Ice_E);
          E4.setIcon(Ice_E);
          break;
          case 3:
          E1.setIcon(Ice_E);
          E2.setIcon(Ice_E);
          E3.setIcon(Cherry_E);
          E4.setIcon(Ice_E);
          break;
          case 4:
          E1.setIcon(Ice_E);
          E2.setIcon(Ice_E);
          E3.setIcon(Ice_E);
          E4.setIcon(Cherry_E);
          break;
      }
    }
    
    //Hide enemies function
    void Hide()
    {
        E1.setVisible(false);
        E2.setVisible(false);
        E3.setVisible(false);
        E4.setVisible(false);
        Score1.setVisible(true);
    }
    
    //Score variable   
    String Plus;  
    //Score function
    void ScorePlus()
    {       
        getcherry.play();
        Score ++;  
        Plus = Integer.toString(Score);
        Score1.setText(Plus);
        S2.setText(Plus);
        //Change Background color
        EachFive ++;             
        if(EachFive == 5)
        {
           ChangeColor ++; 
           switch(ChangeColor)
           {
               case 1:
                    B1.setBackground(new Color(55,93,206));
                    if(Speed == true) tempo -= 20; Fall.setDelay(tempo);
               break;
               case 2:
                    B1.setBackground(new Color(124,55,206));
                if(Speed == true) tempo -= 20; Fall.setDelay(tempo);
               break;
               case 3:
                    B1.setBackground(new Color(164,55,206));
                    if(Speed == true) tempo -= 20; Fall.setDelay(tempo);
               break;
               case 4:
                    B1.setBackground(new Color(206,55,188));
                    if(Speed == true) tempo -= 10; Fall.setDelay(tempo);
               break;
               case 5:
                    B1.setBackground(new Color(206,55,55));
                    if(Speed == true) tempo -= 10; Fall.setDelay(tempo);
               break;
               case 6:
                    B1.setBackground(new Color(206,115,55));
                    if(Speed == true) tempo -= 10; Fall.setDelay(tempo);
               break;
               case 7:
                    B1.setBackground(new Color(197,206,55));
                    if(Speed == true) tempo -= 10; Fall.setDelay(tempo);
               break;
               case 8:
                    B1.setBackground(new Color(124,206,55));
                    if(Speed == true) tempo -= 5; Fall.setDelay(tempo);
               break;
               case 9:
                    B1.setBackground(new Color(15,144,24));
                    if(Speed == true) tempo -= 5; Fall.setDelay(tempo);
               break;
               case 10:
                    B1.setBackground(new Color(55,190,240));
                    if(Speed == true) tempo -= 5; Fall.setDelay(tempo);
                    Speed = false;
                    ChangeColor = 0;                  
               break;
           }
           EachFive = 0;
        }        
    }           
       
    
    //Function for Create a XML File if isn't exist for save the best score
    public void CreateXML() throws ParserConfigurationException, TransformerConfigurationException, TransformerException
    {    
    Plus = Integer.toString(Score);
    
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    DOMImplementation implementation = builder.getDOMImplementation();
 
    Document document = implementation.createDocument(null, "Score", null);
    document.setXmlVersion("1.0");
 
    Element root = document.getDocumentElement();
 
    Element RecordNode = document.createElement("Record"); // Create a new element
    Text nodoValorServidor = document.createTextNode(Plus); //Insert the information
    RecordNode.appendChild(nodoValorServidor);
    root.appendChild(RecordNode); 
    
    Source source = new DOMSource(document);
    StreamResult result = new StreamResult(new java.io.File("Score.xml"));//File Name
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(source, result); 
    NewRecord.start();
    ReadXML();
    }
    
    //Function for Read the XML File for show the hightest score
    public void ReadXML()
    {
    try{
    File fXmlFile = new File("Score.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);
 
    doc.getDocumentElement().normalize();
 
    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
    NodeList nList = doc.getElementsByTagName("Score");
 
    System.out.println("----------------------------");
 
    for (int temp = 0; temp < nList.getLength(); temp++) {
 
        Node nNode = nList.item(temp);
 
        System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
            Element eElement = (Element) nNode;
  
            String record = eElement.getElementsByTagName("Record").item(0).getTextContent();  
            Record = Integer.parseInt(record);       
            Record2.setText(record);
            
        }
    }
    }catch (Exception e)
    {
    e.printStackTrace();
    }
  }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Sub1 = new javax.swing.JLabel();
        Sub = new javax.swing.JLabel();
        P3 = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        B2 = new javax.swing.JPanel();
        B3 = new javax.swing.JPanel();
        Pause = new javax.swing.JLabel();
        S1 = new javax.swing.JLabel();
        S2 = new javax.swing.JLabel();
        Yes = new javax.swing.JLabel();
        No = new javax.swing.JLabel();
        Record1 = new javax.swing.JLabel();
        Record2 = new javax.swing.JLabel();
        GameOver = new javax.swing.JPanel();
        P1 = new javax.swing.JLabel();
        Score1 = new javax.swing.JLabel();
        E4 = new javax.swing.JLabel();
        E3 = new javax.swing.JLabel();
        E2 = new javax.swing.JLabel();
        E1 = new javax.swing.JLabel();
        B1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(Title);
        Title.setBounds(290, 390, 0, 0);
        getContentPane().add(Sub1);
        Sub1.setBounds(260, 340, 0, 0);
        getContentPane().add(Sub);
        Sub.setBounds(260, 340, 0, 0);
        getContentPane().add(P3);
        P3.setBounds(340, 330, 0, 0);
        getContentPane().add(P2);
        P2.setBounds(340, 330, 0, 0);
        getContentPane().add(B2);
        B2.setBounds(280, 110, 10, 10);
        getContentPane().add(B3);
        B3.setBounds(320, 40, 10, 10);
        getContentPane().add(Pause);
        Pause.setBounds(200, 360, 0, 0);
        getContentPane().add(S1);
        S1.setBounds(320, 370, 0, 0);
        getContentPane().add(S2);
        S2.setBounds(0, 0, 0, 0);
        getContentPane().add(Yes);
        Yes.setBounds(180, 360, 0, 0);
        getContentPane().add(No);
        No.setBounds(300, 340, 0, 0);
        getContentPane().add(Record1);
        Record1.setBounds(260, 370, 0, 0);
        getContentPane().add(Record2);
        Record2.setBounds(330, 360, 0, 0);
        getContentPane().add(GameOver);
        GameOver.setBounds(200, 50, 10, 10);
        getContentPane().add(P1);
        P1.setBounds(100, 200, 100, 100);
        getContentPane().add(Score1);
        Score1.setBounds(167, 316, 0, 0);
        getContentPane().add(E4);
        E4.setBounds(100, 100, 50, 50);
        getContentPane().add(E3);
        E3.setBounds(100, 100, 50, 50);
        getContentPane().add(E2);
        E2.setBounds(100, 100, 50, 50);
        getContentPane().add(E1);
        E1.setBounds(100, 100, 50, 50);
        getContentPane().add(B1);
        B1.setBounds(100, 100, 200, 200);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Keyboard Events
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //Player movement
        xp1 = P1.getX();
        yp1 = P1.getY();      
        
        switch(evt.getExtendedKeyCode())
        {                 
            case KeyEvent.VK_LEFT:             
             if(NoMove == false)
             {
                switch(PauseMode)
                {
                    case 0:
                if(xp1 == (X / 2) - (Y / 2))
                {
                    P1.setLocation(xp1, yp1);  
                }
                else
                {
                    P1.setLocation(xp1 - (Y / 4), yp1);                    
                }     
                ImageIcon Saur_L2 = new ImageIcon(Saur_Left2.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));
                P1.setIcon(Saur_L2); 
                break;
                }
             }
             else if(NoMove == true && Menu == false)
             {
               select.play();
               Yes.setForeground(Color.YELLOW);             
               No.setForeground(Color.WHITE);      
             }
             P1side = 1;
            break; 
            
            case KeyEvent.VK_RIGHT:            
             if(NoMove == false)
             {
                switch(PauseMode)
                {
                    case 0:
                  if(xp1 == (X / 2) + (Y / 4))
                {
                    P1.setLocation(xp1, yp1);  
                }
                else
                {
                    P1.setLocation(xp1 + (Y / 4), yp1);
                }   
                ImageIcon Saur_R2 = new ImageIcon(Saur_Right2.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));
                P1.setIcon(Saur_R2);
                    break;
                }                               
             }
             else if(NoMove == true && Menu == false)
             {
               select.play();
               No.setForeground(Color.YELLOW);             
               Yes.setForeground(Color.WHITE);  
             }
             P1side = 2;
            break; 
                       
            case KeyEvent.VK_ENTER:
                select.play();
                if(Menu == true)
                {                   
                  Menu = false;
                  Begin();                  
                }
                else if(Menu == false)
                {              
                if(NoMove == false)
                {
                 switch(PauseMode)                   
                 {
                     case 0:
                      GameOver.setVisible(true);
                      Pause.setVisible(true);
                      S1.setVisible(true);
                      S2.setVisible(true);
                      Fall.stop();
                      PauseMode = 1;
                     break;
                     
                     case 1:
                      GameOver.setVisible(false); 
                      Pause.setVisible(false);
                      S1.setVisible(false);
                      S2.setVisible(false);
                      Fall.start();
                      PauseMode = 0;
                     break;
                 }
                }
                else if(NoMove == true)
                {
                   NewRecord.stop();
                   switch(P1side)
                   {
                       case 1:
                        Begin();
                       break;
                       
                       case 2:
                         Home.start();
                         Up.start();
                         PRESS.start();  
                         Curtain.start();
                         B2.setVisible(true);
                         B3.setVisible(true);
                         P2.setVisible(true);
                         Sub.setVisible(true);                         
                         Sub1.setVisible(true);
                         P3.setVisible(true);
                         Title.setVisible(true);    
                         Menu = true;
                       break;
                   }
                }
                }
            break;
            
            case KeyEvent.VK_A:             
             if(NoMove == false)
             {
                switch(PauseMode)
                {
                    case 0:
                if(xp1 == (X / 2) - (Y / 2))
                {
                    P1.setLocation(xp1, yp1);  
                }
                else
                {
                    P1.setLocation(xp1 - (Y / 4), yp1);                    
                }     
                ImageIcon Saur_L2 = new ImageIcon(Saur_Left2.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));
                P1.setIcon(Saur_L2); 
                break;
                }
             }
             else if(NoMove == true && Menu == false)
             {
               select.play();
               Yes.setForeground(Color.YELLOW);             
               No.setForeground(Color.WHITE);      
             }
             P1side = 1;
            break; 
            
            case KeyEvent.VK_D:            
             if(NoMove == false)
             {
                switch(PauseMode)
                {
                    case 0:
                  if(xp1 == (X / 2) + (Y / 4))
                {
                    P1.setLocation(xp1, yp1);  
                }
                else
                {
                    P1.setLocation(xp1 + (Y / 4), yp1);
                }   
                ImageIcon Saur_R2 = new ImageIcon(Saur_Right2.getImage().getScaledInstance(P1.getWidth(), P1.getHeight(), Image.SCALE_DEFAULT));
                P1.setIcon(Saur_R2);
                    break;
                }                               
             }
             else if(NoMove == true && Menu == false)
             {
               select.play();
               No.setForeground(Color.YELLOW);             
               Yes.setForeground(Color.WHITE);  
             }
             P1side = 2;
            break;            
            
            case KeyEvent.VK_SPACE:
                select.play();
                if(Menu == true)
                {                   
                  Menu = false;
                  Begin();                  
                }
                else if(Menu == false)
                {              
                if(NoMove == false)
                {
                 switch(PauseMode)                   
                 {
                     case 0:
                      GameOver.setVisible(true);
                      Pause.setVisible(true);
                      S1.setVisible(true);
                      S2.setVisible(true);
                      Fall.stop();
                      PauseMode = 1;
                     break;
                     
                     case 1:
                      GameOver.setVisible(false); 
                      Pause.setVisible(false);
                      S1.setVisible(false);
                      S2.setVisible(false);
                      Fall.start();
                      PauseMode = 0;
                     break;
                 }
                }
                else if(NoMove == true)
                {
                   NewRecord.stop();
                   switch(P1side)
                   {
                       case 1:
                        Begin();
                       break;
                       
                       case 2:
                         Home.start();
                         Up.start();
                         PRESS.start();  
                         Curtain.start();
                         B2.setVisible(true);
                         B3.setVisible(true);
                         P2.setVisible(true);
                         Sub.setVisible(true);                         
                         Sub1.setVisible(true);
                         P3.setVisible(true);
                         Title.setVisible(true);    
                         Menu = true;
                       break;
                   }
                }
                }
            break;
            
            case KeyEvent.VK_X:                  
                System.exit(0);
            break;    
                     
        }
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
     
    }//GEN-LAST:event_formKeyReleased

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Play().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel B1;
    private javax.swing.JPanel B2;
    private javax.swing.JPanel B3;
    private javax.swing.JLabel E1;
    private javax.swing.JLabel E2;
    private javax.swing.JLabel E3;
    private javax.swing.JLabel E4;
    private javax.swing.JPanel GameOver;
    private javax.swing.JLabel No;
    private javax.swing.JLabel P1;
    private javax.swing.JLabel P2;
    private javax.swing.JLabel P3;
    private javax.swing.JLabel Pause;
    private javax.swing.JLabel Record1;
    private javax.swing.JLabel Record2;
    private javax.swing.JLabel S1;
    private javax.swing.JLabel S2;
    private javax.swing.JLabel Score1;
    private javax.swing.JLabel Sub;
    private javax.swing.JLabel Sub1;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Yes;
    // End of variables declaration//GEN-END:variables
}
