package br.ifrn.edu.jeferson.ecommerce.service;

import br.ifrn.edu.jeferson.ecommerce.domain.Cliente;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ClienteRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ClienteResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.exception.BusinessException;
import br.ifrn.edu.jeferson.ecommerce.exception.ResourceNotFoundException;
import br.ifrn.edu.jeferson.ecommerce.mapper.ClienteMapper;
import br.ifrn.edu.jeferson.ecommerce.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    // Construtor para injeção de dependências
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO clienteDto) {
        var cliente = clienteMapper.toEntity(clienteDto);

        // Verificar se já existe um cliente com o mesmo nome
        if (clienteRepository.existsByNome(cliente.getNome())) {
            throw new BusinessException("Já existe um cliente com esse nome");
        }

        // Verificar se já existe um cliente com o mesmo CPF
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new BusinessException("Já existe um cliente com esse CPF");
        }

        clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(cliente);
    }

    public List<ClienteResponseDTO> lista() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toDTOList(clientes);
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não foi encontrado");
        }
        clienteRepository.deleteById(id);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO clienteDto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        // Verificar se já existe um cliente com o nome informado
        if (!cliente.getNome().equals(clienteDto.getNome()) && clienteRepository.existsByNome(clienteDto.getNome())) {
            throw new BusinessException("Já existe um cliente com esse nome");
        }

        // Verificar se o CPF também está sendo alterado e se já existe
        if (!cliente.getCpf().equals(clienteDto.getCpf()) && clienteRepository.existsByCpf(clienteDto.getCpf())) {
            throw new BusinessException("Já existe um cliente com esse CPF");
        }

        // Atualizar a entidade cliente com as informações do DTO
        clienteMapper.updateEntityFromDTO(clienteDto, cliente);
        var clienteAlterado = clienteRepository.save(cliente);

        return clienteMapper.toResponseDTO(clienteAlterado);
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return clienteMapper.toResponseDTO(cliente);
    }
}
