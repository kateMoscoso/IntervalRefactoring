package intervals;

public class BothOpened {
	public boolean includes(double value) {
		return minimum < value && value < maximum;
	}

}
