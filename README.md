# LockADT
//SUNDAR RAJ

public interface LockADT
{
	// Sets values of all three combination numbers
	public abstract void alter(int x, int y, int z);

	// Turns dial according to the three combination numbers
	public abstract boolean turn(int x, int y, int z);

	// Locks the lock
	public abstract void close();

	// Attempts to open the lock with user's combination numbers
	public abstract void attempt(int x, int y, int z);

	// Checks and returns the status of the lock
	public abstract String inquire();

	// Returns the current number at the top of the dial
	public abstract int current();
}
