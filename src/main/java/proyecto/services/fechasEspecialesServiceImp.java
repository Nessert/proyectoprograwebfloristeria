package proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.Models.fechasEspeciales;
import proyecto.Dao.fechasEspecialesDao;

@Service
public class fechasEspecialesServiceImp implements fechasEspecialesService {

    @Autowired
    private fechasEspecialesDao fechaDao;

    @Override
    @Transactional(readOnly = true)
    public List<fechasEspeciales> getAllfechasEspeciales() {
        return (List<fechasEspeciales>) fechaDao.findAll();
    }

    @Override
    @Transactional
    public void save(fechasEspeciales user) {
        fechaDao.save(user);
    }

    @Override
    @Transactional
    public void delete(fechasEspeciales user) {
        fechaDao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public fechasEspeciales getfechasEspeciales(fechasEspeciales user) {
        return fechaDao.findById(user.getIdfechasEspeciales()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public fechasEspeciales find(Long id) {
        return fechaDao.findById(id).orElse(null);
    }

}