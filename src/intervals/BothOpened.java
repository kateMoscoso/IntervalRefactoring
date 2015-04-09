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
			return false;
		}
	public boolean includes(BothOpened bothOpenedInterval) {
		boolean minimumIncluded = this.includes(bothOpenedInterval.getMinimum());
		boolean maximumIncluded = this.includes(bothOpenedInterval.getMaximum());
		return (minimumIncluded || this.getMinimum() == bothOpenedInterval.getMinimum())
				&& (maximumIncluded || this.getMaximum() == bothOpenedInterval.getMaximum());
	}
	public boolean includes(LeftOpened leftOpenedInterval) {
		boolean minimumIncluded = this.includes(leftOpenedInterval.getMinimum());
		boolean maximumIncluded = this.includes(leftOpenedInterval.getMaximum());
		return (minimumIncluded || this.getMinimum() == leftOpenedInterval.getMinimum())
				&& (maximumIncluded);
	}
	public boolean includes(RightOpened rightOpenedInterval) {
		boolean minimumIncluded = this.includes(rightOpenedInterval.getMinimum());
		boolean maximumIncluded = this.includes(rightOpenedInterval.getMaximum());
		return (minimumIncluded)
				&& (maximumIncluded || this.getMaximum() == rightOpenedInterval.getMaximum());
	}
	public boolean includes(UnOpened unOpenedInterval) {
		boolean minimumIncluded = this.includes(unOpenedInterval.getMinimum());
		boolean maximumIncluded = this.includes(unOpenedInterval.getMaximum());
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
