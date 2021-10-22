package quizclasses;

public class TraderPair {
	private Trader trader1;
	private Trader trader2;
	public TraderPair(Trader t1, Trader t2) {
		trader1 = t1;
		trader2 = t2;
	}
	public Trader getTrader1() {
		return trader1;
	}
	public Trader getTrader2() {
		return trader2;
	}
	@Override
	public String toString() {
		return "(" + trader1.toString() + ", " + trader2.toString() + ")";
	}
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof TraderPair)) return false;
		TraderPair tp = (TraderPair)ob;
		return (tp.trader1.equals(trader1) && tp.trader2.equals(trader2)) || 
				(tp.trader2.equals(trader1) && tp.trader1.equals(trader2));
	}
}
