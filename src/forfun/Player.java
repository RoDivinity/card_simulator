/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfun;

/**
 * Player Object:
 * Contains hand cards
 * @author Vodka
 */
public class Player implements Stack_Interface{
    private int hand_size;
    private Card[] hand;
    private String name;
    private int top;
    
    public Player(int size)             //Initialize player
    {
        hand_size = size;
        hand = new Card[hand_size];
        name = "";
        top  = -1;
    }
    
    public void push(Card a)
    {
        hand[++top] = a;
    }
    
    public Card pop()
    {
        Card a = hand[top];
        hand[top] = null;
        top--;
        return a;
    }
    
    public Card peek()
    {
        return hand[top];
    }
    
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    public boolean isFull()
    {
        return top == hand_size - 1;
    }
    
    public Card[] get_Hand()
    {
        return hand;
    }
    
    public void setName(String a)
    {
        name = a;
    }
    
    public String toString()
    {
        return name;
    }
    
    public int getHandSize()
    {
        return hand_size;
    }
    
}
