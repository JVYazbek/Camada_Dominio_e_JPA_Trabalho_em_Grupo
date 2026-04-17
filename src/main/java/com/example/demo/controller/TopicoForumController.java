package com.example.demo.controller;

import com.example.demo.domain.TopicoForum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoForumController {

    private List<TopicoForum> listaTopicos = new ArrayList<>();
    private Long contadorId = 1L;

    @GetMapping
    public List<TopicoForum> listar() {
        return listaTopicos;
    }

    @GetMapping("/{id}")
    public TopicoForum buscar(@PathVariable Long id) {
        for (TopicoForum t : listaTopicos) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicoForum criar(@RequestBody TopicoForum topico) {
        topico.setId(contadorId++);
        listaTopicos.add(topico);
        return topico;
    }

    @PutMapping("/{id}")
    public TopicoForum atualizar(@PathVariable Long id, @RequestBody TopicoForum novoTopico) {
        for (TopicoForum t : listaTopicos) {
            if (t.getId().equals(id)) {
                t.setTitulo(novoTopico.getTitulo());
                t.setConteudo(novoTopico.getConteudo());
                t.setQuantidadeRespostas(novoTopico.getQuantidadeRespostas());
                return t;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        listaTopicos.removeIf(t -> t.getId().equals(id));
    }
}