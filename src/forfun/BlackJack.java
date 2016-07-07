/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfun;

/**
 *
 * @author Vodka
 */
public class BlackJack {
    public BlackJack()
    {
        
    }
    public static void main (String[] args)
    {
        Deck a = new Deck();
        a.populate_Deck();
        a.shuffle_Deck();
        int count = 1;
        while (!a.isEmpty())
        {
          System.out.println(a.pop().getIcon()+ "\t\t "+ count);
          count ++ ;
        }
    }
}
