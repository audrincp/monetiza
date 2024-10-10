package com.coleta.monetiza.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coleta.monetiza.service.MovimentacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/conta/{idConta}/movimentacao")
@Tag(name = "Movimentações", description = "Movimentações de uma movimentacao corrente")
public class MovimentacaoController implements IController<Movimentacao>{
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping(produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200"
					   , description = "Resultado com sucesso"
					   , content = {@Content(mediaType = "application/json")}
			),
			@ApiResponse(responseCode = "500"
			           , description = "Erro interno do servidor"
			           , content = {@Content(mediaType = "application/json")} 
			)
	})
	@Operation(summary = "Retorna a lista de movimentacaos",
		   description = "Obtém uma lista de movimentações por conta")
	public ResponseEntity<Object> getAll(Pageable pageable, @PathVariable("idConta") Integer idConta){
		return ResponseEntity.ok(service.findByConta(idConta));
	}
	
	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Movimentacao> get(@PathVariable("id") Long id) {
		Movimentacao movimentacao = service.findById(id);
		if (movimentacao != null) {
			return ResponseEntity.ok(movimentacao);
			//HTTP 200 OK
		}
		return ResponseEntity.notFound().build();
	}	
	
	@PostMapping
	@Operation(summary = "Cria uma movimentacao")
	public ResponseEntity<Movimentacao> post(@RequestBody Movimentacao movimentacao, @PathVariable("idConta") Integer idConta){
		service.saveWithConta(movimentacao, idConta);

		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(movimentacao.getId())
						.toUri();
		return ResponseEntity.created(location).body(movimentacao);
	}
	
	@Override
	public ResponseEntity<Movimentacao> put(@RequestBody Movimentacao movimentacao){
		throw new UnsupportedOperationException("Operação não suportada");
	}

	@Override
	public ResponseEntity<Movimentacao> patch(@RequestBody Movimentacao movimentacao){
		throw new UnsupportedOperationException("Operação não suportada");
	}	
	
	@Override
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Exclui uma movimentacao")
	public ResponseEntity<Movimentacao> delete(@PathVariable("id") Long id){
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Movimentacao>> getAll() {
		throw new UnsupportedOperationException("Operação não suportada");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((service == null) ? 0 : service.hashCode());
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
		MovimentacaoController other = (MovimentacaoController) obj;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		return true;
	}

	public MovimentacaoService getService() {
		return service;
	}

	public void setService(MovimentacaoService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<Movimentacao> post(Movimentacao obj) {
		throw new UnsupportedOperationException("Operação não suportada");
	}

	@Override
	public ResponseEntity<Page<Movimentacao>> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}	
}