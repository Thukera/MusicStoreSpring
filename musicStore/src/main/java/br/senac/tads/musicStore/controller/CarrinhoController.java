/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.controller;

import br.senac.tads.musicStore.entidade.Carrinho;
import br.senac.tads.musicStore.entidade.Produto;
import br.senac.tads.musicStore.entidade.Usuario;
import br.senac.tads.musicStore.entidade.Venda;
import br.senac.tads.musicStore.repository.ProdutoRepository;
import br.senac.tads.musicStore.repository.UsuarioRepository;
import br.senac.tads.musicStore.repository.VendaRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



/**
 *
 * @author Thukera
 */

@Controller
@ComponentScan(basePackages={"br.senac.tads.musicStore.controller"})
@RequestMapping("/musicStore")
public class CarrinhoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private VendaRepository vendaRepository;
    
    @GetMapping("/carrinho")
    public ModelAndView listaProduto(){
        
        ModelAndView modelAndView = new ModelAndView("carrinho");
        
        List<Produto> resultadosProdutos;
        List<Venda> resultadoVendas;
        List<Usuario> resultadoUsuarios;
        
        resultadosProdutos = produtoRepository.findAllProd();
        resultadoVendas = vendaRepository.findAllVenda();
        resultadoUsuarios = usuarioRepository.findAllUsuarios();
        
        modelAndView.addObject("produto", resultadosProdutos);
        modelAndView.addObject("venda", resultadoVendas);
        modelAndView.addObject("usuario", resultadoUsuarios);
        modelAndView.addObject("venda", new Venda());
        
        return modelAndView;
        
    }
    //@RequestMapping(value = "/confirma", method = RequestMethod.POST)
    @PostMapping("/confirma")
    public ModelAndView salvar(
            @ModelAttribute("venda") 
                    Venda venda, RedirectAttributes redirectAttributes) {
        venda.setData(LocalDateTime.now());
        venda.setFrete(BigDecimal.valueOf(30.0));
        
        vendaRepository.save(venda);
        redirectAttributes.addFlashAttribute("mensagemSucesso", 
                venda.getUsuario() + " sua compra foi efetuada com sucesso");
        return new ModelAndView("index");
    }
    
    
}
