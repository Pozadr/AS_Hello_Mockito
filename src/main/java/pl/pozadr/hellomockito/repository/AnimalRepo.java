package pl.pozadr.hellomockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pozadr.hellomockito.model.Animal;

public interface AnimalRepo extends JpaRepository<Animal, Long> {

}
