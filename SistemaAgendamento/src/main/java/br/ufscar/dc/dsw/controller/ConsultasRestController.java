package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.*;
import br.ufscar.dc.dsw.service.spec.IConsultasService;

public class ConsultasRestController {

	@Autowired
	private IConsultasService service;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

	private void parse(Consultas consulta, JSONObject json) {

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				consulta.setId(((Integer) id).longValue());
			} else {
				consulta.setId(((Long) id));
			}
		}
		
		
		consulta.setDataHora((String) json.get("dataHora"));
		consulta.setCliente((Clientes) json.get("cliente"));
		consulta.setProfissional((Profissionais) json.get("profissional"));
		
	}
				
		@GetMapping(path = "/consultas")
		public ResponseEntity<List<Consultas>> lista() {
			List<Consultas> lista = service.buscarTodos();
			if (lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(lista);
		}
		
			
		@GetMapping(path = "/consultas/{id}")
		public ResponseEntity<Consultas> lista(@PathVariable("id") long id) {
			Consultas consulta = service.buscarPorId(id);
			if (consulta == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(consulta);
		}
		
		@PostMapping(path = "/consultas")
		@ResponseBody
		public ResponseEntity<Consultas> cria(@RequestBody JSONObject json) {
			try {
				if (isJSONValid(json.toString())) {
					Consultas consulta = new Consultas(); 
					parse(consulta, json);
					service.salvar(consulta);
					return ResponseEntity.ok(consulta);
				} else {
					return ResponseEntity.badRequest().body(null);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
			}
		}
		
		@PutMapping(path = "/consultas/{id}")
		public ResponseEntity<Consultas> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
			try {
				if (isJSONValid(json.toString())) {
					Consultas consulta = service.buscarPorId(id);
					if (consulta == null) {
						return ResponseEntity.notFound().build();
					} else {
						parse(consulta, json);
						service.salvar(consulta);
						return ResponseEntity.ok(consulta);
					}
				} else {
					return ResponseEntity.badRequest().body(null);
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
			}
		}

		@DeleteMapping(path = "/consultas/{id}")
		public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

			Consultas consulta = service.buscarPorId(id);
			if (consulta == null) {
				return ResponseEntity.notFound().build();
			} else {
				service.excluir(id);
				return ResponseEntity.noContent().build();
			}
		}

	}
