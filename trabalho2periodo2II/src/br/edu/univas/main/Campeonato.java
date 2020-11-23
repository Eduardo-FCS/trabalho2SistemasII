package br.edu.univas.main;

import java.util.Scanner;

public class Campeonato {

	public static int limiteVetor = 50;
	public static int limiteJogos = 100;
	public static int limitePlacar = 200;
	public static int vitorias[] = new int[limiteVetor];
	public static int empates[] = new int[limiteVetor];
	public static int derrotas[] = new int[limiteVetor];
	public static int golsMandante[] = new int[limiteVetor];
	public static int golsVisitante[] = new int[limiteVetor];
	public static int count = 0;
	public static int x = 0;
	public static int y = 0;
	public static int golsPartida[] = new int[limitePlacar];
	public static String timesPartida[] = new String[limitePlacar];

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String timesCadastrados[] = new String[limiteVetor];
		String estadosCadastrados[] = new String[limiteVetor];
		int index[] = new int[limiteVetor];

		int escolhas = 0;

		while (escolhas != 9) {
			menu();
			escolhas = scanner.nextInt();
			if (escolhas == 1) {
				cadastro(timesCadastrados, estadosCadastrados, index);
			} else if (escolhas == 2) {
				editar(timesCadastrados, estadosCadastrados, index);
			} else if (escolhas == 3) {
				excluirTime(timesCadastrados, estadosCadastrados, index);
			} else if (escolhas == 4) {
				jogoCadastrar(timesCadastrados, estadosCadastrados, index);
			} else if (escolhas == 5) {
				editarJogo();
			} else if (escolhas == 6) {
				excluirJogo();
			} else if (escolhas == 7) {
				listarClassificacao(timesCadastrados);
			} else if (escolhas == 9) {
				System.out.println("Obrigado por utilizar o meu programa !");
			}
		}

	}

	public static void menu() {

		System.out.println("===========================================" + "\n" + "\n" + " CAMPEONATO DE FUTEBOL" + "\n"
				+ "\n" + "Selecione uma das opções abaixo:" + "\n");
		System.out.println("1- Cadastrar Time" + "\n" + "2- Editar Time" + "\n" + "3- Excluir Time" + "\n"
				+ "4- Cadastrar jogo" + "\n" + "5- Editar jogo" + "\n" + "6- Excluir jogo" + "\n"
				+ "7- Listar Classificação do Campeonato" + "\n" + "9- Sair" + "\n");

	}

	public static void cadastro(String timeCadastrados[], String estadosCadastrados[], int index[]) {
		// código da primeira opção do Campeonato
		timeCadastrar(timeCadastrados);
		estadoCadastrar(estadosCadastrados);
		index[count] = 2;
		System.out.println("\n" + "O time " + timeCadastrados[count] + " situado em " + estadosCadastrados[count]
				+ " foi registrado com sucesso !");
		count++;

		System.out.println(count);
	}

	public static void timeCadastrar(String timeCadastrados[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("\n" + "Digite abaixo o nome do time: ");
		String nomeTime = scanner.nextLine();
		timeCadastrados[count] = nomeTime;

	}

	public static void editar(String timesCadastrados[], String estadosCadastrados[], int index[]) {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Selecione abaixo, de acordo com a posição de cadastro, o time que deseja editar: " + "\n"
				+ "Exemplo = 1");

		for (int i = 0;; i++) {

			if (index[i] == 0) {
				break;
			}

			// Repetição para exibição dos times já cadastrados.
			int posicao = i + 1;
			System.out.println((posicao) + " - " + timesCadastrados[i] + "(" + estadosCadastrados[i] + ")");

		}

		// código da segunda opção do Campeonato
		int edicao = leitor.nextInt();
		int indice = edicao - 1;
		timeEditar(timesCadastrados, indice);
		estadoEditar(estadosCadastrados, indice);
	}

	public static void estadoCadastrar(String estadosCadastrados[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do Estado referente ao time:");
		String nomeEstado = scanner.nextLine();
		estadosCadastrados[count] = nomeEstado;

	}

	public static void timeEditar(String timeCadastrados[], int edicao) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("\n" + "Digite abaixo o nome do time: ");
		String nomeTime = scanner.nextLine();
		timeCadastrados[edicao] = nomeTime;

	}

	public static void estadoEditar(String estadosCadastrados[], int edicao) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do Estado referente ao time:");
		String nomeEstado = scanner.nextLine();
		estadosCadastrados[edicao] = nomeEstado;

	}

	public static void menuLooping() {

		System.out.println("\n" + "==================================================" + "\n" + "\n"
				+ " CAMPEONATO DE FUTEBOL" + "\n" + "\n" + "Selecione, novamente, uma das opções abaixo:" + "\n");
		System.out.println("1- Cadastrar Time" + "\n" + "2- Editar Time" + "\n" + "3- Excluir Time" + "\n"
				+ "4- Cadastrar jogo" + "\n" + "5- Editar jogo" + "\n" + "6- Excluir jogo" + "\n"
				+ "7- Listar Classificação do Campeonato" + "\n" + "9- Sair" + "\n");

	}

	public static void excluirTime(String timesCadastrados[], String estadosCadastrados[], int index[]) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite abaixo o time que deseja excluir: " + "\n");

		for (int i = 0;; i++) {

			if (index[i] == 0) {
				break;
			}

			// Repetição para exibição dos times já cadastrados.
			int posicao = i + 1;
			System.out.println((posicao) + " - " + timesCadastrados[i] + "(" + estadosCadastrados[i] + ")");

		}

		int choose = leitor.nextInt();

		for (int i = 0; i < limiteVetor; i++) {
			int h = i + 1;
			if (choose == h) {
				timesCadastrados[i] = "";
				estadosCadastrados[i] = "";
				index[i] = 1;
				break;
			}
		}

		System.out.println("O time escolhido foi excluído !");

	}

	public static void jogoCadastrar(String timesCadastrados[], String estadosCadastrados[], int index[]) {
		Scanner leitor = new Scanner(System.in);

		for (int i = 0; i < limitePlacar; i++) {
			golsPartida[i] = -1;
		}

		for (int i = 0;; i++) {

			if (index[i] == 0) {
				break;
			}

			// Repetição para exibição dos times já cadastrados.
			int posicao = i + 1;
			System.out.println((posicao) + " - " + timesCadastrados[i] + "(" + estadosCadastrados[i] + ")");

		}

		System.out.println("Selecione acima o time que será o mandante: ");
		int mandante = leitor.nextInt();
		int mandanteArray = mandante - 1;
		timesPartida[y] = timesCadastrados[mandanteArray];
		y++;
		System.out.println("Selecione acima o time que será o visitante: ");
		int visitante = leitor.nextInt();
		int visitanteArray = visitante - 1;
		timesPartida[y] = timesCadastrados[visitanteArray];
		y++;

		System.out.println("Selecione o número de gols realizado pelo mandante:");
		int golsCasa = leitor.nextInt();
		golsMandante[mandanteArray] = golsCasa;
		golsPartida[x] = golsCasa;
		x++;
		System.out.println("Selecione o número de gols realizado pelo visitante:");
		int golsFora = leitor.nextInt();
		golsVisitante[mandanteArray] = golsFora;
		golsPartida[x] = golsFora;
		x++;

		if (golsCasa > golsFora) {
			vitorias[mandanteArray] += 1;
			derrotas[visitanteArray] += 1;
			System.out.println("O time " + timesCadastrados[mandanteArray] + " ganhou de "
					+ timesCadastrados[visitanteArray] + " por " + golsCasa + " x " + golsFora);
		} else if (golsCasa < golsFora) {
			vitorias[visitanteArray] += 1;
			derrotas[mandanteArray] += 1;
			System.out.println("O time " + timesCadastrados[visitanteArray] + " ganhou de "
					+ timesCadastrados[mandanteArray] + " por " + golsFora + " x " + golsCasa);
		} else {
			empates[mandanteArray] += 1;
			empates[visitanteArray] += 1;
			System.out.println("O time " + timesCadastrados[mandanteArray] + " empatou com "
					+ timesCadastrados[visitanteArray] + " por " + golsCasa + " x " + golsFora);

		}

	}

	public static void editarJogo() {
		Scanner leitor = new Scanner(System.in);
		for (int i = 0;; i++) {
			int h = i++;
			if (golsPartida[i] == -1) {
				break;
			}

			// Repetição para exibição dos times já cadastrados.
			System.out.println(
					(i) + ") " + timesPartida[h] + " " + golsPartida[h] + "x" + golsPartida[i] + " " + timesPartida[i]);
		}

		System.out.println("Digite abaixo a sentença com a partida que deseja-se alterar: ");
		int decisao = leitor.nextInt();

		for (int i = 0;; i++) {
			int h = i - 1;
			if (decisao == i) {
				System.out.println("Digite abaixo o nome do mandante que deseja alterar: ");
				leitor = new Scanner(System.in);
				String timeMandanteEditar = leitor.nextLine();
				timesPartida[h] = timeMandanteEditar;

				System.out.println("Digite abaixo o nome do visitante que deseja alterar: ");
				leitor = new Scanner(System.in);
				String timeVisitanteEditar = leitor.nextLine();
				timesPartida[i] = timeVisitanteEditar;

				System.out.println("Digite abaixo a quantidade de gols que o mandante marcou: ");
				leitor = new Scanner(System.in);
				int golsMandanteEdit = leitor.nextInt();
				golsPartida[h] = golsMandanteEdit;

				System.out.println("Digite abaixo a quantidade de gols que o visitante marcou: ");
				leitor = new Scanner(System.in);
				int golsVisitanteEdit = leitor.nextInt();
				golsPartida[i] = golsVisitanteEdit;

				break;
			}
		}

		System.out.println("Edição concluída com sucesso !");

	}

	public static void excluirJogo() {
		Scanner leitor = new Scanner(System.in);
		for (int i = 0;; i++) {
			int h = i++;
			if (timesPartida[i] == null) {
				break;
			}

			// Repetição para exibição dos times já cadastrados.
			System.out.println(
					(i) + ") " + timesPartida[h] + " " + golsPartida[h] + "x" + golsPartida[i] + " " + timesPartida[i]);
		}

		System.out.println("Digite abaixo a sentença com a partida que deseja-se excluir: ");
		int decisao = leitor.nextInt();

		for (int i = 0;; i++) {
			int h = i - 1;
			if (decisao == i) {
				timesPartida[h] = "";
				timesPartida[i] = "";
				golsPartida[h] = -1;
				golsPartida[i] = -1;
				break;
			}
		}
		System.out.println("Partida excluída com sucesso !");
	}

	public static void listarClassificacao(String timeCadastrados[]) {
		int classificacao[] = new int[limiteVetor];

		for (int i = 0; i < limiteVetor; i++) {

			classificacao[i] = vitorias[i] * 3 + empates[i] * 1 + derrotas[i] * 0;

		}

		int aux = 0, aux2 = 0;
		int nomes[] = new int[limiteVetor];
		for (int i = 0; i < limiteVetor; i++) {
			for (int j = 0; j < limiteVetor - 1; j++) {
				if (classificacao[j] < classificacao[j + 1]) {
					aux = classificacao[j];
					aux2 = j;
					nomes[j] = j + 1;
					nomes[j + 1] = aux2;
					classificacao[j] = classificacao[j + 1];
					classificacao[j + 1] = aux;
				}
			}
		}
		int saldoGols[] = new int[limiteVetor];
		for (int j = 0; j < limiteVetor; j++) {
			if (golsMandante[j] > golsVisitante[j]) {
				saldoGols[j] = golsMandante[j] - golsVisitante[j];
			} else if (golsVisitante[j] > golsMandante[j]) {
				saldoGols[j] = golsVisitante[j] - golsMandante[j];
			} else
				saldoGols[j] = 0;
		}
		for (int i = 0; i < limiteVetor; i++) {

			if (classificacao[i] > 0) {
				System.out.println(timeCadastrados[nomes[i]] + " - " + classificacao[i] + " pontos - " + saldoGols[i] + " gols" );
			}
		}

	}
}
