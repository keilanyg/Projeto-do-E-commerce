package br.ifrn.edu.jeferson.ecommerce.service;

import br.ifrn.edu.jeferson.ecommerce.domain.Produto;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ProdutoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ProdutoResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.exception.BusinessException;
import br.ifrn.edu.jeferson.ecommerce.exception.ResourceNotFoundException;
import br.ifrn.edu.jeferson.ecommerce.mapper.ProdutoMapper;
import br.ifrn.edu.jeferson.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper mapper;

    @Autowired
    private ProdutoMapper produtoMapper;

    public ProdutoResponseDTO salvar(ProdutoRequestDTO produtoDto) {
        var produto =  mapper.toEntity(produtoDto);

        if (produtoRepository.existsByNome(produto.getNome())) {
            throw new BusinessException("Já existe um produto com esse nome");
        }

        produtoRepository.save(produto);
        return mapper.toResponseDTO(produto);
    }

    public List<ProdutoResponseDTO> lista(){
        List<Produto> produtos = produtoRepository.findAll();
        return mapper.toDTOList (produtos);
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO produtoDto) {
        Produto produto = produtoRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Produto não encontrada"));

        if (!produto.getNome().equals(produtoDto.getNome()) && produtoRepository.existsByNome( produtoDto.getNome()) ) {
            throw  new BusinessException("Já existe um produto com esse nome");
        }

        produtoMapper.updateEntityFromDTO(produtoDto, produto);
        var produtoAlterada = produtoRepository.save(produto);

        return produtoMapper.toResponseDTO(produtoAlterada);
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Produto não encontrada"));
        return produtoMapper.toResponseDTO(produto);
    }
}
