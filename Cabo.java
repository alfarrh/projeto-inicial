//Alvaro Henrique Nunes de Lima - RA:2142520

import java.io.*;

public abstract class Cabo implements CompCabo{
	
	private double comp;
	private String tms, mat;
	
	private Conector cnc = new Conector();
	
	public void validaCabo(){
		if(0 < comp)
			if (comp<1000)
				System.out.print("\t\nCabo valido registrado");
			else
				System.out.print("\t\nCabo invalido");
	}
	
	public Cabo(){
		comp = 0;
		tms = "";
		mat = "";
	}

	public Conector getConector(){
		return cnc;
	}
	public void setConector(Conector cnc){
		this.cnc = cnc;
	}
	
	public double getCompri(){
		return comp;
	}
	public void setCompri(double comp){
		this.comp = comp;
	}
	
	public String getTransm(){
		return tms;
	}
	public void setTransm (String tms) throws TmsException{
		tms = tms.toLowerCase();
		if(tms.equals("dados") || tms.equals("energia") || tms.equals("dados e energia") || tms.equals("energia e dados")){
			this.tms = tms;
		}
		else
			throw new TmsException();
	}
	
	public String getMaterial(){
		return mat;
	}
	public void setMaterial(String mat){
		this.mat = mat;
	}
}