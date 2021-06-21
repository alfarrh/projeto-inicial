//Alvaro Henrique Nunes de Lima - RA:2142520

public class CadCabos{
	
	private static MenuInt menu1 = new MenuInt();
	private static MenuExt menu2 = new MenuExt();
	private static Leitura l = new Leitura();
			
	public static void main(String arg[]){
				
		l.entDados("\n\t\tCadastro dos cabos da empresa - <aperte enter>");
		
		boolean controle = true;	
		int opcao;
		
		do{	
		
			l.limpatela();
			
			System.out.println("===================================================");
			System.out.println("=                CADASTRO DE CABOS                =");
			System.out.println("===================================================");
			System.out.println("\n   [1] CADASTRO DE CABOS DE PECAS INTERNAS");
			System.out.println("   [2] CADASTRO DE CABOS DE TRANSMISSAO EXTERNA");
			System.out.println("   [3] SAIR DO PROGRAMA\n");
			
			try{
				opcao = Integer.parseInt(l.entDados("Entre com a opcao desejada: "));
			}
			catch(NumberFormatException nfe){
				l.entDados("\n\tOpcao invalida, utilize somente numeros. Aperte <Enter>\n");
				continue;
			}
		
			switch (opcao){
				
				case 1:
					l.limpatela();
					menu1.menu();
					
					break;
				case 2:
					l.limpatela();
					menu2.menu();
					
					break;
				case 3:
					l.limpatela();
					controle = false;
					
					break;
					
				default:
					l.entDados("\n\tOpcao invalida, tente novamente. Aperte <Enter>\n");
					
					break;	
								
			}
		}while(controle);
	}
}