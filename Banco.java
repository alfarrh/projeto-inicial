//Alvaro Henrique Nunes de Lima - RA:2142520

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Banco{ 

	private List<Interno> BDInterno = new ArrayList<Interno>();
	private List<Externo> BDExterno = new ArrayList<Externo>();
	
	private Leitura l = new Leitura();
		
	public List<Interno> getBDInterno(){
		return BDInterno;
	}
	public List<Externo> getBDExterno(){
		return BDExterno;
	}
	
// CADASTRO DE CABOS EXTERNOS===================================================================================================================

	public Externo cadCabos(Externo cabo){
		
		System.out.println("\nEntre com as especificacoes do cabo:\n");
		
		boolean b1 = true;
		
		do{
			try{
				cabo.setTransm(l.entDados("Transmissao: "));
				break;
			}
			catch(TmsException te){
				te.impTmsCabo();
				cabo = te.cnsTmsExt(cabo);
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nPermitido somente a entrada de numeros. Aperte <Enter>");
				continue;
			}
		}while(b1);
		
		do{
			try{
				cabo.setCompri(Double.parseDouble(l.entDados("Comprimento(metros): ")));
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nPermitido somente a entrada de numeros. Aperte <Enter>");
				continue;
			}
		}while(b1);
		
		cabo.setMaterial(l.entDados("Material: "));
		
		do{
			try{
				cabo.setDurab(Integer.parseInt(l.entDados("Durabilidade (meses): ")));
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nPermitido somente a entrada de numeros. Aperte <Enter>");
				continue;
			}
		}while(b1);
		
		cabo.setUso(l.entDados("Uso do cabo: "));
		cabo.getConector().setTipo(l.entDados("Tipo do conector: "));
		
		do{
			try{
				cabo.getConector().setTemp(Double.parseDouble(l.entDados("Temperatura de trabalho maxima (Celsius): ")));
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nPermitido somente a entrada de numeros. Aperte <Enter>");
				continue;
			}
		}while(b1);
			
		return cabo;
	}
	
	public void impLista(Externo cabo){
		
		System.out.println("<NUM>\tTIPO DE CABO\tCONECTOR\tDURABILIDADE\tTRANSMISSAO\n");
		for(int i = 0;i < BDExterno.size(); i++){
			cabo = BDExterno.get(i);
			if(cabo != null){
				System.out.println("<"+i+">\tCABO EXTERNO\t"+cabo.getConector().getTipo()+"\t\t"+cabo.getUso()+"\t\t"+cabo.getTransm());	
			}
		}
		System.out.println("");
		
	}
	public void impCabo(Externo cabo, int aux){
		
		if ((aux >= 0) && (aux < getBDExterno().size())){
			
			cabo = BDExterno.get(aux);
		
			System.out.println("\n=====================================");
			System.out.println("Transmissao.............................: "+ cabo.getTransm());
			System.out.println("Comprimento(metros).....................: "+ cabo.getCompri());
			System.out.println("Material................................: "+ cabo.getMaterial());
			System.out.println("Uso do cabo.............................: "+ cabo.getUso());
			System.out.println("Durabilidade(meses).....................: "+ cabo.getDurab());
			System.out.println("Tipo do conector........................: "+ cabo.getConector().getTipo());
			System.out.println("Temperatura de trabalho maxima (celsius): "+ cabo.getConector().getTemp());
			cabo.validaCabo();
			System.out.println("\n=====================================");
			
			l.entDados("\nAperte <Enter> para continuar.");
		}
		else{
			l.entDados("\nO numero indicado nao corresponde a um cabo. Aperte <Enter>");
		}	
	}
		
	public void altCabo(Externo cabo){
		
		for (int i=0;i<BDExterno.size();i++){
			if (BDExterno.get(i) == cabo){
				
				cabo = cadCabos(cabo);
				BDExterno.set(i,cabo);
			}
		}
	}
	
	public void delCabo(Externo cabo){
		
		for (int i=0;i<BDExterno.size();i++){
			if (BDExterno.get(i) == cabo){
				
				BDExterno.remove(cabo);
			}
		}
	}
	
//CADASTRO CABOS INTERNOS ===================================================================================================================

	public Interno cadCabos(Interno cabo){
		
		System.out.println("\nEntre com as especificacoes do cabo:\n");
		
		boolean b1 = true;
		
		do{
			try{
				cabo.setTransm(l.entDados("Transmissao: "));
				break;
			}
			catch(TmsException te){
				te.impTmsCabo();
				cabo = te.cnsTmsInt(cabo);
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nPermitido somente a entrada de numeros. Aperte <Enter>");
				continue;
			}
		}while(b1);
		
		do{
			try{
				cabo.setCompri(Double.parseDouble(l.entDados("Comprimento (metros): ")));
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nPermitido somente a entrada de numeros. Aperte <Enter>");
				continue;
			}
		}while(b1);
		
		cabo.setMaterial(l.entDados("Material: "));
		cabo.setDisp(l.entDados("Dipositivo: "));
		
		do{
			try{
				cabo.setAno(Integer.parseInt(l.entDados("Ano: ")));
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nPermitido somente a entrada de numeros. Aperte <Enter>");
				continue;
			}
		}while(b1);
		
		cabo.getConector().setTipo(l.entDados("Tipo do conector: "));
		
		do{
			try{
				cabo.getConector().setTemp(Double.parseDouble(l.entDados("Temperatura de trabalho máxima (Celsius): ")));
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nPermitido somente a entrada de numeros. Aperte <Enter>");
				continue;
			}
		}while(b1);
					
		return cabo;
	}
	
	public void impLista(Interno cabo){
		
		System.out.println("<NUM>\tTIPO DE CABO\tCONECTOR\tDISPOSITIVO\tTRANSMISSAO\n");
		for(int i = 0;i < BDInterno.size(); i++){
			cabo = BDInterno.get(i);
			if(cabo != null){
				System.out.println("<"+i+">\tCABO INTERNO\t"+cabo.getConector().getTipo()+"\t\t"+cabo.getDisp()+"\t\t"+cabo.getTransm());	
			}
		}
		System.out.println("");
		
	}
	public void impCabo(Interno cabo, int aux){
		
		if ((aux >= 0) && (aux < getBDInterno().size())){
			
			cabo = BDInterno.get(aux);
		
			System.out.println("\n=================================================");
			System.out.println("Transmissao.............................: "+ cabo.getTransm());
			System.out.println("Comprimento.............................: "+ cabo.getCompri());
			System.out.println("Material................................: "+ cabo.getMaterial());
			System.out.println("Dispositivo.............................: "+ cabo.getDisp());
			System.out.println("Ano.....................................: "+ cabo.getAno());
			System.out.println("Tipo do conector........................: "+ cabo.getConector().getTipo());
			System.out.println("Temperatura de trabálho máxima (Celsius): "+ cabo.getConector().getTemp());			
			cabo.validaCabo();
			System.out.println("\n=================================================");
			
			l.entDados("\nAperte <Enter> para continuar.");
		}
		else{
			l.entDados("\nO numero indicado nao corresponde a um cabo. Aperte <Enter>");
		}	
	}
		
	public void altCabo(Interno cabo){
		
		for (int i=0;i<BDInterno.size();i++){
			if (BDInterno.get(i) == cabo){
				
				cabo = cadCabos(cabo);
				BDInterno.set(i,cabo);
			}
		}
	}
	
	public void delCabo(Interno cabo){
		
		for (int i=0;i<BDInterno.size();i++){
			if (BDInterno.get(i) == cabo){
				
				BDInterno.remove(cabo);
			}
		}
	}
}