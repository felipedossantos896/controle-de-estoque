package br.com.estoqueaqui.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.estoqueaqui.model.Material;
import br.com.estoqueaqui.repository.Materiais;
import br.com.estoqueaqui.service.CadastroMaterialService;
import br.com.estoqueaqui.util.FacesMessages;

@Named
@ViewScoped
public class ControleEstoqueBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesMessages mensagens;

	@Inject
	private Materiais materiais;

	@Inject
	private CadastroMaterialService cadastroMaterialService;

	private List<Material> todosMateriais;
	private Material editarMaterial = new Material();
	private Material materialSelecionado;

	public void consultar() {
		todosMateriais = materiais.todas();
	}

	public void prepararCadastro() {
		editarMaterial = new Material();
	}

	public void salvar() {
		cadastroMaterialService.salvar(editarMaterial);
		consultar();

		mensagens.info("Material Salvo com Sucesso!");

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:tabela-materiais"));
	}
	
	public void excluir(){
		cadastroMaterialService.excluir(materialSelecionado);
		materialSelecionado = null;
		consultar();
		
		mensagens.info("Produto excluído com sucesso!");
	}

	public List<Material> getTodosMateriais() {
		return todosMateriais;
	}

	public Material getEditarMaterial() {
		return editarMaterial;
	}

	public void setEditarMaterial(Material editarMaterial) {
		this.editarMaterial = editarMaterial;
	}

	public Material getMaterialSelecionado() {
		return materialSelecionado;
	}

	public void setMaterialSelecionado(Material materialSelecionado) {
		this.materialSelecionado = materialSelecionado;
	}
	
}
