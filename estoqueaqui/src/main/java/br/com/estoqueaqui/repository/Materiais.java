package br.com.estoqueaqui.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.estoqueaqui.model.Material;

public class Materiais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Material porId(Long id) {
		return manager.find(Material.class, id);
	}

	public List<Material> todas() {
		return manager.createQuery("from Material", Material.class).getResultList();
	}

	public Material guardar(Material material) {
		return manager.merge(material);
	}

	public void remover(Material material) {
		material = porId(material.getId());
		manager.remove(material);
	}
}
