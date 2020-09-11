//SUNDAR RAJ
//CSC 236-62
//Lab 2-A
public class LockDataStructureClass implements LockADT
{
	private int x, y, z;
	private int top = 0;
	private boolean locked = true;

	public LockDataStructureClass()
	{
		this(0,0,0);
	}

	public LockDataStructureClass(int x, int y, int z)
	{
		setX(x);
		setY(y);
		setZ(z);
	}

	public LockDataStructureClass(LockDataStructureClass ldsc)
	{
		x = ldsc.x;
		y = ldsc.y;
		z = ldsc.z;
	}

	// Sets first combination number
	public void setX(int x)
	{
		this.x = x;
	}

	// Sets second combination number
	public void setY(int y)
	{
		this.y = y;
	}

	// Sets third combination number
	public void setZ(int z)
	{
		this.z = z;
	}

	// Sets values of all three combination numbers
	public void alter(int xAlt, int yAlt, int zAlt)
	{
		setX(xAlt);
		setY(yAlt);
		setZ(zAlt);
	}

	// Turns dial according to the three combination numbers
	public boolean turn(int xTurn, int yTurn, int zTurn)
	{
		boolean xLocked = true;
		boolean yLocked = true;
		boolean zLocked = true;

		System.out.print("\nFirst turn: ");
		int rotation = 0;
		for(int i = top; i >= 0; i--)
		{
			top = i;
			System.out.print(top + " ");

			if (i == 0)
			{
				i = 40 ;
				top = i;
				rotation++;
			}

			if (rotation > 1)
			{
				i = -1;
			}
		}

		for(int i = 39; i >= xTurn; i--)
		{
			top = i;
			System.out.print(top + " ");
			if(xTurn == top)
			{
				System.out.print("\n(" + current() + ")\n");
				if(x == top)
				{
					xLocked = false;
				}
			}
		}

		System.out.print("\nSecond turn: ");
		rotation = 0;
		if (yTurn >= top)
		{
			for(int i = top; i <= 39; i++)
			{
				top = i;
				System.out.print(top + " ");
			}

			for(int i = 0; i <= yTurn; i++)
			{
				top = i;
				System.out.print(top + " ");
				if(yTurn == top)
				{
 					System.out.print("\n(" + current() + ")\n");
 					if(y == top)
 					{
						yLocked = false;
					}
				}
			}
		}
		else // (yTurn < top)
		{
			for(int i = top; i <= 39; i++)
			{
				top = i;
				System.out.print(top + " ");
				if(i == 39 && rotation < 2)
				{
					i = 0;
					top = i;
					System.out.print(top + " ");
					rotation++;
				}
				if(rotation == 2)
				{
					for(i = 1; i <= yTurn; i++)
					{
						top = i;
						System.out.print(top + " ");
						if(yTurn == top)
						{
					 		System.out.print("\n(" + current() + ")\n");
					 		if(y == top)
					 		{
								yLocked = false;
							}
						}
					}
					i = 40;
				}
			}
		}

		System.out.print("\nThird turn: ");
		if(zTurn <= top)
		{
			for(int i = top; i >= zTurn; i--)
			{
				top = i;
				System.out.print(top + " ");
				if(zTurn == top)
				{
					System.out.print("\n(" + current() + ")\n");
					if(z == top)
					{
						zLocked = false;
					}
				}
			}
		}
		else // (zTurn > top)
		{
			for(int i = top; i >= 0; i--)
			{
				top = i;
				System.out.print(top + " ");
			}

			if(top == 0)
			{
				for(int i = 39; i >= zTurn; i--)
				{
					top = i;
					System.out.print(top + " ");
					if(zTurn == top)
					{
						System.out.print("\n(" + current() + ")\n");
						if(z == top)
						{
							zLocked = false;
						}
					}
				}
			}
		}

		if(xLocked == false && yLocked == false && zLocked == false)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	// Locks the lock
	public void close()
	{
		locked = true;
	}

	// Attempts to open the lock with user's combination numbers
	public void attempt(int xAtt, int yAtt, int zAtt)
	{
		boolean unlockAtt = turn(xAtt, yAtt, zAtt);

		if(unlockAtt == true)
		{
			locked = false;
			System.out.println(inquire());
		}

		else
		{
			locked = true;
			System.out.println(inquire());
		}
	}

	// Checks and returns the status of the lock
	public String inquire()
	{
		if(locked == true)
		{
			return "--Status: locked--";
		}

		else
		{
			return "--Status: unlocked--";
		}
	}

	// Returns the current number at the top of the dial
	public int current()
	{
		return top;
	}

	// Overriden toString() method
	public String toString()
	{
		return inquire() + "\nCurrent combination: " + x + "-" + y + "-" +
				z + "\n" + "Dial pointing at: " + current() + "\n";
	}
}