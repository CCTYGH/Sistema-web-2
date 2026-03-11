package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Entity.Produto;
import com.revisaospring.springbasic.Service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;






@Controller
@RequestMapping("/produtoctr")
public class ProdutoController {

@Autowired
private ProdutoService oProdutoService;

@GetMapping("/listarProduto")
public String telalistarProdtuo(Model model) {

    model.addAttribute("produtos",
    oProdutoService.buscarTodos());
    return "listarProduto";
}


 @GetMapping("/formCadastrar")
 public String telacadastrarProduto(Model model) {
     model.addAttribute("produto",new Produto());
     return "cadastrarProduto";
 }
 
 @PostMapping("/salvar")
 public String salvarProduto(@ModelAttribute Produto oProduto) {
oProdutoService.cadastrarProduto(oProduto);
     return "redirect:/produtoctr/listarProduto";
 }
 
    
}
