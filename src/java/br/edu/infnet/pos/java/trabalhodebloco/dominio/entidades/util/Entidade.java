package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import java.io.Serializable;

@MappedSuperclass
public abstract class Entidade implements Serializable {

    private static final long serialVersionUID = -5338862198322081898L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
