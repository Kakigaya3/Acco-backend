package com.accolite.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accolite.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query(value = "select * from client where client_name like %?1%", nativeQuery = true)
	List<Client> getClientByClientName(String clientName);

	@Query(value = "select * from client where domain_name like %?1%", nativeQuery = true)
	List<Client> getClientByDomainName(String domainName);
	
	@Query(value = "select * from client where client_id!=-1", nativeQuery = true)
	List<Client> findAllClients();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE client SET is_active = ?2 WHERE client_id = ?1", nativeQuery = true)
	void updatestatus(Long clientid, int status);
	

	@Query(value = "select count(*) as total_clients from client",nativeQuery = true)
	long getClientCount();

}
