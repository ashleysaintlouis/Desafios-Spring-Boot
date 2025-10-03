package ashleysaintlouis.plataformainvestimento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Carteira {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int quantidade;
    private BigDecimal precoMedio;
    private BigDecimal valorAtual;
    private BigDecimal lucroPrejuizo;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
