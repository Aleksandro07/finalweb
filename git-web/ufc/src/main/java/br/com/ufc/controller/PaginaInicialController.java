package br.com.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaginaInicialController{

   @RequestMapping("/")
   public String PaginaInicial(){
	   
      return "pagina-cadastro-produto";
   }
}
