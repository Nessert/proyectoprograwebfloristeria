package proyecto.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import proyecto.Models.Arreglos;
import proyecto.services.ArregloServiceImp;
import proyecto.services.fechasEspecialesServiceImp;
import proyecto.services.ramosServiceImp;

@Controller
public class tiendaController {

    @Autowired
    private ArregloServiceImp arreglosService;

    @Autowired
    private fechasEspecialesServiceImp fechasEspecialesService;

    @Autowired
    private ramosServiceImp ramosService;

    @GetMapping("/tienda")
    public String tiendaArreglos(Model model) {
        var arreglos = arreglosService.getAllArreglos();
        model.addAttribute("arreglos", arreglos);
        var fechas = fechasEspecialesService.getAllfechasEspeciales();
        model.addAttribute("fechas", fechas);
        var ramos = ramosService.getAllRamos();
        model.addAttribute("ramos", ramos);
        return "tienda";

    }
}
