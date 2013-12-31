import com.myereputation.manager.UserManager;
import com.myereputation.persistence.model.User;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserManager manager = new UserManager();
		User user = new User();
		user.setPremium(true);
		user.setIdUser(1);
		
		manager.deleteUser(user);

	}

}
