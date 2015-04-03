package intervals;

public class LeftOpened extends Interval{
	public LeftOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
		// TODO Auto-generated constructor stub
	}

	public boolean includes(double value) {
		return this.getMinimum() < value && value <= this.getMaximum();
	}
}
