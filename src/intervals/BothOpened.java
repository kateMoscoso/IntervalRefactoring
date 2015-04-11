package intervals;

public class BothOpened extends Interval{

	private Opening opening;

	public BothOpened(double minimum, double maximum) {
		super(minimum, maximum);
		this.opening = Opening.BOTH_OPENED;
	}

	@Override
	public boolean includes(double value) {
		return this.getMinimum() < value && value < this.getMaximum();
	}
	public boolean includes(Interval interval) {
		switch (interval.getOpening()) {
		case BOTH_OPENED:
			return includes((BothOpened)interval);
		case LEFT_OPENED:
			return includes((LeftOpened)interval);
		case RIGHT_OPENED:
			return includes((RightOpened)interval);
		case UNOPENED:
			return includes((UnOpened)interval);
		default:
			assert false;
			return false;
		}
	}
	public boolean includes(BothOpened interval) {
		return (includes(interval.getMinimum()) || getMinimum() == interval.getMinimum())
				&& (includes(interval.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}
	public boolean includes(LeftOpened interval) {
		return (includes(interval.getMinimum()) || this.getMinimum() == interval.getMinimum())
				&& (includes(interval.getMaximum()));
	}
	public boolean includes(RightOpened interval) {
		return (includes(interval.getMinimum()))
				&& (includes(interval.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}
	public boolean includes(UnOpened interval) {
		return (includes(interval.getMinimum())) && includes(interval.getMaximum());
	}
	

	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum() == interval.getMaximum()) {
			return false;
		}
		if (this.getMaximum() == interval.getMinimum()) {
			return false;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

	@Override
	public Opening getOpening() {
		return opening;
	}
}
