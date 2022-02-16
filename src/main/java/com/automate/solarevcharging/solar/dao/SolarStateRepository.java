package com.automate.solarevcharging.solar.dao;

import com.automate.solarevcharging.solar.dto.SolarStateDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarStateRepository extends JpaRepository<SolarStateDTO, Long> {

}
