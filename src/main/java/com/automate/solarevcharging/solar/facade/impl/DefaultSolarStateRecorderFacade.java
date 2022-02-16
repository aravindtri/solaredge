package com.automate.solarevcharging.solar.facade.impl;

import com.automate.solarevcharging.solar.converter.CurrentSolarStateToSolarStateDTOConverter;
import com.automate.solarevcharging.solar.dao.SolarStateRepository;
import com.automate.solarevcharging.solar.dto.SolarStateDTO;
import com.automate.solarevcharging.solar.facade.SolarStateRecorderFacade;
import com.automate.solarevcharging.solar.service.SolarEdgeService;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSolarStateRecorderFacade implements SolarStateRecorderFacade {

  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private SolarEdgeService solarEdgeService;
  private CurrentSolarStateToSolarStateDTOConverter currentSolarStateToSolarStateDTOConverter;
  private SolarStateRepository solarStateRepository;

  @Override
  public SolarStateDTO saveSolarState() {
    LOG.debug("Calling SE Service and saving..");
    return getSolarStateRepository().save(getCurrentSolarStateToSolarStateDTOConverter()
        .convert(getSolarEdgeService().getCurrentSolarState()));
  }

  protected SolarEdgeService getSolarEdgeService() {
    return solarEdgeService;
  }

  public void setSolarEdgeService(
      SolarEdgeService solarEdgeService) {
    this.solarEdgeService = solarEdgeService;
  }

  public CurrentSolarStateToSolarStateDTOConverter getCurrentSolarStateToSolarStateDTOConverter() {
    return currentSolarStateToSolarStateDTOConverter;
  }

  public void setCurrentSolarStateToSolarStateDTOConverter(
      CurrentSolarStateToSolarStateDTOConverter currentSolarStateToSolarStateDTOConverter) {
    this.currentSolarStateToSolarStateDTOConverter = currentSolarStateToSolarStateDTOConverter;
  }

  protected SolarStateRepository getSolarStateRepository() {
    return solarStateRepository;
  }

  public void setSolarStateRepository(
      SolarStateRepository solarStateRepository) {
    this.solarStateRepository = solarStateRepository;
  }
}
