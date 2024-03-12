package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Usermovie;
import ee.wihler.cgisuvepraktika2024.repositories.UsermovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsermovieServiceImp implements UsermovieService {
    @Autowired
    private UsermovieRepository usermovieRepository;

    @Override
    public List<Usermovie> getAllUsermoviesByUserId(Integer userId) {
        return usermovieRepository.findByUsermovieuseridId(userId);
    }

    @Override
    public void saveUsermovie(Usermovie usermovie) {
        usermovieRepository.save(usermovie);
    }

    @Override
    public void deleteUsermovie(Integer id) {
        usermovieRepository.deleteById(id);
    }
}
