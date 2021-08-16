package contatos;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	    static Scanner sc = new Scanner(System.in);

		/**
	     *  Base de dados dos objetos de {@link Pessoa}.
	     */
	    public static ArrayList<Pessoa> alunos = new ArrayList<Pessoa>();
	    public static ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		
		public static void main(String[] args) {
	        boolean quiserContinuar = true;
			while (quiserContinuar) {
				imprimirMenu();
				int opcao = coletarOpcao();
				switch (opcao) {
				case 0:
					quiserContinuar = querExecutar();
					break;
				case 1: // adicionar pessoa
					alunos.add(adicionarContato());
					telefones.add(adicionaTelefone());
					break;
				case 2: // remover pessoa
					imprimirLista();
					opcao = coletarOpcao();
					alunos.remove(opcao);
					telefones.remove(opcao);
					break;
				case 3: // alterar pessoa
					imprimirLista();
					opcao = coletarOpcao();
					alterarContato(opcao);
					break;
				case 4: // recuperar pessoa
					recuperarContato();
					
					break;
				case 5: // imprimir lista
					imprimirLista();
					break;
				default:
					System.out.println("Escolha outra opção!");
					break;
				}
			}
			System.out.println("Obrigado por usar!");
			sc.close();
	    
	    }
	
	    




public static void imprimirMenu() {
	System.out.println("-----MENU-----");
	System.out.println("0: Se quiser iniciar o programa");
	System.out.println("1: Adcionar contato");
	System.out.println("2: Remover contato");
	System.out.println("3: Alterar contato");
	System.out.println("4: Recuperar contato");
	System.out.println("5: Imprimir lista");



}
private static int coletarOpcao() {
	System.out.print("\nDigite sua Opção: ");
	int opcao = Integer.parseInt(sc.nextLine());
	return opcao;
}

public static boolean querExecutar() {
	String r;
	System.out.println("Quer continuar com o processo? s/n");
	r = sc.nextLine();
	return r.toLowerCase().equals("sim") ? true : false;
	
}
	
	public static Pessoa adicionarContato() {
		String nome = nomeContato();
		String CPF = cpfContato();
		
		
		return new Pessoa(nome,CPF);
	}
	
	private static String nomeContato() {
		String nome;
		System.out.print("Digite o nome do contato: ");
		nome = sc.nextLine();
		return nome;
	}
	public static Telefone adicionaTelefone() {
		String DDD = dddContato();
		String numero = numeroContato();
		return new Telefone(DDD,numero);
	}
	
	private static String dddContato() {
		String DDD;
		System.out.print("Digite o ddd: ");
		DDD =sc.nextLine();
		return DDD;
	}
	
	private static String numeroContato() {
		String numero;
		System.out.print("Digite o numero do contato: ");
		numero = sc.nextLine();
		return numero;
	}
	
	private static String cpfContato() {
		String CPF;
		System.out.println("Digite o CPF do contato: ");
		CPF = sc.nextLine();
		return CPF;
	}	
	
	public static void alterarContato(int posicao) {
		System.out.print("Oque você deseja alterar (1)nome, (2)Cpf, (3)Telefone ou (4)Todas as opções? ");
		int opcao = coletarOpcao();
		Telefone mudado = telefones.get(posicao);
		Pessoa alterado = alunos.get(posicao);
		String novoNome;
		String novoCpf;
		String novoNumero;
		String novoDDD;
		switch (opcao) {
		case 1: // nome
			novoNome = nomeContato();
			alterado.setNome(novoNome);
			break;
		case 2: // nota
			novoCpf = cpfContato();
			alterado.setCpf(novoCpf);
			break;
		case 3: // telefone
			novoDDD = dddContato();
			novoNumero = numeroContato();
			mudado.setDDD(novoDDD);
			mudado.setNumero(novoNumero);
			break;
		case 4: //Todas as opcoes
			novoNome = nomeContato();
			novoCpf = cpfContato();
			novoDDD = dddContato();
			novoNumero =numeroContato();
			alterado.setNome(novoNome);
			alterado.setCpf(novoCpf);
			mudado.setNumero(novoNumero);
			mudado.setDDD(novoDDD);
			break;
		default:
			System.out.println("Opção invalida, tente novamente!");
			break;
		}
	}
	
	public static void recuperarContato() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nPor qual dado deseja pesquisar? \n");
		sb.append("1) nome\n");
		sb.append("2) CPF\n");
		sb.append("3) DDD\n");
		sb.append("4) numero\n");
		System.out.println(sb.toString());
			
		int dadoAPesquisar = coletarOpcao();
		if (alunos.isEmpty()) {
			 System.out.println("Lista Vazia!");
			}
		else {
			boolean encontrado = false;
				
			switch (dadoAPesquisar) {
				
			case 1: 
				String nomeAPesquisar = nomeContato();
				for (int i=0;i<alunos.size();i++) {					
					
					if (alunos.get(i).getNome().equals(nomeAPesquisar)) {						
						System.out.println("o nome digitado está na posição "+(i+1)+": ");
						System.out.println((i+1)+". Nome: "+alunos.get(i).getNome());
							
						encontrado=true;
					}
				}
				break;
					
			case 2: 
				String CPFAPesquisar = cpfContato();
				for (int i=0;i<alunos.size();i++) {					
					if (alunos.get(i).getCpf().equals(CPFAPesquisar)) {						
						System.out.println("o CPF digitado estÃ¡ na posiÃ§Ã£o "+(i+1)+": ");
						System.out.println((i+1)+". CPF: "+alunos.get(i).getCpf());
							
						encontrado=true;
					}
				}
				break;
					
			case 3: 
				String DDDAPesquisar = dddContato();
				for (int i = 0; i < telefones.size(); i++) {					
					if (telefones.get(i).getDDD() == DDDAPesquisar) {
						System.out.println("o DDD digitado está na posição "+(i+1)+": ");
						System.out.println((i+1) + ". DDD: "+telefones.get(i).getDDD());
							
						encontrado = true;
					}
				}
				break;
					
			case 4: 
				String numeroAPesquisar = numeroContato();
				for (int i=0;i<telefones.size();i++) {					
					if (telefones.get(i).getNumero().equals(numeroAPesquisar)) {						
						System.out.println("o numero digitado está na posição "+(i+1)+": ");
						System.out.println((i+1)+". Telefone: "+telefones.get(i).getNumero());
							
						encontrado=true;
						}
					}
					break;
					
				default:
					System.out.println("O dado informado é inválido");
					break;
				}
				if (encontrado==false) System.out.println("Dado não encontrado"); 
			}
			
		}
	private static void imprimirLista() {
		if (alunos.isEmpty())
			System.out.println("Sem contatos! :(");
		else {
			int pos = 0;

			for (Pessoa P : alunos ) {
				for(Telefone T : telefones) {
					System.out.println(pos + ". Nome: " + P.getNome() + " \nCpf:" + P.getCpf() + "\n numero " + "("+ T.getDDD() +") "+ T.getNumero());
					pos++;
				}
			}
		}
	}
		
}

