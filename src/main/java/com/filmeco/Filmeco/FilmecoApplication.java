package com.filmeco.Filmeco;

import Model.Filme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@SpringBootApplication
public class FilmecoApplication {
	public ArrayList<Filme> filmes = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(FilmecoApplication.class, args);
	}{
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
					System.out.println(filmes.getLast().getGeneros());
				} catch (RuntimeException e) {
					throw new RuntimeException(e);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
}}
