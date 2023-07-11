package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
//Anotação para registrar o componente, @Component
@Service
public class GameService {
	
	//injetar uma na outra(o proprio spring resolve)
	@Autowired
	private GameRepository gamerepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gamerepository.findAll();
		//Macete para transformar objetos de um tipo para outro
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
