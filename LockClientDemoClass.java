//SUNDAR RAJ
import java.util.Scanner;

public class LockClientDemoClass
{
	public static void main(String[] args)
	{
		LockDataStructureClass lock = new LockDataStructureClass();

		Scanner keyboard = new Scanner(System.in);
		int input = 0;

		while(input != 6)
		{
			System.out.println("Choose a number from the menu below:");
			System.out.println(	"1- Set lock combination\n" +
								"2- Close lock\n" +
								"3- Check status\n" +
								"4- Attempt to open lock\n" +
								"5- Check what the dial is currently pointing at\n" +
								"6- Exit program\n");
			input = keyboard.nextInt();

			if(input == 1)
			{
				System.out.println("---Set lock combination---");
				System.out.print("First number: ");
				int x = keyboard.nextInt();
				System.out.print("Second number: ");
				int y = keyboard.nextInt();
				System.out.print("Third number: ");
				int z = keyboard.nextInt();

				lock.alter(x, y, z);
			}
			else if(input == 2)
			{
				System.out.println("---Close lock---");
				lock.close();
				System.out.println("Done");
			}
			else if(input == 3)
			{
				System.out.println("---Check status---");
				System.out.println(lock);
			}
			else if(input == 4)
			{
				System.out.println("---Attempt to open lock---");
				System.out.print("Enter the first number: ");
				int xAttempt = keyboard.nextInt();
				System.out.print("Enter the second number: ");
				int yAttempt = keyboard.nextInt();
				System.out.print("Enter the third number: ");
				int zAttempt = keyboard.nextInt();

				lock.attempt(xAttempt, yAttempt, zAttempt);
			}
			else if(input == 5)
			{
				System.out.println("---Check what the dial is currently pointing at---");
				System.out.print("Currently pointing at: " + lock.current());
			}
			else if(input == 6)
			{
				System.out.println("---Program exited---");
				System.exit(0);
			}

			System.out.println();
		}
	}
}