package br.com.alurafood.pagamentos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDoPedidoDto {
    private Long id;
    private Integer quantidade;
    private String descricao;
}
