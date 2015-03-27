package intervals;

public class LeftOpened {
	public boolean includes(double value) {
		return minimum < value && value <= maximum;
	}
}
