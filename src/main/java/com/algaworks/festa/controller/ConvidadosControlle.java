package com.algaworks.festa.controller;

import java.util.Collection;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;




@Controller
@RequestMapping("/convidados")
public class ConvidadosControlle {

	@Autowired
	private Convidados convidados;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		
		
		modelAndView.addObject(new Convidado());
		
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}
	
	  /*@GetMapping(path = "/hello", produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> sayHello()
	    {
	         //Get data from service layer into entityList.

	        List<JSONObject> entities = new ArrayList<JSONObject>();
	        for (Entity n : entityList) {
	            JSONObject entity = new JSONObject();
	            entity.put("aa", "bb");
	            entities.add(entity);
	        }
	        return new ResponseEntity<Object>(entities, HttpStatus.OK);
	    } */
	  
	  
	  
	  
	    @GetMapping("findall")
	    @ResponseBody
	    public Collection<Convidado> findAll() {
	        System.out.println("cc");
	        List<Convidado> users = (List<Convidado>) convidados.findAll();
	        System.out.println(users);
	        return users;
	    }
	
}
