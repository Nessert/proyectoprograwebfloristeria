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

import proyecto.Models.fechasEspeciales;
import proyecto.services.fechasEspecialesServiceImp;

@Controller
public class adminFechasController {


    @Autowired
    private fechasEspecialesServiceImp fechasEspecialesService;

  

    @GetMapping("/fechas/new")
    public String newdata(Model model) {
        return "/agregarfechas";
    }
    
    @PostMapping("fechas/add")
    public String add(fechasEspeciales fechas,
            @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorio = Paths.get("src//main//resources//static//img");
            String ruta = directorio.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaArchivo = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutaArchivo, bytesImg);
                fechas.setImagen(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fechasEspecialesService.save(fechas);
        return "redirect:/admin";
    }

    @GetMapping("/fechas/delete/{id}")
    public String delete(@PathVariable Long id) {
      var fechas = fechasEspecialesService.find(id);
        fechasEspecialesService.delete(fechas);
        return "redirect:/admin";
    }

    @GetMapping("/fechas/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        fechasEspeciales fechas = fechasEspecialesService.find(id);
        model.addAttribute("item", fechas);
        return "/editarfechas";
    }
}
