
package Typography;

import java.awt.Font;
import java.io.InputStream;


public class Fonts 
{
    private Font f1 = null;
    public String g1 = "8bit.TTF";
 
    public  Font Fonts (String fontName, int style, float size)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(fontName);
            f1 = Font.createFont(Font.TRUETYPE_FONT, is);
        }
        catch (Exception ex)
                {
                    System.out.println(fontName + "No se cargo la fuente");
                    f1 = new Font("Lucida Console", Font.PLAIN, 24);
                }
        Font tfont = f1.deriveFont(style, size);
        return tfont;
    }
    
}
