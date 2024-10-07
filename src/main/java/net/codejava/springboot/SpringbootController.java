package net.codejava.springboot;

import org.springframework.web.bind.annotation.*;

@RestController
public class SpringbootController {

    @RequestMapping("/Usuário")
    public String index() {return "<h1> Bem vindo a OdontoPrev";}

    @RequestMapping("/cadastrar/{nm_completo}")
    public String dizernome(@PathVariable String nm_completo) {return "Complete o formulário"+ nm_completo;}

    @RequestMapping("/info")
    public String apresentar(@RequestParam("nome") String nm_completo, @RequestParam("idade") Integer nr_idade)
        {
            return "<h1> Olá"+ nm_completo + ", meu nome é OTO e irei te orientar para facilitar o cadastro</h1>";
        }

        @PostMapping("/postar")
    public String postar(){return "Cadastro realizado com sucesso";}
}
