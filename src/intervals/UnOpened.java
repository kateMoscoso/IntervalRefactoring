package intervals;

public class UnOpened {
	public boolean includes(double value) {
		return minimum <= value && value <= maximum;
	}
}
