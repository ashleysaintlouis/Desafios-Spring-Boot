package ashleysaintlouis.plataformainvestimento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class HistoricoCotacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal preco;
    private LocalDateTime dataRegistro;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;
}
