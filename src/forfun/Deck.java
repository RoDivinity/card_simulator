/*
 * Class for create a deck of 52 playing cards together with
 * normal functionality of a deck: shuffling the deck, dealing hands
 */
package forfun;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * @version 1.0.0
 * @author Vodka
 */
public class Deck implements Stack_Interface
{   
    
    static final int DECK_SIZE = 52;
    private int top;
    private Card[] deck;
    static final String[] FINAL_RANK =
    {
        "1" , "2" , "3" , "4" , "5" , "6" ,
     "7" , "8" , "9" , "10" , "J" , "Q" , "K" 
    };
    
    static final char[] FINAL_SUITE =
    { (char)'\u2660' , (char) '\u2663' , (char) '\u2666' , (char) '\u2764' };
    
    static final String[] NAME_RANK =
    {
      "Ace" , "Two" , "Three" , "Four" , "Five" ,
      "Six" , "Seven" , "Eight" , "Nine" , "Ten" ,
      "Jack" , "Queen" , "King"  
    };
    
    static final String[] NAME_SUITE = 
    {
        "Spade" , "Club" , "Diamond" , "Heart"
    };
    
    //initialize a card deck
    public Deck ()
    {
        deck = new Card[DECK_SIZE];
        top = -1;
    }
    
    @Override
    public void push(Card a)        //add the element to the top of the stack so + 1 top first
    {
        deck[++top] = a;
    }
    
    @Override
    public Card pop()               //delete top element then decrease top by 1
    {
        Card a = deck[top];
        deck[top] = null;
        top -- ;
        return a;
    }
    
    @Override
    public Card peek()              //return top card of the deck and do nothing
    {
        return deck[top];
    }
    
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    public boolean isFull()
    {
        return top == DECK_SIZE - 1;
    }
    
    public void populate_Deck()
    {
        int suite = 0;                  // count what suite we are right now
                                        // 0 = spade
                                        // 1 = club
                                        // 2 = diamond
                                        // 3 = heart
        int count = 0;
        int deck_count = 0;
        for (suite=0;suite<4;suite++)
        {
        for (count=0;count<13;count++)
            {
           //card_name[count][suite] = final_name[count] + " of " +final_suite[suite];
            //Create name and icon for each card
                System.out.println("new card! "+deck_count);
            String c_icon  = FINAL_RANK[count]  +   FINAL_SUITE[suite];
            String c_name  = NAME_RANK[count] + " Of " +  NAME_SUITE[suite];
            push(new Card(c_name , c_icon));
            
            }    
        }
    }
    
   // public Card[] create_deck()
    
       
       
       
    
    
    //method to create random numbers
    public int randomInt(int min, int max)
    {
        int r_Number = ThreadLocalRandom.current().nextInt(min, max+1);
        return r_Number;
    }
    
    public void swap( int i, int change)  //how to swap 2 cards
    {
        Card swap_card = deck[i];
        deck[i] = deck[change];
        deck[change] = swap_card;
    }
    
    public void shuffle_Deck()            //shuffle the deck
    {  
        Random rand = new Random();
        rand.nextInt();
        for (int i = 0; i < 52; i++)
        {
            int change = i + rand.nextInt(52 - i);
            swap( i, change);
        }
    }
    
    public void deal_card(int num_player)
    {
        //should I use pop(), push(), peek()?
    }
        
    

    
}

