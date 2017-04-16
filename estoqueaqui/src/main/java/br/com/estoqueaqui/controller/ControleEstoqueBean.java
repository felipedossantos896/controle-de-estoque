package br.com.estoqueaqui.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estoqueaqui.model.Material;
import br.com.estoqueaqui.repository.Materiais;
import br.com.estoqueaqui.service.CadastroMaterialService;
import br.com.estoqueaqui.util.FacesMessages;

@Named
@ViewScoped
public class ControleEstoqueBean implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private List<Material> todosMateriais;
	private Material editarMaterial = new Material();
	
	@Inject
	private FacesMessages mensagens;
	
	@Inject
	private Materiais materiais;
	
	@Inject
	private CadastroMaterialService cadastroMaterialService;
	
	
	public void consultar(){
		todosMateriais = materiais.todas();
	}
	
	public void prepararCadastro(){
		editarMaterial = new Material();
	}
	
	public void salvar(){
		cadastroMaterialService.salvar(editarMaterial);
		consultar();
		
		mensagens.info("Material Salvo com Sucesso!");
	}
	
	// Getters e Setters
	
	public List<Material> getTodosMateriais() {
		return todosMateriais;
	}

	public Material getEditarMaterial() {
		return editarMaterial;
	}
	
	
	
}
