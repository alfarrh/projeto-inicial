//Alvaro Henrique Nunes de Lima - RA:2142520

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class MenuInt{ 

	private Banco bd = new Banco();
	private Interno cabo = new Interno();
	private Leitura l = new Leitura();

	public void menu(){
		
		int opcao;
		int aux = 0;
		
		boolean controle = true;
		
		do{
			boolean b1 = true;
			
			System.out.println("=========================================================");
			System.out.println("=          CADASTRO DE CABOS DE PECAS INTERNAS          =");
			System.out.println("=========================================================");
			System.out.println("\n   [1] CADASTRAR CABOS");
			System.out.println("   [2] EXIBIR TODOS OS CABOS CADASTRADOS");
			System.out.println("   [3] EXIBIR DETALHES DO CABO POR NUMERO DO REGISTRO");
			System.out.println("   [4] ALTERAR CABO POR NUMERO DO REGISTRO");
			System.out.println("   [5] REMOVER CABO POR NUMERO DO REGISTRO");
			System.out.println("   [6] SAIR PARA MENU PRINCIPAL\n");
			
			try{
				opcao = Integer.parseInt(l.entDados("Entre com a opcao desejada: "));
			}
			catch(NumberFormatException nfe){
				l.entDados("\nOpcao invalida, utilize somente numeros. Aperte <Enter>\n");
				l.limpatela();
				continue;
			}
			
			switch (opcao){
//==============================================================================================================================================				
				case 1:
					l.limpatela();
					System.out.println("\tCADASTRO DE CABOS");
					
					cabo = new Interno();
					
					cabo = bd.cadCabos(cabo);
					
					bd.getBDInterno().add(cabo);
					
					l.entDados("\nCadastro feito com sucesso! Aperte <Enter>");
					l.limpatela();
					
				break;
//==============================================================================================================================================
				case 2:
					l.limpatela();
					System.out.println("\t\t\tLISTA DE CABOS CADASTRADOS\n");
										
					bd.impLista(cabo);
					
					cabo = new Interno();
					
					do{
						try{
							aux = Integer.parseInt(l.entDados("Deseja selecionar algum cabo especifico?\n[1]Sim\t\t[2]Nao"));
						}
						catch(NumberFormatException nfe){
							l.entDados("Opcao invalida, utilize somente numeros. Aperte <Enter>");
							continue;
						}
						switch (aux){
						
							case 1:
								int j;
								
								try{
									j = Integer.parseInt(l.entDados("\nEntre com o numero de registro do cabo: "));
								}
								catch(NumberFormatException nfe){
									l.entDados("\nOpcao invalida, utilize somente numeros. Aperte <Enter>");
									continue;
								}
								
								bd.impCabo(cabo, j);
								
							break;
							
							case 2:
								System.out.println("");
								b1 = false;
								
							break;
							default:
							
								l.entDados("\nOpcao invalida, tente novamente. Aperte <Enter>");
							
							break;
						}
					}while(b1);
					
					l.limpatela();
					
				break;
//==============================================================================================================================================					
				case 3:
					l.limpatela();
					
					cabo = new Interno();
					
					bd.impLista(cabo);
					System.out.println("\t===========================================");
					System.out.println("\t           EXIBIR REGISTRO DE CABO\n");					
					
					do{
						try{
							aux = Integer.parseInt(l.entDados("Entre com o numero do registro desejado: "));
							break;
						}
						catch(NumberFormatException nfe){
							l.entDados("\nOpcao invalida, utilize somente numeros. Aperte <Enter>");
							continue;
						}
					}while(b1);
					
					bd.impCabo(cabo, aux);
					
					l.limpatela();
					
				break;
//==============================================================================================================================================					
				case 4:
					l.limpatela();
					
					bd.impLista(cabo);
					System.out.println("\t===========================================");
					System.out.println("\t           ALTERAR REGISTRO DE CABO\n");
										
					do{
						try{
							aux = Integer.parseInt(l.entDados("\nEntre com o numero do registro desejado: "));
							break;
						}
						catch(NumberFormatException nfe){
							l.entDados("\nOpcao invalida, utilize somente numeros. Aperte <Enter>");
							continue;
						}
					}while(b1);
					
					if((aux >= 0) && (aux < bd.getBDInterno().size())){
						bd.altCabo(bd.getBDInterno().get(aux));
						l.entDados("\nAlterado com sucesso. Aperte <Enter>");
					}
					else{
						l.entDados("\nO numero indicado nao corresponde a um cabo. Aperte <Enter>");
					}
					l.limpatela();
					
				break;
//==============================================================================================================================================					
				case 5:
					l.limpatela();
					
					bd.impLista(cabo);
					System.out.println("\t===========================================");
					System.out.println("\t           EXCLUIR REGISTRO DE CABO\n");
					
					cabo = new Interno();
					
					do{
						try{
							aux = Integer.parseInt(l.entDados("\nEntre com o numero do registro desejado: "));
							break;
						}
						catch(NumberFormatException nfe){
							l.entDados("\nOpcao invalida, utilize somente numeros. Aperte <Enter>");
							continue;
						}
					}while(b1);
					
					if((aux >= 0) && (aux < bd.getBDInterno().size())){
						bd.delCabo(bd.getBDInterno().get(aux));
						l.entDados("\nDeletado com sucesso. Aperte <Enter>");
					}
					else{
						l.entDados("\nO numero indicado nao corresponde a um cabo. Aperte <Enter>");
					}
					
					l.limpatela();
					
				break;
//==============================================================================================================================================					
				case 6:
					controle = false;
					
				break;
//==============================================================================================================================================					
				default:
					l.entDados("\nOpcao invalida, tente novamente. Aperte <Enter>\n");
					l.limpatela();
					
				break;	
								
			}
			
		}while(controle);
		
	}


}