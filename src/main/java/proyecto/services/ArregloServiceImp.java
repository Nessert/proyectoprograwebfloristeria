package proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.Models.Arreglos;
import proyecto.Dao.ArreglosDao;

@Service
public class ArregloServiceImp implements arregloService {

    @Autowired
    private ArreglosDao arreglosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arreglos> getAllArreglos() {
        return (List<Arreglos>) arreglosDao.findAll();
    }

    @Override
    @Transactional
    public void save(Arreglos user) {
        arreglosDao.save(user);
    }

    @Override
    @Transactional
    public void delete(Arreglos user) {
        arreglosDao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Arreglos getArreglos(Arreglos user) {
        return arreglosDao.findById(user.getIdArreglos()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Arreglos find(Long id) {
        return arreglosDao.findById(id).orElse(null);
    }

}
