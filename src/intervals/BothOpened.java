package intervals;

public class BothOpened extends Interval{



	public BothOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	@Override
	public boolean includes(double value) {
		return this.getMinimum() < value && value < this.getMaximum();
	}
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.getMaximum());
		switch (interval.getOpening()) {
		case BOTH_OPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
		case LEFT_OPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded);
		case RIGHT_OPENED:
			return (minimumIncluded)
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
		case UNOPENED:
			return interval.includes(this);
//			return (minimumIncluded) && (maximumIncluded);
		default:
			assert false;
			return false;
		}
	}
	public boolean includes(BothOpened bothOpenedInterval) {
		return (includes(bothOpenedInterval.getMinimum()) || getMinimum() == bothOpenedInterval.getMinimum())
				&& (includes(bothOpenedInterval.getMaximum()) || this.getMaximum() == bothOpenedInterval.getMaximum());
	}
	public boolean includes(LeftOpened leftOpenedInterval) {
		return (includes(leftOpenedInterval.getMinimum()) || this.getMinimum() == leftOpenedInterval.getMinimum())
				&& (includes(leftOpenedInterval.getMaximum()));
	}
	public boolean includes(RightOpened rightOpenedInterval) {
		return (includes(rightOpenedInterval.getMinimum()))
				&& (includes(rightOpenedInterval.getMaximum()) || this.getMaximum() == rightOpenedInterval.getMaximum());
	}
	public boolean includes(UnOpened unOpenedInterval) {
		boolean minimumIncluded = includes(unOpenedInterval.getMinimum());
		boolean maximumIncluded = includes(unOpenedInterval.getMaximum());
		return (minimumIncluded) && (maximumIncluded);
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
}
