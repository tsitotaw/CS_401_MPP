package quizclasses;


import java.util.Arrays;
import java.util.List;


public class TraderTransactTestData {
	 
        static Trader raoul = new Trader("Raoul", "Cambridge");
        static Trader mario = new Trader("Mario","Milan");
        static Trader alan = new Trader("Alan","Cambridge");
        static Trader brian = new Trader("Brian","Cambridge");
        static Trader tomas = new Trader("Tomas", "Cambridge");
        static Trader tony = new Trader("Tony","Milan");
        static Trader craig = new Trader("Craig","Cambridge");
        static Trader greg = new Trader("Greg","Fairfield");
        static Trader steve = new Trader("Steve", "New York");
        static Trader channing = new Trader("Channing","Milan");
        static Trader albert = new Trader("Albert","New York");
        static Trader doug = new Trader("Doug","Fairfield");
        
        static {
        	raoul.addAssociate(mario);
        	mario.addAssociate(raoul);
        	doug.addAssociate(albert);
        	albert.addAssociate(doug);
        	
        	tony.addAssociate(mario);
        	craig.addAssociate(raoul);
        	greg.addAssociate(albert);
        	steve.addAssociate(doug);
        	tony.addAssociate(craig);
        	tony.addAssociate(greg);
        	tony.addAssociate(steve);
        	craig.addAssociate(steve);
        	craig.addAssociate(greg);
        	
        	
        	mario.addAssociate(tony);
        	raoul.addAssociate(craig);
        	albert.addAssociate(greg);
        	doug.addAssociate(steve);
        	
        	craig.addAssociate(tony);
        	greg.addAssociate(tony);
        	steve.addAssociate(tony);
        	
        	steve.addAssociate(craig);
        	greg.addAssociate(craig);
        }
		
		static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950),
            new Transaction(doug, 2013, 300), 
            new Transaction(channing, 2012, 1050),
            new Transaction(albert, 2010, 1400),
            new Transaction(steve, 2012, 810),	
            new Transaction(tony, 2012, 700),
            new Transaction(tony, 2012, 1950),
            new Transaction(greg, 2014, 1300), 
            new Transaction(tomas, 2012, 11000),
            new Transaction(tony, 2013, 4100),
            new Transaction(greg, 2011, 1710),	
            new Transaction(craig, 2013, 1700),
            new Transaction(tomas, 2012, 940),
            new Transaction(craig, 2013, 350), 
            new Transaction(craig, 2012, 1200),
            new Transaction(raoul, 2011, 430),
            new Transaction(channing, 2012, 750),	
            new Transaction(albert, 2012, 1700),
            new Transaction(doug, 2013, 650)
        );	
		
		public static List<Transaction> getTransactions() {
			return transactions;
		}
		
		
        
        
        
}
