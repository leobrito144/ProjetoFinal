package br.com.itau.brainWithoutPrice.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.itau.brainWithoutPrice.model.Itmn_evento;

public interface Itmn_eventoDAO extends CrudRepository <Itmn_evento, Integer> {
	@Query(value="SELECT * FROM itmn_evento WHERE data_evt >= :inicio AND data_evt<= :fim",nativeQuery = true)
	ArrayList<Itmn_evento> getByNum_seq(@Param("inicio") Date inicio,@Param("fim") Date fim);
	
    @Query(value="SELECT count(itmn_alarme_id_alarme) as total FROM itmn_evento WHERE data_evt >= :inicio AND data_evt <= :fim AND itmn_alarme_id_alarme= :num_alarme",nativeQuery = true)
    long getByAlarme(@Param("inicio") Date inicio, @Param("fim") Date fim, @Param("num_alarme") int num_alarme);
}
