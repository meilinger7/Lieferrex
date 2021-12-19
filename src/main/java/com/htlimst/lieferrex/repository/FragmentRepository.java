package com.htlimst.lieferrex.repository;


import com.htlimst.lieferrex.model.Fragment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FragmentRepository extends JpaRepository<Fragment,Long> {
}
