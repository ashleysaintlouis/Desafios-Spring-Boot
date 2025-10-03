package ashleysaintlouis.plataformainvestimento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class OrdemOperacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    private TipoOrdemOperacao tipo;

    private int quantidade;

    @Column(scale = 2)
    private BigDecimal valorUnitario;
    @Column(scale = 2)
    private BigDecimal valorTotal;

    private StatusOrdemOperacao status;

    private LocalDateTime dataOperacao;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
