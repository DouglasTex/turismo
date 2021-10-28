package com.estudo.turismo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.estudo.turismo.model.Atrativo;

public class DataT {

	
	public static void main(String[] args) {
		Scanner sc;
		try {
			sc = new Scanner(new File("C:\\Users\\Douglas Cardins\\Faculdade\\Spring\\Dados_atrativos.tsv"));
			sc.useDelimiter("	"); //sets the delimiter pattern
			
			List<Atrativo> atrativosList = new ArrayList<>();
			
			while (sc.hasNext()) {
				
				Atrativo atrativo = new Atrativo();
				
				atrativo.setNome(sc.next());
				atrativo.setCidade(sc.next());
				atrativo.setEstado(sc.next());
				atrativo.setTipo(sc.next());
				atrativo.setDescricao(sc.next());
				atrativo.setFonte(sc.next());
				
				atrativosList.add(atrativo);
				
				//Feito para pular as colunas não utilizadas no exemplo
				sc.next();
				sc.next();
				sc.next();
				sc.next();
				sc.next();
				sc.next();
				sc.next();
				sc.next();
				sc.next();
			}
			
			for (Atrativo atrativo : atrativosList) {
				//Atrativo atrativoSalvo = CrudRepository.save(atrativo);
				//System.out.println(atrativoSalvo.getCodigo());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Carregamento de atrativos pelo arquivo falhou: "+e.getMessage());
		}  
	}
	
}
