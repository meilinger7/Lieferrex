package com.htlimst.lieferrex.repository;


import com.htlimst.lieferrex.model.Angestellter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AngestellterRepository extends JpaRepository<Angestellter,Long> {
}
