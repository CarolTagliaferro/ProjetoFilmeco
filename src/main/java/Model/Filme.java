package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Model.JdbcConnection;

public class Filme {
    public ArrayList<Filme> filmes = new ArrayList<>();

    private int id;
    private String titulo;
    private int duracao;
    private String descricao;
    private int ano;
    private Date dataInsercao;
    private ArrayList<String> generos;
    private String filmeEndereco;
    private String capaEndereco;

    public Filme() {

    }

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

    public ArrayList<Filme> puxarBanco(){
        Model.JdbcConnection jdbc = new Model.JdbcConnection();
        Connection conn = jdbc.getConnection();
        String query = "SELECT * FROM filmes";


        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Define o valor do parâmetro
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Filme filme = new Filme(rs.getInt("id"), rs.getString("titulo"),
                        rs.getInt("duracao"), rs.getString("descricao"),
                        rs.getInt("ano"),rs.getDate("data"),rs.getString("filme"),
                        rs.getString("capa"));
                filmes.add(filme);
                String query2 = "SELECT genero from genero\n" +
                        "INNER JOIN filme_genero ON filme_genero.genero_id = genero.id\n" +
                        "where filme_genero.filme_id = "+ rs.getInt("id");
                try (PreparedStatement stmt2 = conn.prepareStatement(query2)) {
                    ResultSet rs2 = stmt2.executeQuery();
                    ArrayList<String> generos = new ArrayList<>();
                    while (rs2.next()) {
                        generos.add(rs2.getString("genero"));
                    }
                    filmes.getLast().setGeneros(generos);
                    System.out.println(filmes.getLast().getTitulo());
                    System.out.println(filmes.getLast().getCapaEndereco());

                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }

}
