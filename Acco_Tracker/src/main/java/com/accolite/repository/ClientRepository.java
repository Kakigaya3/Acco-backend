package com.accolite.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accolite.dto.ClientDto;
import com.accolite.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query("select new com.accolite.dto.ClientDto(c.clientId, c.clientName, c.domainName, c.isActive, count(a.clientId) as HeadCount) \r\n"
			+ "       from Client c left join Allocation a\r\n"
			+ "           on c.clientId = a.clientId\r\n"
			+ "               where c.clientName like %?1%"
			+ "                  group by c.clientId")
	List<ClientDto> getClientByClientName(String clientName);

	@Query("select new com.accolite.dto.ClientDto(c.clientId, c.clientName, c.domainName, c.isActive, count(a.clientId) as HeadCount) \r\n"
			+ "			 from Client c left join Allocation a \r\n"
			+ "			    on c.clientId = a.clientId \r\n"
			+ "			        where c.domainName like %?1% \r\n"
			+ "			           group by c.clientId")
	List<ClientDto> getClientByDomainName(String domainName);
	
	@Query("select new com.accolite.dto.ClientDto(c.clientId, c.clientName, c.domainName, c.isActive, count(a.clientId) as HeadCount) \r\n"
			+ "			from Client c left join Allocation a \r\n"
			+ "			   on c.clientId = a.clientId \r\n"
			+ "	              where c.clientId != -1 \r\n"
			+ "			          group by c.clientId")
	List<ClientDto> findAllClients();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE client SET is_active = ?2 WHERE client_id = ?1", nativeQuery = true)
	void updatestatus(Long clientId, int status);
	

	@Query(value = "select count(*) as total_clients from client",nativeQuery = true)
	long getClientCount();

}
