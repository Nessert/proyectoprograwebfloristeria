package proyecto.services;
import java.util.List;

import proyecto.Models.Arreglos;

public interface arregloService {

    public List<Arreglos> getAllArreglos();

    public void save(Arreglos arreglos);

    public void delete(Arreglos arreglos);

    public Arreglos getArreglos(Arreglos arreglos);

    public Arreglos find(Long id);
}
