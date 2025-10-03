package ashleysaintlouis.plataformainvestimento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Ativo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String ticker;

    @Column(unique = true, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAtivo tipo;

    @Column(scale = 2)
    private BigDecimal precoAtual;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private boolean disponivel;
}
