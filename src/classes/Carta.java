package classes;

public class Carta {
	public int numero;
	public String naipe;
	public int forca;
	
	public Carta(int numero, String naipe, int forca) {
		this.numero = numero;
		this.naipe = naipe;
		this.forca = forca;
	}
	public int getNumero() {
		return numero;
	}
	public String getNaipe() {
		return naipe;
	}
	public int getForca() {
		return forca;
	}
}
