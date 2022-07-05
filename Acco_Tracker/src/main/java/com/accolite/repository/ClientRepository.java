package com.accolite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
