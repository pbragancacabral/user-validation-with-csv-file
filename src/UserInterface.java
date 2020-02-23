import java.util.Scanner;

public class UserInterface {
	
	private Scanner scanner = new Scanner(System.in);

	public String promptUsername() {
		System.out.print("Username: ");
		return scanner.nextLine();
	}

	public String promptPassword() {
		System.out.print("Password: ");
		return scanner.nextLine();
	}

	public void displayWelcomeMessageTo(User user) {
		System.out.println("Welcome " + user.getName());
	}

	public void displayMessage(String message) {
		System.out.println(message);
	}

}