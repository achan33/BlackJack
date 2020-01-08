
/**
 * BlackJack Simulation: Mimics the general blackjack
 * rules. Player wins by drawing cards with a point value 
 * of 21 or a point value higher than the dealer draw.
 * Once a dealer reaches greater than 17. He stays. Player
 * wins a 3:2 bet and loses the amount they bet.
 * @author Angela Chan
 * @param Utilizes deck class, dealer, and player class
 * which is inherited by DeckHand class. 
 * 
 */

import java.util.Scanner;
public class BlackJackSimulation {

	public static void main(String[] args) 
{
	
		String fCard;//first card
		int fCValue;
		String sCard; //second card
		int sCValue;
		String nCard;//next card
		int nCValue = 0;
		int dCard; //dealer card value
		int cardValue= 0; //player card value
		String decision;
		boolean gameRun = true;
		
		Deck deck = new Deck();
		Player p1 = new Player(); //player
		DeckHand d1 = new DeckHand(); //dealer
		
		
		//Player p1 = new Player();
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter amount of cash");
		p1.setCashAmt(input.nextDouble());
	
		
		//cash amount <0 keep playing
try 
{
		while(gameRun)
		{
			boolean playerTurn = true;
			boolean keepGoing = true;
			while(playerTurn) //allows players turn
			{
			System.out.println("Please enter bet amount." + " Current cash amount: " + p1.getcashAmt());	
			p1.setBetAmt(input.nextDouble());
			
			System.out.println("Drawing cards");
		    fCard =deck.drawCard();
		    fCValue = deck.calcCardValue();
		    sCard =deck.drawCard();
		    sCValue = deck.calcCardValue();
			System.out.println("Your cards are " + fCard + " and " + sCard);		//shows cards
			cardValue = p1.startCalcDeck(fCValue, sCValue);
			System.out.println("Card value: " + cardValue ); //shows value
			
			if(cardValue==21 ) //exception for when first two drawn equal 21
			{
				System.out.println("You won!");
				p1.calcWinAmt(p1.getBetAmt(), p1.getcashAmt());//i believe winnings are 1.5x 3:2 ratio
				System.out.println("You have " + p1.getcashAmt());
			}
			else
			{//continue with game
			while(keepGoing)
			{
				System.out.println("Would you like to hit or stay?");
				decision =input.next().toLowerCase();
				if(decision.equals("hit"))
				{
					nCard =deck.drawCard();
					nCValue = deck.calcCardValue();
					cardValue = p1.newCardCalc(cardValue, nCValue); 
					System.out.println("Your new card is " + nCard + ". Card Value is " + cardValue );
					if(cardValue ==21)
					{
						System.out.println("You won!");
						p1.calcWinAmt(p1.getBetAmt(), p1.getcashAmt());
						System.out.println("You have " + p1.getcashAmt());
						break;
					}
					if(cardValue>21)
					{
						System.out.println("Bust, You lost");
						p1.calcLostAmt(p1.getBetAmt(), p1.getcashAmt());
						if(p1.getcashAmt()<=0)
						{	
							System.out.println("Out of money");
							gameRun =false;
							playerTurn = false;
						}
						break;
					}
				}
			
				if(decision.equals("stay"))
				{
				keepGoing = false;
				playerTurn = false;
				}
				
				
			}//keepGoing loop
			 
			}//else loop of not winning with first two cards
			
			
			}//players turn over
			if(cardValue<21)
			{	
			System.out.println("Dealer starts...");
			fCard = deck.drawCard(); //reusing variables
			fCValue = deck.calcCardValue();
			sCard = deck.drawCard(); //reusing variables
			sCValue = deck.calcCardValue();
			System.out.println("Dealer's cards: " + fCard + " and " + sCard);
			dCard = d1.startCalcDeck(fCValue, sCValue);
			System.out.println("Dealer's value: " + dCard);
			while(dCard<18)
			{
				System.out.println("Drawing another card...");
				nCard = deck.drawCard();
				nCValue = deck.calcCardValue();
				System.out.println("Dealer gets " + nCard);
				dCard = d1.newCardCalc(dCard, nCValue);
				System.out.println("Dealer's value: " + dCard);
			}
//conditions after dealer and player goes
			if(dCard ==21)
			{
				System.out.print("Dealer won!");
				p1.calcLostAmt(p1.getBetAmt(), p1.getcashAmt());
				System.out.println("You have" + p1.getcashAmt());
			}
			if(dCard>21)
			{
				System.out.println("Dealer bust. Player won!");
				System.out.println("You won!");
				p1.calcWinAmt(p1.getBetAmt(), p1.getcashAmt()); 
				System.out.println("You have " + p1.getcashAmt());
				
			}
			if(cardValue>dCard)
			{
				System.out.println("Player won!");
				p1.calcWinAmt(p1.getBetAmt(), p1.getcashAmt());
				System.out.println("You have " + p1.getcashAmt());
			}
			if(cardValue<dCard)
			{
				System.out.println("Player lost");
				p1.calcLostAmt(p1.getBetAmt(), p1.getcashAmt());
				if(p1.getcashAmt()<=0)
				{
					System.out.println("Out of money");
					playerTurn = false;
					gameRun = false;
				}
				System.out.println("You have " +  p1.getcashAmt());
			}
			if(cardValue ==dCard)
			{
				System.out.println("It's a tie!");
				System.out.println("You have " + p1.getcashAmt());
			}
			}
		
			
		}//while money is not 0
	input.close();
	System.out.println("Game over");
}
catch(Exception e)
{
	System.out.println("Incorrect input. Game has crashed. Please restart");
}

	}//main
}//class