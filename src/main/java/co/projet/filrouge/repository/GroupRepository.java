package co.projet.filrouge.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

 import co.projet.filrouge.model.FoodsGroup;

  
public interface GroupRepository extends JpaRepository<FoodsGroup, Long>{
 	public List<FoodsGroup> findByName(String name);

	
	
}
