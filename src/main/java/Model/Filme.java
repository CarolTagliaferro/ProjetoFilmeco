package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Model.JdbcConnection;

public class Filme {
    private int id;
    private String titulo;
    private int duracao;
    private String descricao;
    private int ano;
    private Date dataInsercao;
    private ArrayList<String> generos;;
    private String filmeEndereco;
    private String capaEndereco;


    public Filme(int id, String titulo, int duracao, String descricao,
                 int ano, Date dataInsercao,
                 String filmeEndereco, String capaEndereco) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.descricao = descricao;
        this.ano = ano;
        this.dataInsercao = dataInsercao;
        this.filmeEndereco = filmeEndereco;
        this.capaEndereco = capaEndereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public ArrayList<String> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<String> generos) {
        this.generos = generos;
    }

    public String getFilmeEndereco() {
        return filmeEndereco;
    }

    public void setFilmeEndereco(String filmeEndereco) {
        this.filmeEndereco = filmeEndereco;
    }

    public String getCapaEndereco() {
        return capaEndereco;
    }

    public void setCapaEndereco(String capaEndereco) {
        this.capaEndereco = capaEndereco;
    }

}
