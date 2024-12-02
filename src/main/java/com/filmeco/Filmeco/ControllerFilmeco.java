package com.filmeco.Filmeco;

import Model.Filme;
import Model.JdbcConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.filmeco.Filmeco.FilmecoApplication;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

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



            // Exemplo de consulta



        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }

    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView mv = new ModelAndView("signup");

        return mv;
    }

    @GetMapping("/filmpage")
        public ModelAndView filmpage(){
        ModelAndView mv = new ModelAndView("filmepage");
        System.out.println(filmes.getFirst().getGeneros());
        String titulo = "The Batman";
        for (Filme filme : filmes) {
            if (filme.getTitulo().equals(titulo)) {
                mv.addObject("titulo", filme.getTitulo());
                mv.addObject("duracao", filme.getDuracao()+" min.");
                mv.addObject("ano", filme.getAno());
                mv.addObject("descricao", filme.getDescricao());
            }
        }

        return mv;
        }

    @GetMapping("/assistir")
    public ModelAndView assistir(){
        ModelAndView mv = new ModelAndView("player");
        return mv;
        }

    @GetMapping("/explorar")
    public ModelAndView explorar(){
        ModelAndView mv = new ModelAndView("explorar");

        return mv;
    }

}
