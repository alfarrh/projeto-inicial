//Alvaro Henrique Nunes de Lima - RA:2142520

import java.io.*;

public class Leitura{ 

	public String entDados(String rotulo){

		System.out.println(rotulo);

		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);

		String s ="";

		try{
			s = buff.readLine();
		}
		catch(IOException ioe){
			System.out.println("\nERRO de sistema");
		}

		return s;

	}
	
    public static void limpatela(){
		
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
		} catch (IOException | InterruptedException ex) {}
	}
	
}