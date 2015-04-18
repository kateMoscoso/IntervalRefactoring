package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
		switch (opening) {
		case BOTH_OPENED:
			return new BothOpened(new OpenPoint(minimum), new OpenPoint(maximum));
		case LEFT_OPENED:
			return new LeftOpened(new OpenPoint(minimum), new ClosePoint(maximum));
		case RIGHT_OPENED:
			return new RightOpened(new ClosePoint(minimum), new OpenPoint(maximum));
		case UNOPENED:
			return new UnOpened(new ClosePoint(minimum), new ClosePoint(maximum));
		default:
			return null;
		}
	}
}
