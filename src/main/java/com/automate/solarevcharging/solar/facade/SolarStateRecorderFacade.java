package com.automate.solarevcharging.solar.facade;

import com.automate.solarevcharging.solar.dto.SolarStateDTO;

public interface SolarStateRecorderFacade {

  SolarStateDTO saveSolarState();

  SolarStateDTO getSolarState();
}
