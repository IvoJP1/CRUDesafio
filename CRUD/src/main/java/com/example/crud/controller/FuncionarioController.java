package com.example.crud.controller;


import com.example.crud.funcionario.Funcionario;
import com.example.crud.funcionario.FuncionarioRepositorio;
import com.example.crud.funcionario.FuncionarioRequestDTO;
import com.example.crud.funcionario.FuncionarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepositorio repositorio;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFuncionario(@RequestBody FuncionarioRequestDTO data){
        Funcionario funcionarioData = new Funcionario(data);
        repositorio.save(funcionarioData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FuncionarioResponseDTO> getAll(){

        List<FuncionarioResponseDTO> funcionarioList =  repositorio.findAll().stream().map(FuncionarioResponseDTO::new).toList();
        return funcionarioList;
    }

    @GetMapping("one")
    public Optional<Funcionario> getById(@RequestParam long id) {
        return repositorio.findById(id);
    }

    @PutMapping
    public void update(@RequestBody Funcionario data){
        repositorio.save(data);
    }

    @DeleteMapping
    public  void delete(@RequestParam long id){
        repositorio.deleteById(id);
    }
}
