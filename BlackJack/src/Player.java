/**
*Player class inherits methods from DeckHand
*Also contains cash amount and bet amount from player
*
**/
public class Player extends DeckHand {
private double cashAmt;
private double betAmt;


Player(double cAmt, double bAmt)
{
	this.cashAmt = cAmt;
	this.betAmt = bAmt;
}

Player()
{
	cashAmt = 0;
	betAmt = 0;
}

//setters for cash&bet
public void setCashAmt(double cashAmt)
{
	this.cashAmt= cashAmt;
}

public void setBetAmt (double betAmt)
{
	this.betAmt = betAmt;
}

//getters for cash&bet
public double getcashAmt()
{
	return cashAmt;
}
public double getBetAmt()
{
	return betAmt;
}

//calculate cashAmt when player wins
public void calcWinAmt(double betAmt, double cashAmt)
{
	cashAmt  = cashAmt + (betAmt*1.5);
	setCashAmt(cashAmt);
}

//calculate when player loses
public void calcLostAmt(double betAmt, double cashAmt)
{
   cashAmt = cashAmt - betAmt;
   setCashAmt(cashAmt);
}
}
