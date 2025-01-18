package br.ifrn.edu.jeferson.ecommerce.service;

import br.ifrn.edu.jeferson.ecommerce.domain.Cliente;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ClienteRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ClienteResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.exception.BusinessException;
import br.ifrn.edu.jeferson.ecommerce.exception.ResourceNotFoundException;
import br.ifrn.edu.jeferson.ecommerce.mapper.ClienteMapper;
import br.ifrn.edu.jeferson.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper mapper;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteResponseDTO salvar(ClienteRequestDTO clienteDto) {
        var cliente =  mapper.toEntity(clienteDto);

        if (clienteRepository.existsByNome(cliente.getNome())) {
            throw new BusinessException("Já existe um cliente com esse nome");
        }

        clienteRepository.save(cliente);
        return mapper.toResponseDTO(cliente);
    }

    public List<ClienteResponseDTO> lista(){
        List<Cliente> clientes = clienteRepository.findAll();
        return mapper.toDTOList (clientes);
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO clienteDto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Cliente não encontrada"));

        if (!cliente.getNome().equals(clienteDto.getNome()) && clienteRepository.existsByNome( clienteDto.getNome()) ) {
            throw  new BusinessException("Já existe um cliente com esse nome");
        }

        clienteMapper.updateEntityFromDTO(clienteDto, cliente);
        var clienteAlterada = clienteRepository.save(cliente);

        return clienteMapper.toResponseDTO(clienteAlterada);
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Cliente não encontrada"));
        return clienteMapper.toResponseDTO(cliente);
    }
}
