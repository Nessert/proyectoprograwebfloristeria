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

@Controller
public class tiendaController {

    @Autowired
    private ArregloServiceImp arreglosService;

    @GetMapping("/tienda")
    public String adminArreglos(Model model) {
        var arreglos = arreglosService.getAllArreglos();
        model.addAttribute("arreglos", arreglos);
        return "tienda"; 

    }

    @GetMapping("/arreglos/new")
    public String newdata(Model model) {
        return "/agregarArreglos";
    }
    
    @PostMapping("arreglos/add")
    public String add(Arreglos arreglos,
            @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorio = Paths.get("src//main//resources//static//img");
            String ruta = directorio.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaArchivo = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutaArchivo, bytesImg);
                arreglos.setImagen(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        arreglosService.save(arreglos);
        return "redirect:/tienda";
    }

    @GetMapping("/arreglos/delete/{id}")
    public String delete(@PathVariable Long id) {
        var arreglos = arreglosService.find(id);
        arreglosService.delete(arreglos);
        return "redirect:/tienda";
    }

    @GetMapping("/arreglos/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Arreglos arreglos = arreglosService.find(id);
        model.addAttribute("item", arreglos);
        return "/editarArreglos";
    }
}
