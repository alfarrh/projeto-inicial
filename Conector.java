//Alvaro Henrique Nunes de Lima - RA:2142520

import java.io.*;

public class Conector{
	
	private double temp;
	private String tipo;
	
	public Conector(){
		
		temp = 0;
		tipo = "";
	}
	public Conector(double temp, String tipo){
		
		this.temp = temp;
		this.tipo = tipo;
	}
	
	public double getTemp(){
		return temp;		
	}
	public void setTemp(double temp){
		this.temp = temp;		
	}
	
	public String getTipo(){
		return tipo;
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
}