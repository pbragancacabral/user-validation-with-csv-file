public class UserLoginApplication {

	private static UserLoginService userLoginService = new UserLoginService();
	private static UserInterface userInterface = new UserInterface();
	
	private static int MAX_ATTEMPTS = 5;
	
	public static void main(String[] args) {
		int attempts = 0;
		
		while (attempts < MAX_ATTEMPTS) {
			String username = userInterface.promptUsername();
			String password = userInterface.promptPassword();
			attempts++;
			
			if (userLoginService.isUserValid(username, password)) {
				welcome(username);
			} else {
				if (attempts == MAX_ATTEMPTS) {
					userInterface.displayMessage("Too many failed login attempts, you are now locked out.");
					System.exit(0);
				}
				userInterface.displayMessage("Invalid login, please try again.");
			}
		}
	}

	private static void welcome(String username) {
		User user;
		try {
			user = userLoginService.getUser(username);
			userInterface.displayWelcomeMessageTo(user);
		} catch (Exception e) {
			userInterface.displayMessage(e.getMessage());
		}
	}
	
}