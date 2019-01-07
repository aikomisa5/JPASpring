package hello;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by PC on 06/01/2019.
 */

public interface PersonaRepository extends CrudRepository<Persona,Long> {

}
