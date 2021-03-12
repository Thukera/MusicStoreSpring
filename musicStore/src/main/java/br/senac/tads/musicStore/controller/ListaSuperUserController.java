/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.controller;

import br.senac.tads.musicStore.entidade.Categoria;
import br.senac.tads.musicStore.entidade.Produto;
import br.senac.tads.musicStore.entidade.Usuario;
import br.senac.tads.musicStore.entidade.Venda;
import br.senac.tads.musicStore.repository.CategoriaRepository;
import br.senac.tads.musicStore.repository.ProdutoRepository;
import br.senac.tads.musicStore.repository.UsuarioRepository;
import br.senac.tads.musicStore.repository.VendaRepository;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author Thukera
 */

@Controller
@ComponentScan(basePackages={"br.senac.tads.musicStore.controller"})
@RequestMapping("/musicStore")
public class ListaSuperUserController {
    
    
      
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private VendaRepository vendaRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/listaSuperUser")
    public ModelAndView listar() {
        
        ModelAndView modelAndView = new ModelAndView("listaSuperUser");
        
        List<Produto> resultadosProdutos;
        List<Venda> resultadoVendas;
        List<Usuario> resultadoUsuarios;
        
        resultadosProdutos = produtoRepository.findAllProd();
        resultadoVendas = vendaRepository.findAllVenda();
        resultadoUsuarios = usuarioRepository.findAllUsuarios();
        
        modelAndView.addObject("produto", resultadosProdutos);
        modelAndView.addObject("venda", resultadoVendas);
        modelAndView.addObject("usuario", resultadoUsuarios);
        
        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView adicionarNovo() {
        return new ModelAndView("musicStore/cadastroProduto")
                .addObject("produto", new Produto());
    }
/*
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") Long id) {
        Produto prod = produtoRepository.findById(id);
        
        if (prod.getCategorias() != null && !prod.getCategorias().isEmpty()) {
            Set<Integer> idsCategorias = new HashSet<>();
            for (Categoria cat : prod.getCategorias()) {
                idsCategorias.add(cat.getId());
            }
            prod.setIdsCategorias(idsCategorias);
        }
        return new ModelAndView("musicStore/cadastroProduto")
                .addObject("produto", prod);
    }
*/
    /*
    @PostMapping("/salvar")
    public ModelAndView salvar(
            @ModelAttribute("produto") Produto produto, 
             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        produto.setDtCadastro(LocalDateTime.now());
        if (produto.getIdsCategorias() != null && 
                !produto.getIdsCategorias().isEmpty()) {
            Set<Categoria> categoriasSelecionadas = new HashSet<>();
            for (Integer idCat : produto.getIdsCategorias()) {
                Categoria cat = categoriaRepository.findById(idCat);
                categoriasSelecionadas.add(cat);
                cat.setProdutos(new HashSet<>(Arrays.asList(produto)));
            }
            produto.setCategorias(categoriasSelecionadas);
        }
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("mensagemSucesso", 
                "Produto " + produto.getModelo()+ " salvo com sucesso");
        return new ModelAndView("redirect:/produto");
    }

    @PostMapping("/{id}/remover")
    public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        produtoRepository.delete(id);
        redirectAttributes.addFlashAttribute("mensagemSucesso", 
                "Produto ID " + id + " removido com sucesso");
        return new ModelAndView("redirect:/produto");
    }

    @ModelAttribute("categorias")
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }
    */
    
}
