package prob3;

import java.util.List;

//DO NOT MODIFY METHOD SIGNATURE OR STATIC QUALIFIER
public class FindOldestPerson {
	public static Person findOldestPerson(List<Person> persons) {
		// implement
		return persons.stream()
				.reduce(
						persons.get(0), (x, y) -> 
						(x.getAge() < y.getAge()) ? y : x
								);
	}

}
