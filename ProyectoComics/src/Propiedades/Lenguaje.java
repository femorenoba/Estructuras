package Propiedades;

import Comic.Tomo;

public class Lenguaje {
	
	private String lenguaje;
	private Tomo[] tomos;
	
	public Lenguaje(String lenguaje, Tomo[] tomos) {
		super();
		this.lenguaje = lenguaje;
		this.tomos = tomos;
	}

	protected String getLenguaje() {
		return lenguaje;
	}

	protected void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	protected Tomo[] getTomos() {
		return tomos;
	}

	protected void setTomos(Tomo[] tomos) {
		this.tomos = tomos;
	}
	
}
