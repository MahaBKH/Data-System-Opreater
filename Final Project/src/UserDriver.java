
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;

public class UserDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Array list for the rows in the file 
		ArrayList<String> rows = new ArrayList<>();
		//Array list for adding rows in the file 
		ArrayList<User> users = new ArrayList<>();
		String userInput = "";
		String name;
		String password;
		
		//FILE ANALYSIS
		Scanner fileReader;
		Scanner keyboard = new Scanner (System.in);
		File file= new File("/Users/Maha/eclipse-workspace/Final Project/src/information.csv");
		try {
		fileReader = new Scanner(file);
		while(fileReader.hasNextLine())
			rows.add(fileReader.nextLine());
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		for (String row : rows) {
			users.add(createUser(row));
		}
		//END FILE ANALYSIS
		
		//MENU LOOP
		while (true) {
			System.out.println("A. view user info (needs password)\n" + 
					"B. view anonymous info \n"+
					"C. Create user\n" + 
					"D. Quit" );
			userInput = keyboard.nextLine();
			if (userInput.equalsIgnoreCase("A")) {
				boolean userFound = false;
				System.out.println("Enter first name: ");
				name = keyboard.nextLine();
				System.out.println("Enter password: ");
				password = keyboard.nextLine();
				for (User user : users) {
					if (user.getFirstname().equals(name) && user.getPassword().equals(password)) {
						System.out.println(user.toString());
						userFound = true;
						break;
					}
					if (!userFound) System.out.println("Username or password incorrect.");
				}
			}
			else if (userInput.equalsIgnoreCase("B")) {
				for (User user : users) {
					System.out.println(user.publicInfo());
				}
			}
			else if (userInput.equalsIgnoreCase("C")) {
				User u = createUser(keyboard);
				users.add(u);
				System.out.println("User added successfully.");
			}
			else if (userInput.equalsIgnoreCase("D")) {
				break;
			}
		}

		
		
		System.out.println("Program closed");
		
		//overwrite the original file
		file.delete();
		file= new File("/Users/Maha/eclipse-workspace/Final Project/src/information.csv");
		
		String userInfo = "";
		for (User user : users) {
			userInfo += user.toString() + "\n";
		}
		
		try {
		    FileWriter f2 = new FileWriter(file, false);
		    f2.write(userInfo);
		    f2.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}     
		
		
		}

	//User method that allows the user to enter their info
	public static User createUser(Scanner keyboard) {
		System.out.println("Enter you first name: ");
		String firstname  = keyboard.nextLine();
		System.out.println("Enter your last name: ");
		String lastname =keyboard.nextLine();
		System.out.println("Enter your race: ");
		String race = keyboard.nextLine();
		System.out.println("Enter your job: ");
		String job = keyboard.nextLine();
		System.out.println("Enter your password: ");
		String password = keyboard.nextLine();
		System.out.println("Enter your age: ");
		int age = keyboard.nextInt();
		User newUser = new User(firstname, lastname, age, race, job, password);
		return newUser;
	
	}
	// Create a User from a string, so we can add new users to arrylist from the file.
	public static User createUser(String line) {
		String [] data = line.split(",");
		User newUser = new User(data[0], data[1], Integer.parseInt(data[3]), data[4], data[5], data[2]);
		return newUser;
	}

}
