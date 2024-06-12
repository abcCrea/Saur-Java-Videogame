// <abc Crea 2020> - <Oscar Eduardo Ochoa Velasco>

package saur;

import Typography.Fonts;
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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Menu extends javax.swing.JFrame 
{
    //Getting Window dimensions
   int X = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
   int Y = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
   //Declaration of the Arrow coordinates
   //Variables for Do the Animations
   int yB2, yA1;
   
   //Assignament of the Character Sprites
   ImageIcon Saur_Right1 = new ImageIcon(getClass().getResource("/Imagens/Saur_R1.png"));
   ImageIcon Saur_Right2 = new ImageIcon(getClass().getResource("/Imagens/Saur_R2.png"));
   
   //Typography variable
   Fonts font;
    
   //Press timer
   int press = 1;
   //Each 250ms Change the Subtitle Visibility "PRESS ENTER TO CONTINUE"
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
   
   //Up and Down Character timer
   int up = 1;
   int idle = 1;
   //Change the Character Location and Sprites on three times with the idle counter
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
   
   
    //Background timer
    //Change the Bakground Color each time that the Character climb to scene
    int Colore = 0;
    Timer Curtain = new Timer(50, new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {         
      yB2 = B2.getY();
      
      //Colore variable its a counter
      //Each Down Slide its maked for two backgrounds B2 and B3 that are moving to down with the help of the yB2 variable
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
    
   //Main timer   
   //Each 5s increase the Colore variable for 1 until this reah a 10 value and reset the variable to 1
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
   
    public Menu() 
    {
         //Remove the edges
        this.setUndecorated(true);
        initComponents();
        //Maximize the window
        this.setExtendedState(MAXIMIZED_BOTH);
        
        //Color the window completely black
        this.getContentPane().setBackground(new Color(0,0,0));  
        
        //Backgound size and location with the window dimensions (X Y)
        B3.setBounds((X / 2) - (Y / 2), 0, Y, Y); 
        B3.setBackground(new Color(55,93,206));
        
        //Background change - Second background for do the Down Slide animation
        B2.setBounds((X / 2) - (Y / 2), - Y, Y, Y); 
        B2.setBackground(new Color(124,55,206));
        
        //Set the Icon
        setIconImage(new ImageIcon(getClass().getResource("/Imagens/Saur.png")).getImage());
        
        // Transparent 16 x 16 pixel cursor image
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Create a new blank cursor
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
        cursorImg, new Point(0, 0), "blank cursor");
        // Set the blank cursor
        this.getContentPane().setCursor(blankCursor);
        
        //Menu Configurations: sizes, fonts, colors and texts
        font = new Fonts();
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
        
        P2.setBounds((X / 2) - (Y / 8), Y, Y / 3, Y / 3);              
        ImageIcon Saur_R2 = new ImageIcon(Saur_Right2.getImage().getScaledInstance(P2.getWidth(), P2.getHeight(), Image.SCALE_DEFAULT));
        P2.setIcon(Saur_R2);                 
        
        //Timers Initialazing
        Home.start();
        Up.start();
        PRESS.start();  
        Curtain.start();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Sub = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        B2 = new javax.swing.JPanel();
        B3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(Title);
        Title.setBounds(230, 260, 0, 0);
        getContentPane().add(Sub);
        Sub.setBounds(310, 350, 0, 0);
        getContentPane().add(P2);
        P2.setBounds(280, 210, 0, 0);

        javax.swing.GroupLayout B2Layout = new javax.swing.GroupLayout(B2);
        B2.setLayout(B2Layout);
        B2Layout.setHorizontalGroup(
            B2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        B2Layout.setVerticalGroup(
            B2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(B2);
        B2.setBounds(250, 70, 100, 100);

        javax.swing.GroupLayout B3Layout = new javax.swing.GroupLayout(B3);
        B3.setLayout(B3Layout);
        B3Layout.setHorizontalGroup(
            B3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        B3Layout.setVerticalGroup(
            B3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(B3);
        B3.setBounds(140, 160, 100, 100);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Keyboard Events
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       switch(evt.getExtendedKeyCode())
        {                 
            case KeyEvent.VK_X: 
                System.exit(0);
            break; 
            
            case KeyEvent.VK_ESCAPE: 
                System.exit(0);
            break;
            
            case KeyEvent.VK_ENTER: 
                  Play open = new Play();
                  open.setVisible(true);                  
                  this.setVisible(false);                  
            break;                                     
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel B2;
    private javax.swing.JPanel B3;
    private javax.swing.JLabel P2;
    private javax.swing.JLabel Sub;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
