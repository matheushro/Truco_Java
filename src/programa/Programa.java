package programa;
import java.util.Scanner;
import classes.Baralho;

public class Programa {

	public static void main(String[] args) {
		Integer iniciar;
		boolean jogador_inicio = true;
		Scanner scan = new Scanner(System.in);
		int carta_jogada_um = 0;
		int carta_jogada_dois = 0;
		int vencedor_turno = 0;
		Baralho carteado = new Baralho();
		int pontos_um = 0;
		int pontos_dois = 0;
	    int escolha = 0;
	    int pedido_truco = 0;
	    int fim_round = 0;
	    int pontuacao_um = 0;
	    int pontuacao_dois = 0;
	    int valor_rodada = 0;
	    int pediu_truco = 3;
	    //carteado.imprime_mao_dois();
	    //carteado.imprime_baralho();

	    do {
	    	iniciar = inicio();
	    	switch(iniciar) {
	    	case 1:
		    	do {	
		    		//inicio de cada rodada
		    		carteado.distribuir_mao();
		    		carteado.atribuir_forca();
		    		pontos_um = 0;
		    		pontos_dois = 0;
		    		carta_jogada_um = 0;
		    		carta_jogada_dois = 0;
		    		valor_rodada = 0;
		    		pedido_truco = 0;
		    		pediu_truco = 3;
		    		jogador_inicio = true;
		    		do {
		    			fim_round = 0;
		    			
		    			do {
		    				//inicio padrão de cada rodada
		    				StringBuilder sb = new StringBuilder();
		    				sb.append("===================================\n");
		    				sb.append("=======  PONTUAÇÃO ATUAL   ========\n");
		    				sb.append("===================================\n");
		    				sb.append("Pontuação jogador 1: " + pontuacao_um + "\n");
		    				sb.append("Pontuação jogador 2: " + pontuacao_dois);
		    				System.out.println(sb.toString());
		    				if(jogador_inicio) {
		    					//opcao de jogada
		    					carteado.imprime_mao_um();
			    				escolha = opc(pediu_truco, jogador_inicio);
			    				if(escolha == 0) {
			    					carta_jogada_um = jogar_carta();
			    					fim_round ++;
			    					jogador_inicio = false;
			    				}else if (escolha == 1) {
			    					System.out.println("JOGADOR 2 deseja aceitar?!\n");
			    					System.out.println("1 para aceitar e 0 para recusar!");
			    					pedido_truco = scan.nextInt();
			    					if(pedido_truco == 0) {
			    						fim_round = 5;
			    						pontos_um = 2;
			    					} else {
			    						carta_jogada_um = jogar_carta();
				    					fim_round ++;
				    					jogador_inicio = false;
				    					valor_rodada += 3;
				    					pediu_truco = 0;
			    					}
			    				}
		    				}
		    				//esse laço roda novamente dependendo das jogadas (assim ele joga novamente caso tenha pedido de truco, etc)
		    				else if(jogador_inicio == false) {
		    					//opcao de jogada
		    					carteado.imprime_mao_dois();
		    					escolha = opc(pediu_truco, jogador_inicio);
			    				if(escolha == 0) {
			    					carta_jogada_dois = jogar_carta();
			    					fim_round ++;
			    					jogador_inicio = true;
			    				}else if (escolha == 1) {
			    					System.out.println("JOGADOR 1 deseja aceitar?!\n");
			    					System.out.println("1 para aceitar e 0 para recusar!");
			    					pedido_truco = scan.nextInt();
			    					if(pedido_truco == 0) {
			    						fim_round = 5;
			    						pontos_dois = 2;
			    					} else {
			    						carta_jogada_dois = jogar_carta();
				    					fim_round++;
				    					jogador_inicio = true;
				    					valor_rodada += 3;
				    					pediu_truco = 1;
			    					}
			    				}
		    				}
		    			//determina quem venceu após checar a força das cartas
		    			}while(fim_round < 2);
		    			if(carta_jogada_um != 0 && carta_jogada_dois != 0) {
		    				vencedor_turno = carteado.comparar_forca(carta_jogada_um, carta_jogada_dois);
		    			}
		    			if(vencedor_turno == 0) {
			    			System.out.println("JOGADOR 1 VENCEU!");
			    			pontos_um++;
			    			jogador_inicio = true;
			    		}else if(vencedor_turno == 1){
			    			System.out.println("JOGADOR 2 VENCEU!");
			    			pontos_dois++;
			    			jogador_inicio = false;
			    		} else {
			    			System.out.println("EMPATE!");
			    			pontos_um++;
			    			pontos_dois++;
			    		}	
		    		}while(pontos_um < 2 && pontos_dois < 2);
		    		//determina quem venceu após checar a pontuação de cada jogador e quantos pontos vai ganhar(dependendo do pedido de truco)
		    		if(pontos_um > pontos_dois) {
		    			if(pedido_truco == 0) {
		    				System.out.println("PARABÉNS, JOGADOR 1 VENCEU A RODADA!");
		    				pontuacao_um++;
		    			} else {
		    				System.out.println("PARABÉNS, JOGADOR 1 VENCEU A RODADA!");
		    				pontuacao_um += valor_rodada;
		    			}
		    			
		    		}else {
		    			if(pedido_truco == 0) {
		    				System.out.println("PARABÉNS, JOGADOR 2 VENCEU A RODADA!");
		    				pontuacao_dois++;
		    			} else {
		    				System.out.println("PARABÉNS, JOGADOR 2 VENCEU A RODADA!");
		    				pontuacao_dois += valor_rodada;
		    			}
		    		}	
		    	}while(pontuacao_um <12 && pontuacao_dois <12);
		    	//checa a pontuação de cada jogador, quem chegar a 12 primeiro vence
		    	if(pontos_um > pontos_dois) {
	    			System.out.println("PARABÉNS, JOGADOR 1 VENCEU A PARTIDA!");
	    		}else {
	    			System.out.println("PARABÉNS, JOGADOR 2 VENCEU A PARTIDA!");
	    		}
	    	break;
	    	default: 
	    		System.out.println("Finalizando a aplicação...");
				System.exit(0);
	    	break;
	    	}
	    }while(iniciar != 0);
	}
	
	//pro jogador atual jogar uma carta, após isso o main envia ambas as cartas para comparar no sistema e determinar o vencedor
	public static int jogar_carta() {
		int carta_jogada = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Escolha uma carta para jogar: ");
		carta_jogada = scan.nextInt();
		return carta_jogada;
	}
	
	//opcao inicial se joga ou nao
	public static Integer inicio() {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("===================================\n");
		sb.append("============  TRUCO   =============\n");
		sb.append("===================================\n");
		sb.append("Digite 1 para jogar  \n");
		sb.append("Digite 0 para sair  \n");
		System.out.println(sb.toString());
		Integer iniciar = scan.nextInt();;
		return iniciar;
	}
	
	//checa quem pede truco
	public static int opc(int pediu_truco, boolean jogador_inicio) {
		if(pediu_truco == 0 && jogador_inicio) {
			return 0;
		} else if(pediu_truco == 1 && !jogador_inicio) {
			return 0;
		}else {
			Scanner scan = new Scanner(System.in);
			StringBuilder sb = new StringBuilder();
			sb.append("Digite 1 para pedir truco  \n");
			sb.append("Digite 0 para jogar  \n");
			System.out.println(sb.toString());
			Integer opc = scan.nextInt();
			return opc;
		}
	}
}
