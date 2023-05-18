package cardealership;

import java.util.Scanner;

public class CustomerService {
	private PriorityQueue salesQueue;
	private PriorityQueue mechanicQueue;
	private PriorityQueue accessoriesQueue;
	private int ticketNumber;

	public CustomerService() {
		this.salesQueue = new PriorityQueue();
		this.mechanicQueue = new PriorityQueue();
		this.accessoriesQueue = new PriorityQueue();
		this.ticketNumber = 1;
	}

	public void addCustomerToQueue(Person person, String queueType) {
		switch (queueType) {
			case "Sales":
				salesQueue.enqueue(person, ticketNumber);
				break;
			case "Mechanic":
				mechanicQueue.enqueue(person, ticketNumber);
				break;
			case "Accessories":
				accessoriesQueue.enqueue(person, ticketNumber);
				break;
			default:
				System.out.println("Invalid queue type.");
				break;
		}
		ticketNumber++;
	}

	public void callNextCustomer(String employeeName, String queueType) {
		PriorityQueue queue;
		switch (queueType) {
			case "Sales":
				queue = salesQueue;
				break;
			case "Mechanic":
				queue = mechanicQueue;
				break;
			case "Accessories":
				queue = accessoriesQueue;
				break;
			default:
				System.out.println("Invalid queue type.");
				return;
		}

		if (queue.isEmpty()) {
			System.out.println("No customer in the queue.");
		} else {
			Person nextCustomer = queue.dequeue();
			System.out.println("Employee " + employeeName + " is now serving the next customer:");
			System.out.println("Queue Type: " + queueType);
			System.out.println("Customer Name: " + nextCustomer.getName());
			System.out.println("Ticket Number: " + (ticketNumber - queue.size()));
		}
	}

	public void displayQueueSize(String queueType) {
		PriorityQueue queue;
		switch (queueType) {
		case "Sales":
				queue = salesQueue;
				break;
		case "Mechanic":
				queue = mechanicQueue;
				break;
		case "Accessories":
				queue = accessoriesQueue;
				break;
			default:
				System.out.println("Invalid queue type.");
				return;
		}

		System.out.println("Queue Type: " + queueType);
		queue.displayQueueSize();
	}

	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Add customer to queue");
			System.out.println("2. Call next customer");
			System.out.println("3. Display queue size");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:
					System.out.print("Enter customer name: ");
					String name = scanner.nextLine();
					System.out.print("Enter customer CPF: ");
					String cpf = scanner.nextLine();
					System.out.print("Enter customer address: ");
					String address = scanner.nextLine();
					System.out.print("Enter customer phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter customer age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.println("Select queue type: ");
                    System.out.println("1. Sales");
                    System.out.println("2. Mechanic");
                    System.out.println("3. Accessories");
                    System.out.print("Enter your choice: ");
                    int queueChoice = scanner.nextInt();
                    	scanner.nextLine(); // Consume the newline character

                    	String queueType;
                    	switch (queueChoice) {
                    	case 1:
                    		queueType = "Sales";
                    		break;
                    	case 2:
                    		queueType = "Mechanic";
                    		break;
                    	case 3:
                    		queueType = "Accessories";
                    		break;
                    	default:
                    		System.out.println("Invalid queue type. Customer not added.");
                    		continue;
                    	}

                    	Person person = new Person(name, cpf, address, phoneNumber, age);
                    	customerService.addCustomerToQueue(person, queueType);
                    	System.out.println("Customer added to the " + queueType + " queue.");
                    	break;

				case 2:
						System.out.println("Select queue type: ");
						System.out.println("1. Sales");
						System.out.println("2. Mechanic");
						System.out.println("3. Accessories");
						System.out.print("Enter your choice: ");
						int callChoice = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character

						String callQueueType;
						switch (callChoice) {
						case 1:
							callQueueType = "Sales";
							break;
						case 2:
							callQueueType = "Mechanic";
							break;
						case 3:
							callQueueType = "Accessories";
							break;
						default:
							System.out.println("Invalid queue type.");
							continue;
						}

						System.out.print("Enter employee name: ");
						String employeeName = scanner.nextLine();
						customerService.callNextCustomer(employeeName, callQueueType);
						break;

				case 3:
					System.out.println("Select queue type: ");
					System.out.println("1. Sales");
					System.out.println("2. Mechanic");
					System.out.println("3. Accessories");
					System.out.print("Enter your choice: ");
					int displayChoice = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character

					String displayQueueType;
						switch (displayChoice) {
						case 1:
							displayQueueType = "Sales";
							break;
						case 2:
							displayQueueType = "Mechanic";
							break;
						case 3:
							displayQueueType = "Accessories";
							break;
						default:
							System.out.println("Invalid queue type.");
							continue;
						}

						customerService.displayQueueSize(displayQueueType);
						break;

				case 4:
						System.out.println("Exiting program...");
						scanner.close();
						System.exit(0);
						break;

				default:
						System.out.println("Invalid choice. Please try again.");
						break;
			}

			System.out.println();
		}
	}}
