package classes;
public class Baralho {
	int quantidade = 40;
	int jogador_um[];
	int mao = 3;
	int vira = 0;//manilha
	Carta[] cartas = new Carta[quantidade];
	Jogador[] jogadores = new Jogador[mao];
	
	//laço pra criar todas as cartas
	public Baralho() {
		int numero[] = { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
		String naipe[] = {"Paus", "Copas", "Espadas", "Ouro"};
		int contador = 0;
		int forca = 0;
		for(int numero_cartas = 0; numero_cartas < 10; numero_cartas++) {
			forca++;
			for(int numero_naipes = 0; numero_naipes < 4; numero_naipes++) {
				cartas[contador] = new Carta(numero[numero_cartas], naipe[numero_naipes], forca);//cria uma carta com valor, naipe e força
				contador++;
			}
		}
	}
	
	//pra imprimir o baralho completo com numero, naipe e força (utilizo apenas para testes)
	public void imprime_baralho() {
		for(int imprimir = 0; imprimir < quantidade; imprimir++) {
			System.out.print(cartas[imprimir].getNumero() + " ");
			System.out.print(cartas[imprimir].getNaipe() + " ");
			System.out.println("Força da carta: " + cartas[imprimir].getForca());
		}
	}
	
	//distribui a mão para cada jogador
	public void distribuir_mao() {
		int cartas_utilizadas_um[] = {70, 70, 70};
		int cartas_utilizadas_dois[] = {70, 70, 70};
		int mao_jogador_um[] = {0, 0, 0};
		int mao_jogador_dois[] = {0, 0, 0};
		boolean checa_vira = false;
		boolean carta_utilizada = false;
		for(int i = 0; i < 3; i++) {//laço 1 divide carta pros 2 jogadores sem repetir
			carta_utilizada = false;
			mao_jogador_um[i] = (int)(Math.random() * quantidade);
			mao_jogador_dois[i] = (int)(Math.random() * quantidade);
			for(int controle_mao = 0; controle_mao < 3; controle_mao++) {
				if(cartas_utilizadas_um[controle_mao] == mao_jogador_um[i] || cartas_utilizadas_dois[controle_mao] == mao_jogador_dois[i] || cartas_utilizadas_um[controle_mao] == mao_jogador_dois[i] || cartas_utilizadas_dois[controle_mao] == mao_jogador_um[i]) {
					carta_utilizada = true;
				}
			}
			if(carta_utilizada == false) {
				jogadores[i] = new Jogador(mao_jogador_um[i], mao_jogador_dois[i]);
				cartas_utilizadas_um[i] = mao_jogador_um[i];
				cartas_utilizadas_dois[i] = mao_jogador_dois[i];
			}
			else{
				i--;
			}	
		}
		do{//laço 2 vira uma manilha sem repetir as cartas dos jogadores
			vira = (int)(Math.random() * quantidade);
			for(int controle_mao = 0; controle_mao < 3; controle_mao++) {
				if(cartas_utilizadas_um[controle_mao] == vira || cartas_utilizadas_dois[controle_mao] == vira) {
					checa_vira = false;
				}else {
					checa_vira = true;
				}
			}
		}while(checa_vira == false);
	}

	//imprime a mao do jogador 1
	public void imprime_mao_um() {
		int carta_atual = 0;
		int carta_mao[] = {0, 0, 0};
		for(int pos_carta = 0; pos_carta < mao; pos_carta++) {
			carta_mao[pos_carta] = jogadores[pos_carta].getmao_JogadorUm();
		}
		System.out.println("VIRA: " + cartas[vira].getNumero() + " " + cartas[vira].getNaipe());
		System.out.println("MÃO DO JOGADOR 1:");
		for(int imprimir = 0; imprimir < mao; imprimir++) {
			carta_atual = carta_mao[imprimir];
			if(cartas[carta_atual].getNumero() == cartas[vira].getNumero() && cartas[carta_atual].getNaipe() == cartas[vira].getNaipe()) {
				
			}else {
				System.out.print((imprimir+1) + " - " + cartas[carta_atual].getNumero() + " ");
				System.out.print(cartas[carta_atual].getNaipe() + " ");
				System.out.println("\n");
			}
		}
	}
	
	//imprime a mao do jogador 2
	public void imprime_mao_dois() {
		int carta_atual = 0;
		int carta_mao[] = {0, 0, 0};
		for(int pos_carta = 0; pos_carta < mao; pos_carta++) {
			carta_mao[pos_carta] = jogadores[pos_carta].getmao_JogadorDois();
		}
		System.out.println("VIRA: " + cartas[vira].getNumero() + " " + cartas[vira].getNaipe());
		System.out.println("MÃO DO JOGADOR 2:");
		for(int imprimir = 0; imprimir < mao; imprimir++) {
			carta_atual = carta_mao[imprimir];
			if(cartas[carta_atual].getNumero() == cartas[vira].getNumero() && cartas[carta_atual].getNaipe() == cartas[vira].getNaipe()) {
				
			}else {
				System.out.print((imprimir+1) + " - " + cartas[carta_atual].getNumero() + " ");
				System.out.print(cartas[carta_atual].getNaipe() + " ");
				System.out.println("\n");
			}
		}
	}
	//atribui a foça de cada carta após o vira
	public void atribuir_forca() {//muda a força das cartas manilhas após o vira
		int contador = cartas[vira].getNumero();
		contador++;
		for(int i = 0; i < 40; i++){
			if(cartas[i].getNumero() == contador) {
				if(cartas[i].getNaipe() == "Pau") {
					cartas[i] = new Carta(cartas[i].getNumero(), cartas[i].getNaipe(), 14);
				} else if(cartas[i].getNaipe() == "Copas") {
					cartas[i] = new Carta(cartas[i].getNumero(), cartas[i].getNaipe(), 13);
				}else if(cartas[i].getNaipe() == "Espada") {
					cartas[i] = new Carta(cartas[i].getNumero(), cartas[i].getNaipe(), 12);
				}else if(cartas[i].getNaipe() == "Ouro") {
					cartas[i] = new Carta(cartas[i].getNumero(), cartas[i].getNaipe(), 11);
				}
			}
		}
	}

	//função que compara a força e envia o vencedor
	public int comparar_forca(int carta_mao_um, int carta_mao_dois) {
		int vencedor = 0;
		int carta_um = jogadores[carta_mao_um - 1].getmao_JogadorUm();
		int carta_dois = jogadores[carta_mao_dois - 1].getmao_JogadorDois();
		//atualiza o valor da carta jogada (objeto) para a função "mostrar_mao" não mostrar a carta ja usada (ainda não sei como deletar o objeto para não ser utilizado)
		jogadores[carta_mao_um - 1] = new Jogador(vira, jogadores[carta_mao_um - 1].getmao_JogadorDois());
		jogadores[carta_mao_dois - 1] = new Jogador(jogadores[carta_mao_dois - 1].getmao_JogadorUm(), vira);
		if(carta_mao_um == 0) {
			vencedor = 1;
			return vencedor;
		}else if(carta_mao_dois == 0) {
			vencedor = 0;
			return vencedor;
		}
		if(cartas[carta_um].getForca() > cartas[carta_dois].getForca()) {
			vencedor = 0;
			return vencedor;
		}else if(cartas[carta_um].getForca() < cartas[carta_dois].getForca()){
			vencedor = 1;
			return vencedor;
		}else {
			vencedor = 2;
			return vencedor;
		}
	}
}