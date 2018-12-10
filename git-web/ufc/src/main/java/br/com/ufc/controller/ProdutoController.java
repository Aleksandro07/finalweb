package br.com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import br.com.ufc.model.Compra;
import br.com.ufc.model.Produto;

import br.com.ufc.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	
	
	@RequestMapping("/gerenciamento")
	public ModelAndView PaginaGerenciamento(){
		  List<Produto> produtos = produtoService.getAllProdutos();
		ModelAndView mv = new ModelAndView("pagina-gerenciamento");
		mv.addObject("todosOsProdutos", produtos);
		return mv;
	}
	
	
	@RequestMapping("/perfil-adm")
	public ModelAndView PaginaLojaADM(){
		  List<Produto> produtos = produtoService.getAllProdutos();
		ModelAndView mv = new ModelAndView("pagina-loja-adm");
		mv.addObject("todosOsProdutos", produtos);
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView SalvarProduto(Produto produto, @RequestParam(value= "imagem") MultipartFile imagem){
		produtoService.salvarProduto(produto, imagem);
		ModelAndView mv = new ModelAndView("pagina-cadastro-produto");
		return mv;
	}
	
	@RequestMapping("/cadastro")
	public String PaginaCadastroProduto(){
		return "pagina-cadastro-produto";
	}
	
	
	@GetMapping("/listarProdutosAdm")
	public ModelAndView listarPessoa() {
	  List<Produto> produtos = produtoService.getAllProdutos();
	  ModelAndView mv = new ModelAndView("pagina-gerenciamento");
	  mv.addObject("todosOsProdutos", produtos);
	  
	  return mv;
	}
	
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirPessoa(@PathVariable Long id) {
		produtoService.deletarProduto(id);
		ModelAndView mv = new ModelAndView("redirect:/produto/listarProdutosAdm");
		return mv;
	}
	
	
}
