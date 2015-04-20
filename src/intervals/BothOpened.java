package intervals;

public class BothOpened extends Interval{

	private Opening opening;

	public BothOpened(Punto minimum, Punto maximum) {
		super(minimum, maximum);
		this.opening = Opening.BOTH_OPENED;
	}

	@Override
	public boolean includes(double value) {
		return this.getMinimum().getValor() < value && value < this.getMaximum().getValor();
	}
	public boolean includes(Interval interval) {
		return interval.includes(this);

	} 
	public boolean includes(BothOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) || this.getMinimum().equals(interval.getMinimum()))
				&& (interval.includes(this.getMaximum().getValor()) || this.getMaximum().equals(interval.getMaximum()));
	}
	public boolean includes(LeftOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) || this.getMinimum().equals(interval.getMinimum()))
				&& (interval.includes(this.getMaximum().getValor()));
	}
	public boolean includes(RightOpened interval) {
		return (interval.includes(this.getMinimum().getValor()))
				&& (interval.includes(this.getMaximum().getValor()) || this.getMaximum().equals(interval.getMaximum()));
	}
	public boolean includes(UnOpened interval) {
		return (interval.includes(this.getMinimum().getValor())) && interval.includes(this.getMaximum().getValor());
	}
	

	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum().equals(interval.getMaximum()) || this.getMaximum().equals(interval.getMinimum())) {
			return false;
		}
		return this.includes(interval.getMinimum().getValor())
				|| this.includes(interval.getMaximum().getValor());
	}

	@Override
	public Opening getOpening() {
		return this.opening;
	}
}
