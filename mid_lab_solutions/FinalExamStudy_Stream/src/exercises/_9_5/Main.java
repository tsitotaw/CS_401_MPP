package exercises._9_5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
	//Use IntSummaryStatistics to output the top test score,
	//the lowest test score, and the average of all test scores
	public static void main(String[] args) {
		List<ExamData> data = new ArrayList<ExamData>() {
			{
				add(new ExamData("George", 91.3));
				add(new ExamData("Tom", 88.9));
				add(new ExamData("Rick", 80));
				add(new ExamData("Harold", 90.8));
				add(new ExamData("Ignatius", 60.9));
				add(new ExamData("Anna", 77));
				add(new ExamData("Susan", 87.3));
				add(new ExamData("Phil", 99.1));
				add(new ExamData("Alex", 84));
			}
		};
		
		System.out.println("The Lowest Test Score is - "  + lowestTestScore(data));
		System.out.println("The Average Test Score is - "  + averageTestScore(data));
	}
	
	static Double lowestTestScore(List<ExamData> data) {
		DoubleSummaryStatistics summary = 
				data.stream()
				.collect(Collectors.summarizingDouble(ExamData::getTestScore));
		
		return summary.getMin();
	}
	static Double averageTestScore(List<ExamData> data) {
		DoubleSummaryStatistics summary = 
				data.stream()
				.collect(Collectors.summarizingDouble(ExamData::getTestScore));
		
		return summary.getAverage();
	}
}
