import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		UserLoginService userLoginService = new UserLoginService();
		int attempts = 0;
		int maxAttempts = 2;
		while (attempts < maxAttempts) {
			System.out.print("Username: ");
			String username = new Scanner(System.in).nextLine();
			System.out.print("Password: ");
			String password = new Scanner(System.in).nextLine();
			attempts++;
			if (userLoginService.isUserValid(username, password)) {
				System.out.println("Welcome " + username); // needs fix
			} else {
				if (attempts == maxAttempts) {
					System.out.println("Too many failed login attempts, you are now locked out.");
					System.exit(0);
				}
				System.out.println("Invalid login, please try again.");
			}
		}
	}
	
}