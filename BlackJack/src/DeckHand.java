/**
 * 
 * @Contains methods for calculating point value in players hand
 *
 */
public class DeckHand {

private int totalValue; //calculate first two cards value
private int nTotalValue; //calculate following new card values

//create deck
Deck deck = new Deck();


 //draw card method call from deck
public String drawCard()
{
	return deck.drawCard();
}


//calculate starting cards
protected int startCalcDeck(int card1, int card2)
{
	
	if(card1==1 | card2==1 )
	{//calculates if first values will be 11 , if 11 convert to 21
		
		if(card1==10 |card2==10)
		{
			totalValue = 21;
		}
		totalValue = card1+ card2 + 10; //assuming one would be ace
	}
	else
	{
	totalValue = card1 + card2;
	}
	return totalValue;
}

//calculating adding new cards 
protected int newCardCalc(int totalValue, int nextCard)
{
	//calc for 21
	if(totalValue ==10 & nextCard ==1)
	{
		nTotalValue = 21;
	}
	else
	{
		if(totalValue<10 &nextCard ==1)
		{
		 nTotalValue = totalValue + 11;	
		}
		else
		{
		nTotalValue = totalValue + nextCard;
		}
	}
return nTotalValue;
}

}
