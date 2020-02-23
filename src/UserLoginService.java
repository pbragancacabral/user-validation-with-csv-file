import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserLoginService {

	private User[] getUsers() {
		User[] users = new User[4];
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("data.txt");
			bufferedReader = new BufferedReader(fileReader);
			String line;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				users[i] = createUserFromString(line);
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return users;

	}

	private User createUserFromString(String line) {
		String[] user = line.split(",");
		String username = user[0];
		String password = user[1];
		String name = user[2];
		return new User(username, password, name);
	}
	
	public boolean isUserValid(String username, String password) {
		boolean isValid = false;
		User[] users = getUsers();
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && 
					user.getPassword().equalsIgnoreCase(password)) {
				isValid = true;
			}
		}
		return isValid;
	}

}