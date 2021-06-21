//Alvaro Henrique Nunes de Lima - RA:2142520

import java.io.*;

public class TmsException extends Exception{
	
	Leitura l = new Leitura();
	
	public void impTmsCabo(){
		
		System.out.println("\nOs tipos de transmissao validos sao dados e/ou energia");	
	}
	public Interno cnsTmsInt(Interno cab){
		
		try{
			cab.setTransm(l.entDados("Entre com a transmissao novamente: "));			
		}
		catch(TmsException te){
			te.impTmsCabo();
			cab = te.cnsTmsInt(cab);
		}
		
		return cab;
	}
	public Externo cnsTmsExt(Externo cab){
		
		try{
			cab.setTransm(l.entDados("Entre com a transmissao novamente: "));			
		}
		catch(TmsException te){
			te.impTmsCabo();
			cab = te.cnsTmsExt(cab);
		}
		
		return cab;
	}		
}