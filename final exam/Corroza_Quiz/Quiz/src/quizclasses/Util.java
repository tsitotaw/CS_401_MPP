package quizclasses;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Util {
	/** Returns a Stream of TraderPairs, consisting of all pairs (s,t)
	 *  for which s and t belong to the input Stream traders. Pairs of the
	 *  form (s,s) are not included. Also, if the return stream contains a
	 *  pair (s,t), it does not contain the pair (t,s).
	 */
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
