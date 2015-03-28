package intervals;

public class BothOpened {
	private double minimum;
	private double maximum;
	private Opening opening;
	public boolean includes(double value) {
		return minimum < value && value < maximum;
	}
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);
		return (minimumIncluded || minimum == interval.minimum)
				&& (maximumIncluded || maximum == interval.maximum);
	}

}
