//Alvaro Henrique Nunes de Lima - RA:2142520

import java.io.*;

public final class Externo extends Cabo{
	
	private int durab;
	private String uso;
	
	public Externo(){
		
		durab = 0;
		uso = "";
	}
	public Externo(int durab, String uso){
		
		this.durab = durab;
		this.uso = uso;
	}
	
	public int getDurab(){
		return durab;		
	}
	public void setDurab(int durab){
		this.durab = durab;		
	}
	
	public String getUso(){
		return uso;
	}
	public void setUso(String uso){
		this.uso = uso;
	}
}