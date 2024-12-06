package utility;

import com.github.javafaker.Faker;

public class RandomUtility {
	Faker faker = new Faker();

	public String createRandomProductNames() {
		return faker.commerce().productName();
	}

	public String createRandomNews() {
		return faker.gameOfThrones().character();
	}
	 
	public String createRandomUsername() {
		return faker.name().username();
	}
	
	public String createRandomPassword() {
		return faker.numerify("#####");
	}
}
