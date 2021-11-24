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

import br.ufscar.dc.dsw.domain.Profissionais;
import br.ufscar.dc.dsw.domain.Consultas;
import br.ufscar.dc.dsw.service.spec.IProfissionaisService;

@RestController
public class ProfissionaisRestController {

	@Autowired
	private IProfissionaisService service;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

	private void parse(Profissionais profissional, JSONObject json) {

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				profissional.setId(((Integer) id).longValue());
			} else {
				profissional.setId(((Long) id));
			}
		}
		
		
		profissional.setCpf((String) json.get("cpf"));
		profissional.setEmail((String) json.get("email"));
		profissional.setSenha((String) json.get("senha"));
		profissional.setNome((String) json.get("nome"));
		profissional.setRole((String) json.get("role"));
		profissional.setConsultas((List<Consultas>) json.get("consulta"));
		profissional.setArea((String) json.get("area"));
		profissional.setEspecialidade((String) json.get("especialidade"));

	}
		
		@GetMapping(path = "/profissionais")
		public ResponseEntity<List<Profissionais>> lista() {
			List<Profissionais> lista = service.buscarTodos();
			if (lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(lista);
		}
		
			
		@GetMapping(path = "/profissionais/{id}")
		public ResponseEntity<Profissionais> lista(@PathVariable("id") long id) {
			Profissionais profissional = service.buscarPorId(id);
			if (profissional == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(profissional);
		}
		
		@PostMapping(path = "/profissionais")
		@ResponseBody
		public ResponseEntity<Profissionais> cria(@RequestBody JSONObject json) {
			try {
				if (isJSONValid(json.toString())) {
					Profissionais profissional = new Profissionais(); 
					parse(profissional, json);
					service.salvar(profissional);
					return ResponseEntity.ok(profissional);
				} else {
					return ResponseEntity.badRequest().body(null);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
			}
		}
		
		@PutMapping(path = "/profissionais/{id}")
		public ResponseEntity<Profissionais> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
			try {
				if (isJSONValid(json.toString())) {
					Profissionais profissional = service.buscarPorId(id);
					if (profissional == null) {
						return ResponseEntity.notFound().build();
					} else {
						parse(profissional, json);
						service.salvar(profissional);
						return ResponseEntity.ok(profissional);
					}
				} else {
					return ResponseEntity.badRequest().body(null);
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
			}
		}

		@DeleteMapping(path = "/profissionais/{id}")
		public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

			Profissionais profissional = service.buscarPorId(id);
			if (profissional == null) {
				return ResponseEntity.notFound().build();
			} else {
				service.excluir(id);
				return ResponseEntity.noContent().build();
			}
		}


			
	}

