package br.univel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ExemploProduto {

public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://www.master10.com.py/lista-txt/download");
		
		URLConnection urlCon = url.openConnection();		
		
		try(InputStream is = urlCon.getInputStream();
			
			InputStreamReader isr = new InputStreamReader(is);
			
		    BufferedReader in = new BufferedReader(isr)){
				
				String linha;
				
				while((linha = in.readLine()) != null) {
					System.out.println(linha);
			}		
		}
	}

}
