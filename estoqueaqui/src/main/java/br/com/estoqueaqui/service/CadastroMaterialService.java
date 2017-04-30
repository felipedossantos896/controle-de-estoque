package br.com.estoqueaqui.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.estoqueaqui.model.Material;
import br.com.estoqueaqui.repository.Materiais;
import br.com.estoqueaqui.util.Transacional;

public class CadastroMaterialService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Materiais materiais;
	
	@Transacional
	public void salvar(Material material){
		materiais.guardar(material);	
	}
	
	@Transacional
	public void excluir(Material material){
		materiais.remover(material);
	}
	
}
