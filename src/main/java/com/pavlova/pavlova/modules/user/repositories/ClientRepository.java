package com.pavlova.pavlova.modules.user.repositories;

import com.pavlova.pavlova.modules.user.models.Client;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientRepository extends SimpleJpaRepository<Client, Long>  {

    public ClientRepository(EntityManager em) {
        super(Client.class, em);
    }

}
