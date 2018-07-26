package co.projet.filrouge.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Column;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.projet.filrouge.model.Foods;
import co.projet.filrouge.model.FoodsGroup;
import co.projet.filrouge.service.FoodsService;
import co.projet.filrouge.service.GroupService;
  
@Controller
@RequestMapping("/foods") 
@CrossOrigin(origins = {"http://localhost:4200"})
public class FoodsController {
	@Inject
	FoodsService foodsService;
 
	
	
 	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long create(@RequestBody Foods ressource) {
		//System.out.println(resource);
	    return foodsService.saveFoods(ressource).getId();
	}
	
 	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletee(@PathVariable(value = "id") Long id) {
        foodsService.deleteById(id);
    }
	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Foods> findAll() {
		return foodsService.getAll();
	}
 	
 	// Recherche par nom de l'aliment
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
        public List<Foods> findByName(@PathVariable(value="name") String name) {
        System.out.println("name = " + name);
        return foodsService.findByName(name);
    }
 
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@PathVariable(value = "id") Long id, @RequestBody Foods resource) {
        resource.setId(id);     
        foodsService.saveFoods(resource).getId();

    }


}
