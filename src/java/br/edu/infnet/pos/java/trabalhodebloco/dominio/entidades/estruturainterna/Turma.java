package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TURMA")
public class Turma implements Serializable {

    private static final long serialVersionUID = -8916695384405405035L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    
    @Column(name = "NOME", length = 150)
    private String nome;

    @Column(name = "DT_INICIO")
    private LocalDate inicio;

    @Column(name = "DT_FIM")
    private LocalDate fim;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_PROFESSOR")
    private Professor professor;

    //@ManyToMany(cascade ={ CascadeType.PERSIST})
    @ManyToMany(cascade={ CascadeType.ALL, CascadeType.MERGE })
    
    @JoinTable(name = "TURMA_MODULO", joinColumns = {
        @JoinColumn(name = "ID_TURMA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MODULO")})
    private List<Modulo> modulos;

   // @ManyToMany(cascade = CascadeType.PERSIST)
   // @ManyToMany(cascade={ CascadeType.ALL})
   @ManyToMany(mappedBy = "turmas", cascade = CascadeType.PERSIST)
    
   private List<Aluno> alunos;
      public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
    
       public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
 

    
//        @Override
//    public String toString() {
//        return this.getNome();
//        
//    }
    
    @Override
	public String toString() {
		return getId() + "," + getNome();
	}
	
    
//           @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();  
//        Iterable<Turma> turma = null;
//        for(Turma f : turma){  
//    sb.append(f.toString());  
//  }  
//  return sb.toString();
//}  
    
//    @Override
//    public String toString(){  
//  StringBuffer sb = new StringBuffer();  
//        Iterable<Turma> turma = null;
//  for(Turma f : turma){  
//    sb.append(f.toString());  
//  }  
//  return sb.toString();  
//    }
//    
//  // public class Turma <E> extends ArrayList<E> {
//  @Override
//  public String toString() {
//    StringBuffer s = new StringBuffer();
//    //for(E e : this)
//      s.append(this.getNome());
//    return s.toString();
//  }
// // }
//    
//     @Override
//    public String toString() {
//      return String.valueOf(id);
//}
    
    

// @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//   public boolean equals(Object obj) {
//        return (obj instanceof Turma) && ((Turma) obj).getId().equals(getId());
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



}
