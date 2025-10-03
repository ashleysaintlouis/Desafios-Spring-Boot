package ashleysaintlouis.plataformainvestimento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class TransacaoFinanceira
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal valor;
    private LocalDateTime dataTransacao;
    private String descricao;

    private TipoTransacaoFinanceira tipo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private List<TransacaoFinanceira> transacoes = new ArrayList<>();
}
