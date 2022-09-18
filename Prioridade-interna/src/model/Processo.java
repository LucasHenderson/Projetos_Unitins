package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Processo {
	private Integer pid; // 1 - 50
	private Float at; // entre 0 e 1 com 6 casas decimais
	private Integer bt; // 1 - 35
	private Integer prioridadeInterna; // 0 - 5
	
	public Processo(Float at, Integer bt, Integer prioridadeInterna) {
		this.at = at;
		this.bt = bt;
		this.prioridadeInterna = prioridadeInterna;
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Float getAt() {
		return at;
	}
	public void setAt(Float at) {
		this.at = at;
	}
	public Integer getBt() {
		return bt;
	}
	public void setBt(Integer bt) {
		this.bt = bt;
	}
	public Integer getPrioridadeInterna() {
		return prioridadeInterna;
	}
	public void setPrioridadeInterna(Integer prioridadeInterna) {
		this.prioridadeInterna = prioridadeInterna;
	}

	@Override
	public String toString() {
		return "PID:" + pid + " | AT:" + at + " | BT:" + bt + " | PI:" + prioridadeInterna;
	}
	
	
	public static void incluirPid(List<Processo> lista) {
		Random numeroAleatorio = new Random();
		List<Integer> valoresPid = new ArrayList<Integer>();
		for(int i = 1; i < 51; i++) {
			valoresPid.add(i);
		} 
		
		for (Processo processo : lista) {
			processo.setPid(valoresPid.get(numeroAleatorio.nextInt(0,valoresPid.size())));
			valoresPid.remove(processo.getPid());
		}
	}
	
	public static Processo menorAt(List<Processo> lista) {
		Float menorAt = 2f;
		for (Processo processo : lista) {
			if(processo.getAt()<menorAt) {
				menorAt = processo.getAt();
			}
		}
		
		for (Processo processo : lista) {
			if(processo.getAt()==menorAt) {
				return processo;
			}
		}
		return null;
	}
	
	public static List<Processo> ordenarPrioridadeInterna(List<Processo> lista) {
		List<Processo> listaOrdenada = new ArrayList<Processo>();
		List<Processo> listaDeConjuntos = new ArrayList<Processo>();
		listaOrdenada.add(menorAt(lista));
		lista.remove(menorAt(lista));
		
		for (int i = 0; i <= 5; i++) {
			for (Processo processo : lista) {
				if(processo.getPrioridadeInterna()==i) {
					listaDeConjuntos.add(processo);
				}
			}
			
			while(listaDeConjuntos.size()!=0) {
				listaOrdenada.add(menorAt(listaDeConjuntos));
				listaDeConjuntos.remove(menorAt(listaDeConjuntos));
			}
		}
		return listaOrdenada;
	}	
}
