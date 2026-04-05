package com.mycompany.aprendizado.controller;

import com.mycompany.aprendizado.dao.ServicoCRUD_dao;
import com.mycompany.aprendizado.model.OrdemServico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordens")
@CrossOrigin("*")
public class OrdemController {

    @GetMapping
    public String teste() {
        return "Api funcionando!";
    }

    @PostMapping
    public String cadastrar(@RequestBody OrdemServico os) {
        System.out.println("Nome: " + os.getNome());
        System.out.println("Valor: " + os.getValor());
        System.out.println("Prazo: " + os.getPrazo());
        System.out.println("Tipo: " + os.getTipo_servico());

        ServicoCRUD_dao dao = new ServicoCRUD_dao();
        dao.inserir(os);

        return "Ordem cadastrada com sucesso!";
    }
}