package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gabriel Montserrat
 */
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
    @Id
    private int matricula;
    @Column
    private int telefone;
    @Column
    private String nome;   
    @Column
    private String observacao;
    //Getters and setters
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /*public Usuario(long ID, int telefone, String nome, String matricula) {
        this.ID = ID;
        this.telefone = telefone;
        this.nome = nome;
        this.matricula = matricula;
    }*/

   /* public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }*/

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
