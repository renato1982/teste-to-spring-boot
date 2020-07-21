package com.to.aluno.alunoteste.service;

import com.to.aluno.alunoteste.model.Aluno;
import com.to.aluno.alunoteste.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public String gravarAluno(Aluno aluno){
        repository.save(aluno);
        return "Aluno Inserido com Sucesso!";
    }

    public String alterarAluno(Aluno aluno) {

        String mensagem = "";
        Optional<Aluno> alunoBase =  repository.findById(aluno.getId());

        if (alunoBase != null){
            repository.setUpdateAluno(aluno.getNome(), aluno.getIdade(), aluno.getId());
            mensagem = "Aluno alterado com Sucesso!";
        }else {
            mensagem = "Aluno não encontrado!";
        }

        return mensagem;
    }

    public String deletarAluno(Long aluno) {

        String mensagem = "";
        Optional<Aluno> alunoBase =  repository.findById(aluno);

        if (alunoBase != null){
            repository.deleteById(aluno);
            mensagem = "Aluno excluído com Sucesso!";
        }else {
            mensagem = "Aluno não encontrado!";
        }

        return mensagem;
    }
}
