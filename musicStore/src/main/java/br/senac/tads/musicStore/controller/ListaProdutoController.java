/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.controller;

import br.senac.tads.musicStore.entidade.Categoria;
import br.senac.tads.musicStore.entidade.SubCategoria;
import br.senac.tads.musicStore.repository.CategoriaRepository;
import br.senac.tads.musicStore.repository.SubCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


/**
 *
 * @author Thukera
 */

@Controller
@ComponentScan(basePackages={"br.senac.tads.musicStore.controller"})
@RequestMapping("/musicStore")
public class ListaProdutoController {
    
    @Autowired
    private CategoriaRepository repositoryCat;
    
    @Autowired
    private SubCategoriaRepository repositorySub;
    
    @GetMapping("/listaProdutos")
    public ModelAndView listaProduto(){
        
        ModelAndView modelAndView = new ModelAndView("listaProdutos");

        List<Categoria> resultadosCat = repositoryCat.findAllCategorias();
        List<SubCategoria> resultadosSub = repositorySub.findAllSubCategorias();

        modelAndView.addObject("categoria", resultadosCat);
        modelAndView.addObject("subcategoria", resultadosSub);
        
              
        return modelAndView;
    }
    
    
    
    
    
    
}
