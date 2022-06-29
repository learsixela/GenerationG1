package com.generation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{
	//JPQL
	//Usamos objeto
	
	
	//Query comun
	@Query(value="SELECT * FROM autos a WHERE a.marca = ?1",nativeQuery = true)
	List<Auto> buscarMarca(String marca);

}
