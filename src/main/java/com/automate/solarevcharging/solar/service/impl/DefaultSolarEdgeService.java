package com.automate.solarevcharging.solar.service.impl;

import com.automate.solarevcharging.generated.CurrentSolarState;
import com.automate.solarevcharging.solar.service.SolarEdgeService;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DefaultSolarEdgeService implements SolarEdgeService {

  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private String currentStateUrl;
  private RestTemplate solarEdgeRestTemplate;

  @Override
  public CurrentSolarState getCurrentSolarState() {
    LOG.debug("Calling SE Endpoint");
    ResponseEntity<CurrentSolarState> responseEntity = getSolarEdgeRestTemplate()
        .getForEntity(getCurrentStateUrl(), CurrentSolarState.class);
    CurrentSolarState currentSolarState = responseEntity.getBody();
    LOG.info("Current Solar state response: {}", currentSolarState);
    return currentSolarState;
  }

  protected String getCurrentStateUrl() {
    return currentStateUrl;
  }

  public void setCurrentStateUrl(String currentStateUrl) {
    this.currentStateUrl = currentStateUrl;
  }

  protected RestTemplate getSolarEdgeRestTemplate() {
    return solarEdgeRestTemplate;
  }

  public void setSolarEdgeRestTemplate(RestTemplate solarEdgeRestTemplate) {
    this.solarEdgeRestTemplate = solarEdgeRestTemplate;
  }
}
