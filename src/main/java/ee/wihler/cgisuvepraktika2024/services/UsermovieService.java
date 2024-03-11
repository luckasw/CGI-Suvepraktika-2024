package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Usermovie;

import java.util.List;

public interface UsermovieService {
    List<Usermovie> getAllUsermoviesByUserId(Integer userId);
    void saveUsermovie(Usermovie usermovie);
    void deleteUsermovie(Integer id);
}
