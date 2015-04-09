package intervals;

public class LeftOpened extends Interval{
	public LeftOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
		// TODO Auto-generated constructor stub
	}

	public boolean includes(double value) {
		return this.getMinimum() < value && value <= this.getMaximum();
	}
	public boolean includes(Interval interval) {
		return interval.includes(this);
	}
	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum() == interval.getMaximum()) {
			return false;
		}
		if (this.getMaximum() == interval.getMinimum()) {
			return interval.getOpening() == Opening.RIGHT_OPENED ||
					interval.getOpening() == Opening.UNOPENED;

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
				&& (this.includes(leftOpenedInterval.getMaximum())|| this.getMaximum() == leftOpenedInterval.getMaximum());
	}

	@Override
	public boolean includes(RightOpened rightOpenedInterval) {
		return (this.includes(rightOpenedInterval.getMinimum()))
				&& (this.includes(rightOpenedInterval.getMaximum()) || this.getMaximum() == rightOpenedInterval.getMaximum());
	}

	@Override
	public boolean includes(UnOpened unOpenedInterval) {
		return (this.includes(unOpenedInterval.getMinimum()))
				&& (this.includes(unOpenedInterval.getMaximum()) || this.getMaximum() == unOpenedInterval.getMaximum());
	}
}
