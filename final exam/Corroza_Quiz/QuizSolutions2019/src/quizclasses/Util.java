package quizclasses;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Util {
	public static Stream<TraderPair> allTraderPairs(Stream<Trader> traders) {
		List<TraderPair> pairs = new ArrayList<>();
		List<Trader> tradersList = traders.collect(Collectors.toList());
		for(Trader s: tradersList) {
			for(Trader t: tradersList) {
				if(!s.equals(t)) {
					TraderPair tp1 = new TraderPair(s,t);
					TraderPair tp2 = new TraderPair(t,s);
					if(!pairs.contains(tp1) && !pairs.contains(tp2)) {
						pairs.add(tp1);
					}
				}
			}
		}
		return pairs.stream();
		
	}
}
