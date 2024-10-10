package com.coleta.monetiza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.PessoaJuridica;
import com.coleta.monetiza.repository.PessoaFisicaRepository;

@Service
public class PessoaJuridicaService<PessoaJuridicaRepository> extends AbstractService<PessoaJuridica> {
	private PessoaJuridicaRepository repository;

	public PessoaJuridicaService(PessoaJuridicaRepository repository) {
		super();
	}
	
	@Autowired
	public void setRepository(PessoaJuridicaRepository repository) {
		this.repository = repository;
	}
	
	public PessoaJuridicaRepository getRepository() {
		return repository;
	}

    public void setRepository(PessoaFisicaRepository repository) {
        this.repository = repository;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((repository == null) ? 0 : repository.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PessoaJuridicaService other = (PessoaJuridicaService) obj;
        if (repository == null) {
            if (other.repository != null)
                return false;
        } else if (!repository.equals(other.repository))
            return false;
        return true;
    }
	
}