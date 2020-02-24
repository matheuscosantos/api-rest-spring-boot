package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produto")
	@ApiOperation(value="Método para retornar todos produtos cadastrados")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Método que recebe como parâmetro um id e retorna um produto de mesmo id")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Método que salva um produto passado por JSON no corpo da requisição")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}	
	
	@DeleteMapping("/produto")
	@ApiOperation(value="Método que remove um produto de acordo com o produto passado por JSON no corpo da requisição")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Método para atualizar um produto de acordo com o produto passado por JSON no corpo da requisição")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
