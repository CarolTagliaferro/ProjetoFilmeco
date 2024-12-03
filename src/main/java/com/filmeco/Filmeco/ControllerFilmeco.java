package com.filmeco.Filmeco;

import Model.Filme;
import Model.JdbcConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.filmeco.Filmeco.FilmecoApplication;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller

public class ControllerFilmeco {
    public ArrayList<Filme> filmes = new ArrayList<>();
    public boolean autenticado = false;

    @GetMapping("/start")
    public String start() {
        Filme filme = new Filme();
        filmes = filme.puxarBanco();
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }

    @GetMapping("/autenticar")
    public String autenticar(String email, String senha){
        Model.JdbcConnection jdbc = new Model.JdbcConnection();
        Connection conn = jdbc.getConnection();
        String query = "SELECT email,senha from usuarios";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if (email.equals(rs.getString("email")) && senha.equals(rs.getString("senha"))) {
                    autenticado = true;
                    return "redirect:/home";
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/login";
    }

    @GetMapping("/aboutus")
    public ModelAndView aboutus(){
        ModelAndView mv = new ModelAndView("aboutus");

        return mv;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(String nome, String last, String email, String senha){
        Model.JdbcConnection jdbc = new Model.JdbcConnection();
        Connection conn = null;

        String query = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try {
            conn = jdbc.getConnection();

            // Preparar a query
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nome + " " + last); // Concatena nome e sobrenome
                stmt.setString(2, email);
                stmt.setString(3, senha); // Considere aplicar hashing na senha

                // Executa o comando SQL
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Usuário cadastrado com sucesso.");
                } else {
                    System.out.println("Falha ao cadastrar usuário.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário: " + e.getMessage(), e);
        } finally {
            // Fecha a conexão
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }

        return "redirect:/login";
    }



    @GetMapping("/home")
    public ModelAndView home() {
        if (!autenticado) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView mv = new ModelAndView("index");
        int i = 1;
        List<String> imageUrls = new ArrayList<>();
        List<Integer> id = new ArrayList<>();
        List<String> generoFilmes = new ArrayList<>();

        for (Filme filme : filmes) {

            imageUrls.add(filme.getCapaEndereco());
            id.add(filme.getId());
            generoFilmes = filme.getGeneros();

            mv.addObject("images", imageUrls);
            mv.addObject("id", id);
            mv.addObject("generoFilmes", generoFilmes);
        }

        //Conexão com o banco para pegar generos
        List<String> genders = new ArrayList<>();
        Model.JdbcConnection jdbc = new Model.JdbcConnection();
        Connection conn = jdbc.getConnection();
        String query = "SELECT * FROM genero";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                genders.add(rs.getString("genero"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        mv.addObject("genders", genders);


        return mv;
    }

    @GetMapping("/filmpage")
        public ModelAndView filmpage(@RequestParam("id")  int id){
        if (!autenticado) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mv = new ModelAndView("filmepage");

        for (Filme filme : filmes) {
            if (filme.getId() == id ) {

                mv.addObject("titulo", filme.getTitulo());
                mv.addObject("duracao", filme.getDuracao()+" min.");
                mv.addObject("ano", filme.getAno());
                mv.addObject("descricao", filme.getDescricao());
                mv.addObject("assistir", "/assistir?id="+filme.getId());
                mv.addObject("fundo", filme.getCapaEndereco());
                mv.addObject("genero", filme.getGeneros());
                }
            }


        return mv;
        }

    @GetMapping("/assistir")
    public ModelAndView assistir(int id){
        if (!autenticado) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mv = new ModelAndView("player");
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                mv.addObject("filme", filme.getFilmeEndereco());
            }
        }
        return mv;
        }

    @GetMapping("/explorar")
    public ModelAndView explorar(){
        if (!autenticado) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mv = new ModelAndView("explorar");
        //exibição de filmes
        int i = 1;

        List<String> imageUrls = new ArrayList<>();
        List<Integer> id = new ArrayList<>();

        for (Filme filme : filmes) {

                imageUrls.add(filme.getCapaEndereco());
                id.add(filme.getId());

            mv.addObject("images", imageUrls);
            mv.addObject("id", id);
        }

        return mv;
    }

}
