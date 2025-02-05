package com.htlimst.lieferrex.repository;


import com.htlimst.lieferrex.model.Gericht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerichtRepository extends JpaRepository<Gericht,Long> {

    // TODO: change email when security is finished
    @Query(value = "SELECT * FROM gericht WHERE gericht.mandant_id = (SELECT m.mandant_id FROM mandant as m INNER JOIN angestellter as a ON a.mandant_id = m.mandant_id WHERE a.angestellter_id = 6) AND (status = '1' OR status = '2')", nativeQuery = true)
    public List<Gericht> getGerichtByEnabled();

    @Query(value = "SELECT * FROM gericht WHERE gericht.mandant_id = (SELECT m.mandant_id FROM mandant as m INNER JOIN angestellter as a ON a.mandant_id = m.mandant_id WHERE a.angestellter_id = 6) AND (status = '0')", nativeQuery = true)
    public List<Gericht> getGerichtByEnabledWhereStatusZero();
}
