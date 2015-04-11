package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
		switch (opening) {
		case BOTH_OPENED:
			return new BothOpened(minimum, maximum);
		case LEFT_OPENED:
			return new LeftOpened(minimum, maximum);
		case RIGHT_OPENED:
			return new RightOpened(minimum, maximum);
		case UNOPENED:
			return new UnOpened(minimum, maximum);
		default:
			return null;
		}
	}
}
