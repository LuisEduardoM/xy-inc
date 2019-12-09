package br.com.zup.xyinc.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.zup.xyinc.entidade.PontoInteresse;

public class PontoInteresseBuilder {

	public static PontoInteresse build() {
		return buildAll().get(0);
	}
	
	public static List<PontoInteresse> buildAll() {
		List<PontoInteresse> pontoInteresseList = new ArrayList<>();
		pontoInteresseList.add(new PontoInteresse("Lanchonete", 27, 12));
		pontoInteresseList.add(new PontoInteresse("Posto", 31, 18));
		pontoInteresseList.add(new PontoInteresse("Joalheria", 15, 12));
		pontoInteresseList.add(new PontoInteresse("Floricultura", 19, 21));
		pontoInteresseList.add(new PontoInteresse("Pub", 12, 8));
		pontoInteresseList.add(new PontoInteresse("Supermercado", 23, 6));
		pontoInteresseList.add(new PontoInteresse("Churrascaria", 28, 2));
		return pontoInteresseList;
	}
	
}
