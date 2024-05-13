package org.example.repository;

import org.example.entity.Client;
import org.example.entity.ClientFns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientFnsRepository extends JpaRepository<ClientFns, Integer> {
    ClientFns findClientFnsByInn(String inn);
    Optional<ClientFns> findClientFnsByClient(Client client);
    void deleteClientFnsByClient(Client client);
}
