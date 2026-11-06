package org.example.demo.repository;
import org.example.demo.entity.Kategoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface KategoriaRepo extends CrudRepository<Kategoria, Integer> {
    // Soronként: [kategória neve, fajok száma]. A left join miatt a faj nélküli kategória is megjelenik 0-val.
    @Query("select k.nev, count(a) from Kategoria k left join Allat a on a.katid = k.id group by k.id, k.nev order by count(a) desc")
    List<Object[]> fajokKategoriankent();

    // Főoldal csempéihez: [kategória id, név, fajok száma], id szerint rendezve
    @Query("select k.id, k.nev, count(a) from Kategoria k left join Allat a on a.katid = k.id group by k.id, k.nev order by k.id")
    List<Object[]> kategoriakFajszammal();
}
