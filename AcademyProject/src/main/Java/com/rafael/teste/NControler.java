package com.rafael.teste;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NControler {

	@RequestMapping("olateste")
	public String testescan() {
		return "It´s work!!";
	}
}
