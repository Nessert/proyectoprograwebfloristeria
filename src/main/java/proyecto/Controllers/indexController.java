package proyecto.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping("/nosotros")
    public String nosotros () {
        return "Nosotros";
    }

    @GetMapping("/contacto")
    public String contacto () {
        return "Contacto";
    }

}
