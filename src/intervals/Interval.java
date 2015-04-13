package intervals;

public abstract class Interval {

	private Punto minimum;
	private Punto maximum;

	public Interval(Punto minimum, Punto maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public abstract boolean includes(double value);

	public abstract boolean includes(Interval interval); 
	public abstract boolean includes(BothOpened interval);
	public abstract boolean includes(LeftOpened interval);
	public abstract boolean includes(RightOpened interval);
	public abstract boolean includes(UnOpened interval);

	public abstract boolean intersectsWith(Interval interval) ;

	@Override
	public String toString() {
		// TODO
		return null;
	}

	@Override
	public boolean equals(Object object) {
		// TODO
		return false;
	}
	public double midPoint() {
		return (maximum.getValor() + minimum.getValor()) / 2;
	}
	public double getMinimum() {
		return minimum.getValor();
	}

	public void setMinimum(Punto minimum) {
		this.minimum = minimum;
	}

	public double getMaximum() {
		return maximum.getValor();
	}

	public void setMaximum(Punto maximum) {
		this.maximum = maximum;
	}

	public abstract Opening getOpening();



}
