//Alvaro Henrique Nunes de Lima - RA:2142520

import java.io.*;

public final class Interno extends Cabo{
	
	private int ano;
	private String dispositivo;
	
	public Interno(){
		
		ano = 0;
		dispositivo = "";
	}
	public Interno(int ano, String dispositivo){
		
		this.ano = ano;
		this.dispositivo = dispositivo;
	}
	
	public int getAno(){
		return ano;		
	}
	public void setAno(int ano){
		this.ano = ano;		
	}
	
	public String getDisp(){
		return dispositivo;
	}
	public void setDisp(String dispositivo){
		this.dispositivo = dispositivo;
	}
}