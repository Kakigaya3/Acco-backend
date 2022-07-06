package com.accolite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accolite.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query(value = "select * from client where client_name = ?1", nativeQuery = true)
	List<Client> getClientByClientName(String clientName);

	@Query(value = "select * from client where domain_name = ?1", nativeQuery = true)
	List<Client> getClientByDomainName(String domainName);

}
