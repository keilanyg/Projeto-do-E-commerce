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

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper mapper;

    @Autowired
    private PedidoMapper pedidoMapper;

    public PedidoResponseDTO salvar(PedidoRequestDTO pedidoDto) {
        var pedido =  mapper.toEntity(pedidoDto);

        if (pedidoRepository.existsByNome(pedido.getNome())) {
            throw new BusinessException("Já existe um pedido com esse nome");
        }

        pedidoRepository.save(pedido);
        return mapper.toResponseDTO(pedido);
    }

    public List<PedidoResponseDTO> lista(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return mapper.toDTOList (pedidos);
    }

    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
    }

    public PedidoResponseDTO atualizar(Long id, PedidoRequestDTO pedidoDto) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Pedido não encontrada"));

        if (!pedido.getNome().equals(pedidoDto.getNome()) && pedidoRepository.existsByNome( pedidoDto.getNome()) ) {
            throw  new BusinessException("Já existe um pedido com esse nome");
        }

        pedidoMapper.updateEntityFromDTO(pedidoDto, pedido);
        var pedidoAlterada = pedidoRepository.save(pedido);

        return pedidoMapper.toResponseDTO(pedidoAlterada);
    }

    public PedidoResponseDTO buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Pedido não encontrada"));
        return pedidoMapper.toResponseDTO(pedido);
    }
}
