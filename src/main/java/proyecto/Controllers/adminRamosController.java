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

import proyecto.Models.Ramos;
import proyecto.services.ramosServiceImp;

@Controller
public class adminRamosController {


    @Autowired
    private ramosServiceImp ramosService;

  

    @GetMapping("/ramos/new")
    public String newdata(Model model) {
        return "/agregarramos";
    }
    
    @PostMapping("ramos/add")
    public String add(Ramos ramos,
            @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorio = Paths.get("src//main//resources//static//img");
            String ruta = directorio.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaArchivo = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutaArchivo, bytesImg);
                ramos.setImagen(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ramosService.save(ramos);
        return "redirect:/admin";
    }

    @GetMapping("/ramos/delete/{id}")
    public String delete(@PathVariable Long id) {
      var ramos = ramosService.find(id);
        ramosService.delete(ramos);
        return "redirect:/admin";
    }

    @GetMapping("/ramos/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Ramos ramos = ramosService.find(id);
        model.addAttribute("item", ramos);
        return "/editarramos";
    }
}
