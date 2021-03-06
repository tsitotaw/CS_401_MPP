package streampractices;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataAccessFacade {

	static List<Author> authors = Arrays.asList(new Author("Peter Smith", new Address("Fairfield", "Iowa", "52557")),
			new Author("Addis Kidan", new Address("Fairfield", "Iowa", "52556")),
			new Author("Golgota Terara", new Address("Fairfield", "Iowa", "52554")),
			new Author("Gospel Song", new Address("Fairfield", "Iowa", "52557")),
			new Author("Endet Endiyadin", new Address("Fairfield", "Iowa", "52556")));

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains7());
	}

	public static List<Author> allWhoseZipContains7() {
		return authors.stream().filter(author -> author.getAddress().getZip().contains("7"))
				.collect(Collectors.toList());
	}

}

class Author {
	private String name;
	private Address address;

	public Author(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", address=" + address + "]";
	}

}

class Address {
	private String city;
	private String country;
	private String zip;

	public Address(String city, String country, String zip) {
		super();
		this.city = city;
		this.country = country;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", zip=" + zip + "]";
	}

}
