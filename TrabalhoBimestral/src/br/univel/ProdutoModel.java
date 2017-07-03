package br.univel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoModel extends AbstractTableModel {

	private List<Produto> lista;
	
	public ProdutoModel() throws Exception {
		String url = "http://www.master10.com.py/lista-txt/download";
		LeitorProdutoUrl lpu = new LeitorProdutoUrl();
		List<Produto> lista = lpu.lerProdutos(url);
		lista.forEach((e) ->
		//System.out.println(e.getDescricao()));
		System.out.println(e.toString()));		
	}
	
	@Override
	public int getColumnCount() {		
		return 4;
	}

	@Override
	public int getRowCount() {		
		return lista.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Codigo";
		case 1:
			return "Nome do Produto";
		case 2:
			return "Preço";
		}
		return "Campo invalido";
	}
	
	@Override
	public Object getValueAt(int row, int column) {	
		String url = "http://www.master10.com.py/lista-txt/download";
		return url;
	}

	public Produto getProduto(int idx) {
		// TODO Auto-generated method stub
		return null;
	}	
}


