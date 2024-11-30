package com.filmeco.Filmeco;

import Model.Filme;
import Model.JdbcConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.sql.PreparedStatement;
import java.sql.*;

@Controller

public class ControllerFilmeco {

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
}
