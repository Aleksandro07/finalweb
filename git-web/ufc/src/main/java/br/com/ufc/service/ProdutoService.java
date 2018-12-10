package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import br.com.ufc.model.Produto;
import br.com.ufc.repository.ProdutoRepository;
import br.com.ufc.util.ImageFile;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	//Imagem salva fica com o mesmo nome do produto, entao ele entende que aquela é a imagem do produto
	public void salvarProduto(Produto produto, MultipartFile imagem) { 
		String caminho = "images/" + produto.getNome() + ".png";
		ImageFile.salvarImagem(caminho,imagem);
		
		produtoRepository.save(produto);
	}
	
	
	public void adicionarProduto(Produto produto){
		produtoRepository.save(produto);
	}
	
	public List<Produto> getAllProdutos(){
		return produtoRepository.findAll();
	}
	
	public void deletarProduto(Long id){
		produtoRepository.delete(id);
	}
	
	public Produto buscarPorId(Long id) {
		return produtoRepository.getOne(id);
		
	}

	public void excluirPorId(Long id) {
		
		
	}

}
