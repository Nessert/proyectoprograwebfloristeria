package proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.Models.Ramos;
import proyecto.Dao.RamosDao;

@Service
public class ramosServiceImp implements ramosService {

    @Autowired
    private RamosDao fechaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ramos> getAllRamos() {
        return (List<Ramos>) fechaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Ramos ramos) {
        fechaDao.save(ramos);
    }

    @Override
    @Transactional
    public void delete(Ramos ramos) {
        fechaDao.delete(ramos);
    }

    @Override
    @Transactional(readOnly = true)
    public Ramos getRamos(Ramos ramos) {
        return fechaDao.findById(ramos.getIdRamos()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Ramos find(Long id) {
        return fechaDao.findById(id).orElse(null);
    }

}