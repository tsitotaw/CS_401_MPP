package exceptions_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		System.out.println(InitialStreamClass1.scale(Arrays.asList(189,562,376,874,85), 4));
		System.out.println(InnerExceptionHandlingClass2.scale(Arrays.asList(189,562,376,874,85), 4));
		System.out.println(AuxillaryMethodExceptionHandlingClass3.scale(Arrays.asList(189,562,376,874,85), 4));
		System.out.println(BestAndFinalClass4.scale(Arrays.asList(189,562,376,874,85), 4));
	}
	
	

}
