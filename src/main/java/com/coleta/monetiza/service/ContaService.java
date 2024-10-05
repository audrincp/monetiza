package com.coleta.monetiza.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coleta.monetiza.model.Conta;
import com.coleta.monetiza.repository.ContaRepository;
@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

	public ContaService() {
    
    }
    public Conta find(Conta conta){
        return contaRepository.findById(conta.getId()).orElse(null);                   
    }
    
    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

    public Conta find(Long id){
        return find(new Conta(id));
    }
    public void create(Conta conta){
        Long newId = (long) (contas.size() + 1);
        conta.setId(newId);
        contas.add(conta);
    }

    public Boolean delete(Long id){
        Conta _conta = find(id);
        if (_conta != null){
            contas.remove(_conta);
            return true;
        }
        return false;
    }
    public Boolean update(Conta conta){
        Conta _conta = find(conta);
        if (_conta != null){
            if (conta.getAgencia() != null && conta.getAgencia() > 0)
                _conta.setAgencia(conta.getAgencia());
            if (!conta.getNumero().isBlank())
                _conta.setNumero(conta.getNumero());
            if (conta.getSaldo() != null && conta.getSaldo() > 0)
                _conta.setSaldo(conta.getSaldo());
            if (!conta.getTitular().isBlank())
                _conta.setTitular(conta.getTitular());
            return true;
        }
        return false;
    }
}
