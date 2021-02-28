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
@Table(name="Equipamento")
public class Equipamento implements Serializable {
    @Id
    private int id;
    @Column    
    private String nome;
    @Column
    private String descricao;
    @Column
    private int sala;

   /* public Equipamento(long id, int identificacao, String nome, String descricao, int sala) {
        this.id = id;
        this.identificacao = identificacao;
        this.nome = nome;
        this.descricao = descricao;
        this.sala = sala;
    }*/

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = (int) id;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
    
}
