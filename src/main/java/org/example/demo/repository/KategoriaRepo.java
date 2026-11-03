package org.example.demo.repository;
import org.example.demo.entity.Kategoria;
import org.springframework.data.repository.CrudRepository;
public interface KategoriaRepo extends CrudRepository<Kategoria, Integer> {
}
