/**
*This class will generate the deck of cards. It combines two one dimensional
*arrays to into a multi-dimensional array to create a card type ie. Ace of hearts
*using the random number generator.
*/

//Card Deck
public class Deck {
private int cardValue;
private int cardNum;
private int cardShape;
//private String cardDrawn;
private String [] card = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
private String [] type = {"Diamonds", "Clovers", "Hearts","Spades"};
private String [][]deck = new String [13][4] ;



//creating deck
private void createDeck ()
{
for(int value=0; value<card.length ; value++)
{
	for(int shape=0; shape<type.length; shape++)
	{
	 deck[value][shape]= card[value] + " of " + type[shape];
	}
}
}
//random draw one Num
private int cardNumGen()
{
	cardNum = (int)(Math.random()*12);
	return cardNum;
}

//random draw card shape i.e hearts, diamonds...
private int cardShapeGen()
{
	cardShape = (int)(Math.random()*4);
	return cardShape;
}
/*
public void setCardDrawn(int cardNum , int cardShape)
{
	this.cardDrawn = deck[cardNum][cardShape];
}

public String getCardDrawn()
{
	return cardDrawn;
}

public void setCardValue(int cardValue)
{
	this.cardValue = cardValue;
}
public int getCardValue()
{
	return cardValue;
}*/

//get cardValue 
public int calcCardValue()
{
	switch(cardNum)
	{
	case 0: cardValue = 1; break;
	case 1: cardValue = 2; break;
	case 2: cardValue = 3; break;
	case 3: cardValue = 4; break; 
	case 4: cardValue = 5; break;
	case 5: cardValue = 6; break;
	case 6: cardValue = 7; break;
	case 7: cardValue = 8; break;
	case 8: cardValue = 9; break;
	case 9: cardValue = 10; break;
	case 10: cardValue = 10; break;
	case 11: cardValue = 10; break;
	case 12: cardValue = 10; break;
	}
	return cardValue;
}

//draw card calls random calls deck
public String drawCard()
{   createDeck();
	cardNumGen();
	cardShapeGen();
	return deck[cardNum][cardShape];
}
}
