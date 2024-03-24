package org.example.repository;

import org.example.entity.Client;
import org.example.entity.ClientFns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientFnsRepository extends JpaRepository<ClientFns, Integer> {
    ClientFns findClientFnsByInn(String inn);
    ClientFns findClientFnsByClient(Client client);
    void deleteClientFnsByClient(Client client);
}
