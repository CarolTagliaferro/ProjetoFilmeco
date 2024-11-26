package com.filmeco.Filmeco;

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

                JdbcConnection jdbc = new JdbcConnection();
                Connection conn = jdbc.getConnection();
                String query = "SELECT * FROM filmes";
                   try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Define o valor do parâmetro
                     ResultSet rs = stmt.executeQuery();
                       if (rs.next()) {
                           System.out.println("Título: " + rs.getString("titulo"));
                       }
                     mv.addObject("nome", rs.getString("genero"));
                    mv.addObject("titulo", rs.getString("titulo"));
        } catch (Exception e) {
                       throw new RuntimeException(e);
                   }

        return mv;
    }
}
