package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.User;
import service.imp.UserService;
public class TestForSpring {
	public static void main()
	{
		String[] files = new String[]{"ApplicationContext.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(files);
		UserService userService = (UserService) context.getBean("userService");
		
		String username = "cece1";
		String pwd = "1";
		if (userService.validateUser(username, pwd))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
