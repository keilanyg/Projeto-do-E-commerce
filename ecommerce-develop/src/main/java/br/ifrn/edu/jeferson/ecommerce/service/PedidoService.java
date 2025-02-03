package br.ifrn.edu.jeferson.ecommerce.service;

import br.ifrn.edu.jeferson.ecommerce.domain.Pedido;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.PedidoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.PedidoResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.exception.BusinessException;
import br.ifrn.edu.jeferson.ecommerce.exception.ResourceNotFoundException;
import br.ifrn.edu.jeferson.ecommerce.mapper.PedidoMapper;
import br.ifrn.edu.jeferson.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    // Injeção de dependência via construtor
    public PedidoService(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    public PedidoResponseDTO salvar(PedidoRequestDTO pedidoDto) {
        var pedido = pedidoMapper.toEntity(pedidoDto);  // Converte PedidoRequestDTO para Pedido

        if (pedidoRepository.existsByNome(pedido.getNome())) {
            throw new BusinessException("Já existe um pedido com esse nome");
        }

        pedidoRepository.save(pedido);
        return pedidoMapper.toResponseDTO(pedido);  // Converte Pedido para PedidoResponseDTO
    }

    public List<PedidoResponseDTO> lista() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidoMapper.toDTOList(pedidos);  // Converte lista de Pedido para lista de PedidoResponseDTO
    }

    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não foi encontrado");
        }
        pedidoRepository.deleteById(id);
    }

    public PedidoResponseDTO atualizar(Long id, PedidoRequestDTO pedidoDto) {
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

        if (!pedido.getNome().equals(pedidoDto.getNome()) && pedidoRepository.existsByNome(pedidoDto.getNome())) {
            throw new BusinessException("Já existe um pedido com esse nome");
        }

        pedidoMapper.updateEntityFromDTO(pedidoDto, pedido);  // Atualiza a entidade Pedido com os dados do DTO
        var pedidoAlterado = pedidoRepository.save(pedido);

        return pedidoMapper.toResponseDTO(pedidoAlterado);  // Retorna a resposta DTO do pedido atualizado
    }

    public PedidoResponseDTO buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
        return pedidoMapper.toResponseDTO(pedido);  // Converte o Pedido para PedidoResponseDTO
    }
}
