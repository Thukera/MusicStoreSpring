/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.controller;

import br.senac.tads.musicStore.entidade.Produto;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author Thukera
 */

@Controller
@ComponentScan(basePackages={"br.senac.tads.musicStore.controller"})
@RequestMapping("/musicStore")
public class ProdutoController {
    
    @GetMapping("/produto")
    public ModelAndView listaProduto(){
        return new ModelAndView("produto");
    }
    
    
}
