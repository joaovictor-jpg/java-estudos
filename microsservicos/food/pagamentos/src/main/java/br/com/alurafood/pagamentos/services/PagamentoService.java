package br.com.alurafood.pagamentos.services;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.repositories.PagamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final ModelMapper modelMapper;

    public PagamentoService(PagamentoRepository pagamentoRepository, ModelMapper modelMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.modelMapper = modelMapper;
    }

    public Page<PagamentoDto> obterTodos(Pageable pageable) {
        return pagamentoRepository.findAll(pageable).map(p -> modelMapper.map(p, PagamentoDto.class));
    }
}
