package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
//Anotação para registrar o componente, @Component
@Service
public class GameService {
	
	//injetar uma na outra(o proprio spring resolve)
	@Autowired
	private GameRepository gamerepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(@PathVariable Long id) {
		Game result = gamerepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gamerepository.findAll();
		//Macete para transformar objetos de um tipo para outro
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gamerepository.searchByList(listId);
		//Macete para transformar objetos de um tipo para outro
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		 
	}
}
