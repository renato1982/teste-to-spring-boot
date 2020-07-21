package com.to.aluno.alunoteste.repository;

import com.to.aluno.alunoteste.model.Aluno;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {

    @Transactional
    @Modifying
    @Query("update Aluno a set a.nome = ?1, a.idade = ?2 where a.id = ?3")
    void setUpdateAluno(String noome, Integer idade, Long id);

}
