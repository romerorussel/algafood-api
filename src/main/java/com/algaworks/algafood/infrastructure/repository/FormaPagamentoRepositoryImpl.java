package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public List<FormaPagamento> listar() {
		TypedQuery<FormaPagamento> typedQuery = manager.createQuery("from FormaPagamento", FormaPagamento.class);
		return typedQuery.getResultList();
	}

	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		manager.remove(buscar(id));
	}

}
