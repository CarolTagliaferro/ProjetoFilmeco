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

    @GetMapping("/start")
    public String start() {
        Filme filme = new Filme();
        filmes = filme.puxarBanco();
        return "redirect:/home";
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        int i = 1;
        List<String> imageUrls = new ArrayList<>();
        List<Integer> id = new ArrayList<>();

        for (Filme filme : filmes) {

            if (filme.getCapaEndereco().equals("images/Capa/JohnWickChapter4.jpg") || filme.getCapaEndereco().equals("images/Capa/HomemAranhaSemVolta.jpg")) {
                imageUrls.add(filme.getCapaEndereco());
                id.add(filme.getId());
            }
            mv.addObject("images", imageUrls);
            mv.addObject("id", id);
        }


            // Exemplo de consulta



        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }

    @GetMapping("/filmpage")
        public ModelAndView filmpage(@RequestParam("id")  int id){
        ModelAndView mv = new ModelAndView("filmepage");

        for (Filme filme : filmes) {
            if (filme.getId() == id ) {
                mv.addObject("titulo", filme.getTitulo());
                mv.addObject("duracao", filme.getDuracao()+" min.");
                mv.addObject("ano", filme.getAno());
                mv.addObject("descricao", filme.getDescricao());
                mv.addObject("assistir", "/assistir?id="+filme.getId());
                mv.addObject("fundo", filme.getCapaEndereco());
            }
        }

        return mv;
        }

    @GetMapping("/assistir")
    public ModelAndView assistir(int id){
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
        ModelAndView mv = new ModelAndView("explorar");

        return mv;
    }

}
