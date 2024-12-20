package utility;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

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

	public String createRandomPhoneNumber() {
		String format = "+91 ##########";
		return faker.numerify(format);
	}

	public String createRandomEmail() {
		return faker.internet().emailAddress();
	}

	public String createRandomAddress() {
		return faker.address().fullAddress();
	}

	public int createRandomAmount() {
		return faker.number().numberBetween(50, 200);
	}
	
	public int createRandomTime() {
		return faker.number().numberBetween(7, 20);
		
	}

}
