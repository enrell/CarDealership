package cardealership;

public class Person {
	private String name;
	private String cpf;
	private String address;
	private String phoneNumber;
	private int age;

	public Person(String name, String cpf, String address, String phoneNumber, int age) {
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getCPF() {
		return cpf;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public boolean isElderly() {
		final int ELDERLY_AGE_THRESHOLD = 60;
		return age >= ELDERLY_AGE_THRESHOLD;
	}
}
