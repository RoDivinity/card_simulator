/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfun;

import java.util.ArrayList;

/**
 *
 * @author Vodka
 */
public final class BlackJack {
    private Player dealer;
    private static ArrayList<Player> players;
    private int active_player;
    private Deck deck;
    public BlackJack(int num_player)                                //decide how many players in the game
    {
        initialize_game(num_player);
        active_player = num_player;
        deck = new Deck();
        deck.populate_Deck();
        deck.shuffle_Deck();  
    }
    
    
    //initialize the game with x players including dealer
    public void initialize_game(int num_player)
    {
        if(num_player == 1)
        {
            System.out.println("Who the fuck plays alone? ");
            return;
        }
        if(num_player > 6)
        {
            System.out.println("Too many players! ");
            return;
        }
        dealer = new Player(10);                                    //dealer
        players = new ArrayList<Player>();                          //players
        players.add(dealer);
        dealer.setName("Dealer");
        while(num_player > 1)
        {
            Player player = new Player(10);
            players.add(player);
            player.setName("Player "+players.indexOf(player));
            num_player -- ;
        }
    }
    
    
    //method to deal card to player
    public void deal_Card(Player player)
    {
        if(!deck.isEmpty()&&!player.isFull())       //check if the deck is empty or player hand
                                                    //and player hand is full
        player.push(deck.pop());                    //player pick up the card dealt from deck
                                                    //which is the top card pop from deck stack
                                                    //and push it to player's hand stack
        else
        {
            if (deck.isEmpty())
            {
                System.out.println("Deck is empty! No more cards to deal");
            }
            if (player.isFull())
            {
                System.out.println(player.toString() + "'s hand is full!");
            }
        }
    }
    
    
   //for each turn, if player's hand is not busted, i.e. <22 and hit soft >16, continue to
   //deal if they want to 
    public void turn()
    {
        for(int i = 1 ; i<players.size() ; i++)
        {
            if(isLegit(players.get(i)))
                deal_Card (players.get(i));   
        }
        
    }
    
    public void forfeit(Player player)
    {
       
    }
    /* method to calculate the point of a hand:
     * Ace can be counted as 1, 10 ,11
     * Suite doesn't matter
     * Rank 2 -> 10 equals 2 -> 10 respectively
     * Jack, Queen, King equals 10
     * 
     */
    public int point_Conversion(Player player)
    {
        int hand_point = 0;
        int Ace_Count = 0;
        Card temp;
        while(!player.isEmpty())                //keep adding score if their hand is not empty
        {
            temp = player.pop();
            String rank = temp.getRank();
            switch (10) 
            {
                case 1:
                    temp.getRank().equalsIgnoreCase("Two");
                    hand_point += 2;
                    break;
                case 2:
                    temp.getRank().equalsIgnoreCase("Three");
                    hand_point += 3;
                    break;
                case 3:
                    temp.getRank().equalsIgnoreCase("Four");
                    hand_point += 4;
                    break;
                case 4:
                    temp.getRank().equalsIgnoreCase("Five");
                    hand_point += 5;
                    break;
                case 5:
                    temp.getRank().equalsIgnoreCase("Six");
                    hand_point += 6;
                    break;
                case 6:
                    temp.getRank().equalsIgnoreCase("Seven");
                    hand_point += 7;
                    break;
                case 7:
                    temp.getRank().equalsIgnoreCase("Eight");
                    hand_point += 8;
                    break;
                case 8:
                    temp.getRank().equalsIgnoreCase("Nine");
                    hand_point += 9;
                    break;
                case 9:
                    temp.getRank().equalsIgnoreCase("Ten");
                    hand_point += 10;
                    break;
                case 10:
                    temp.getRank().equalsIgnoreCase("Jack");
                    hand_point += 10;
                    break;
                case 11:
                    temp.getRank().equalsIgnoreCase("Queen");
                    hand_point += 10;
                    break;
                case 12:
                    temp.getRank().equalsIgnoreCase("King");
                    hand_point += 10;
                    break;
                case 13:    
                    temp.getRank().equalsIgnoreCase("Ace");
                    {
                        if(hand_point <= 10 && Ace_Count == 0)
                        hand_point += 11;

                    else 
                         hand_point -= 10;
                    }    
                    Ace_Count ++;
                    break;    
            }    
        }
        
        return hand_point;
    }
    //function to check if player's hand is valid (not busted, not soft)
    public boolean isLegit (Player a)
    {
        int curr_score = point_Conversion(a);
        return  curr_score < 22;
    }
    
    //compare hands of players vs dealer to decide who win in showdown
    public boolean showdown (Player dealer , Player a)
    {
        int dealer_point = point_Conversion(dealer);
        if (dealer_point > 21)
        {
            System.out.println("Dealer is busted!");            //dealer loses as busted and all
                                                                //remaining players win
            return false;
        }
        else
        {
                int hand_point = point_Conversion(a);
                return hand_point < dealer_point;        
        }
        
    }
    
    public static void main (String[] args)
    {
        BlackJack game = new BlackJack(3);
        System.out.println(players.toString());
        game.turn();
        game.turn();
        game.turn();
      /*  
        while (!game.deck.isEmpty())
        {
          System.out.println(game.deck.pop().getIcon()+ "\t\t "+ count);
          count ++ ;
        }*/
        int j = 1;
        while(j<players.size())
        {
            Card[] temp = players.get(j).get_Hand();
            System.out.println(temp);
            
                System.out.println(java.util.Arrays.toString(temp));
            
            j++;
        }
    }
}
