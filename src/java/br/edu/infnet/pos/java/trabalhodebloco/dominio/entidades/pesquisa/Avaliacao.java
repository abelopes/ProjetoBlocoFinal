package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Table(name = "AVALIACAO")
public class Avaliacao extends Entidade {

    private static final long serialVersionUID = 7138098198142465498L;

    @OneToMany(mappedBy = "avaliacao")
    private List<Resposta> respostas;

    @OneToMany(mappedBy = "avaliacao")
    private List<Topico> topicos;

    @Column(name = "DATA_HORA_INICIO")
    private LocalDateTime inicio;

    @Column(name = "DATA_HORA_FIM")
    private LocalDateTime fim;


    }

}
    @Lob
    @Column(name = "OBJETIVO")
    private String objetivo;
