package classes;
public class Jogador {
	int mao_jogador_um;
	int mao_jogador_dois;
	int vira;
	
	public Jogador(int mao_jogador_um, int mao_jogador_dois) {
		this.mao_jogador_um = mao_jogador_um;
		this.mao_jogador_dois = mao_jogador_dois;
	}
	public int getmao_JogadorUm() {
		return mao_jogador_um;
	}
	public int getmao_JogadorDois() {
		return mao_jogador_dois;
	}
}
