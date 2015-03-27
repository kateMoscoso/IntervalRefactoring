package intervals;

public class RightOpened {
	public boolean includes(double value) {
		return minimum <= value && value < maximum;
	}
}
