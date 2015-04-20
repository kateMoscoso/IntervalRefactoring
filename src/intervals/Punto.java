package intervals;

public class Punto {
	private double valor;
	
	public Punto (double valor){
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
/*	public boolean isEqualsValue(double value){
		return this.getValor() == value;
	}
	*/
	public boolean equals(Punto punto){
		return this.getValor() == punto.getValor();
	}
	public boolean isLessThan(double value){
		return this.getValor() < value;
	}

	public boolean isGreaterThan(double value) {
		// TODO Auto-generated method stub
		return this.getValor()> value;
	}

	public boolean isLessThanOrEquals(double value) {
		return this.getValor() <= value;
	}
	public boolean isGreaterThanOrEquals(double value) {
		return this.getValor() >= value;
	}
	


}
