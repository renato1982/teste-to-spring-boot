package com.to.aluno.alunoteste.controller;

import com.to.aluno.alunoteste.model.Aluno;
import com.to.aluno.alunoteste.repository.AlunoRepository;
import com.to.aluno.alunoteste.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    final AlunoService service;

    @GetMapping("/listar-todos")
    public Iterable<Aluno> list() {
        return repository.findAll();
    }

    @GetMapping("/buscar-aluno")
    public ResponseEntity<?> buscarAluno(@RequestParam(name = "id", required = true, defaultValue = "") Long id) {
        Optional<Aluno> aluno = repository.findById(id);
        return ResponseEntity.ok(aluno);
    }

    @PostMapping("/gravar-aluno")
    public ResponseEntity<?> gravarAluno(@Validated @RequestBody Aluno aluno){

       return ResponseEntity.ok(service.gravarAluno(aluno));
    }

    @PostMapping("/alterar-aluno")
    public ResponseEntity<?> alterarAluno(@RequestBody Aluno aluno){

        String mensagem = service.alterarAluno(aluno);

        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/deletar-aluno")
    public ResponseEntity<?> deletarAluno(@RequestParam(name = "id", required = true, defaultValue = "") Long id) {
        String mensagem = service.deletarAluno(id);
        return ResponseEntity.ok(mensagem);
    }


}
