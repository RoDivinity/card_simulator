/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfun;

import java.awt.image.BufferedImage;

/**
 * 
 * @author Vodka
 */
public class Card {
   private String name;
   private boolean isFaceUp;
   private String icon;
   
   public Card (String c_name, String c_icon)
   {
       name = c_name;
       icon = c_icon;
       isFaceUp = false;
   }
   
   public void setName(String a)
   {
       name = a;
   }
   
   public String getName()
   {
       return name;
   }
   
   public void setIcon(String a)
   {
       icon = a;
   }
   
   public String getIcon()
   {
       return icon;
   }
   
   public void setFaceUp()
   {
       isFaceUp = true;
   }
   
   public boolean isFaceUp()
   {
       return isFaceUp;
   }
}
