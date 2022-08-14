package proyecto.services;
import java.util.List;

import proyecto.Models.Ramos;

public interface ramosService {

    public List<Ramos> getAllRamos();

    public void save(Ramos ramos);

    public void delete(Ramos ramos);

    public Ramos getRamos(Ramos ramos);

    public Ramos find(Long id);
}