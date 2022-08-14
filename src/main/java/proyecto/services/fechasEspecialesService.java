package proyecto.services;
import java.util.List;

import proyecto.Models.fechasEspeciales;

public interface fechasEspecialesService {

    public List<fechasEspeciales> getAllfechasEspeciales();

    public void save(fechasEspeciales fecha);

    public void delete(fechasEspeciales fecha);

    public fechasEspeciales getfechasEspeciales(fechasEspeciales fecha);

    public fechasEspeciales find(Long id);
}
