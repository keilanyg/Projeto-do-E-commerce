package br.ifrn.edu.jeferson.ecommerce.service;

import br.ifrn.edu.jeferson.ecommerce.domain.Endereco;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.EnderecoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.EnderecoResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.exception.BusinessException;
import br.ifrn.edu.jeferson.ecommerce.exception.ResourceNotFoundException;
import br.ifrn.edu.jeferson.ecommerce.mapper.EnderecoMapper;
import br.ifrn.edu.jeferson.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper mapper;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public EnderecoResponseDTO salvar(EnderecoRequestDTO enderecoDto) {
        var endereco =  mapper.toEntity(enderecoDto);

        if (enderecoRepository.existsByNome(endereco.getNome())) {
            throw new BusinessException("Já existe um endereço com esse nome");
        }

        enderecoRepository.save(endereco);
        return mapper.toResponseDTO(endereco);
    }

    public List<EnderecoResponseDTO> lista(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return mapper.toDTOList (enderecos);
    }

    public void deletar(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Endereco não encontrado");
        }
        enderecoRepository.deleteById(id);
    }

    public EnderecoResponseDTO atualizar(Long id, EnderecoRequestDTO enderecoDto) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Endereco não encontrada"));

        if (!endereco.getNome().equals(enderecoDto.getNome()) && enderecoRepository.existsByNome( enderecoDto.getNome()) ) {
            throw  new BusinessException("Já existe um endereço com esse nome");
        }

        enderecoMapper.updateEntityFromDTO(enderecoDto, endereco);
        var enderecoAlterada = enderecoRepository.save(endereco);

        return enderecoMapper.toResponseDTO(enderecoAlterada);
    }

    public EnderecoResponseDTO buscarPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Endereco não encontrada"));
        return enderecoMapper.toResponseDTO(endereco);
    }
}
