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
		return (includes(bothOpenedInterval.getMinimum()) || this.getMinimum() == bothOpenedInterval.getMinimum())
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
		return (includes(unOpenedInterval.getMinimum())) && (includes(unOpenedInterval.getMaximum()));
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
