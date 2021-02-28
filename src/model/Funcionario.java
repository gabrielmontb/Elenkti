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
@Table(name="Funcionario")
public class Funcionario implements Serializable {
    @Id
    private String ID;
    @Column
    private String nome;
    //@Column
    //private String login;
    @Column
    private String senha;
    @Column
    private boolean nivel;
    //Getters and Setters
    public String getID() {
        return ID;
    }

    public void setNivel(boolean nivel) {
        this.nivel = nivel;
    }

    /**
     *
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*public void setLogin(String login) {
        this.login = login;
    }*/

    public void setSenha(String senha) {
        this.senha = senha;
    }    

    public String getNome() {
        return nome;
    }

    /*public String getLogin() {
        return login;
    }*/

    public String getSenha() {
        return senha;
    }

    public boolean getNivel() {
        return nivel;
    }

   /* public Funcionario(String nome, String login, String senha, int nivel) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }*/
}
