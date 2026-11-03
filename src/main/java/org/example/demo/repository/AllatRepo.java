package org.example.demo.repository;
import org.example.demo.entity.Allat;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface AllatRepo extends CrudRepository<Allat, Integer> {
    List<Allat> findAllByOrderByNev();
}
