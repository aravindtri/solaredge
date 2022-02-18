package com.automate.solarevcharging.solar.web.controller;

import com.automate.solarevcharging.solar.dto.SolarStateDTO;
import com.automate.solarevcharging.solar.facade.SolarStateRecorderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solaredge")
public class SolarEdgeController {

  private SolarStateRecorderFacade solarStateRecorderFacade;

  @GetMapping(value = "/state")
  public SolarStateDTO getSolarState() {
    return getSolarStateRecorderFacade().getSolarState();
  }

  protected SolarStateRecorderFacade getSolarStateRecorderFacade() {
    return solarStateRecorderFacade;
  }

  @Autowired
  public void setSolarStateRecorderFacade(
      SolarStateRecorderFacade solarStateRecorderFacade) {
    this.solarStateRecorderFacade = solarStateRecorderFacade;
  }
}
