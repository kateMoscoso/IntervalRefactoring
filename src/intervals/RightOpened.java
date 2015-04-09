package intervals;

public class RightOpened extends Interval {
	public RightOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
		// TODO Auto-generated constructor stub
	}

	public boolean includes(double value) {
		return this.getMinimum() <= value && value < this.getMaximum();
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
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
		case UNOPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded);
		default:
			assert false;
			return false;
		}
	}
	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum() == interval.getMaximum()) {
			return interval.getOpening() == Opening.LEFT_OPENED ||
					interval.getOpening() == Opening.UNOPENED;
		}
		if (this.getMaximum() == interval.getMinimum()) {
			return false;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

	@Override
	public boolean includes(BothOpened bothOpenedInterval) {
		return (this.includes(bothOpenedInterval.getMinimum()) || this.getMinimum() == bothOpenedInterval.getMinimum())
				&& (this.includes(bothOpenedInterval.getMaximum()) || this.getMaximum() == bothOpenedInterval.getMaximum());
	}

	@Override
	public boolean includes(LeftOpened leftOpenedInterval) {
		return (this.includes(leftOpenedInterval.getMinimum()) || this.getMinimum() == leftOpenedInterval.getMinimum())
				&& (this.includes(leftOpenedInterval.getMaximum()));
	}

	@Override
	public boolean includes(RightOpened rightOpenedInterval) {
		return (this.includes(rightOpenedInterval.getMinimum()) || this.getMinimum() == rightOpenedInterval.getMinimum())
				&& (this.includes(rightOpenedInterval.getMaximum()) || this.getMaximum() == rightOpenedInterval.getMaximum());
	}

	@Override
	public boolean includes(UnOpened unOpenedInterval) {
		return (this.includes(unOpenedInterval.getMinimum()) || this.getMinimum() == unOpenedInterval.getMinimum())
				&& (this.includes(unOpenedInterval.getMaximum()));
	}
}


