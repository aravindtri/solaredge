package com.automate.solarevcharging.solar.converter;

import com.automate.solarevcharging.generated.CurrentSolarState;
import com.automate.solarevcharging.solar.dto.SolarStateDTO;
import java.lang.invoke.MethodHandles;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;


public class CurrentSolarStateToSolarStateDTOConverter implements
    Converter<CurrentSolarState, SolarStateDTO> {

  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private DateTimeFormatter patternedDateTimeFormatter;
  private String pattern;
  private String timeZoneOffset;

  @Override
  public SolarStateDTO convert(CurrentSolarState source) {
    LOG.info("CurrentSolarState: {}", source);
    SolarStateDTO solarStateDTO = getSolarStateDTO();
    solarStateDTO.setPower(source.getOverview().getCurrentPower().getPower());
    solarStateDTO.setUpdatedTime(convertStringToDate(source.getOverview().getLastUpdateTime()));
    solarStateDTO.setCumulativePowerForToday(source.getOverview().getLastDayData().getEnergy());
    LOG.info("SolarStateDTO: {}", solarStateDTO);
    return solarStateDTO;
  }

  private ZonedDateTime convertStringToDate(String lastUpdateTime) {
    return ZonedDateTime.parse(lastUpdateTime + " " + timeZoneOffset, patternedDateTimeFormatter);
  }

  protected SolarStateDTO getSolarStateDTO() {
    return new SolarStateDTO();
  }

  protected DateTimeFormatter getPatternedDateTimeFormatter() {
    return patternedDateTimeFormatter;
  }

  public void setPatternedDateTimeFormatter(DateTimeFormatter patternedDateTimeFormatter) {
    this.patternedDateTimeFormatter = patternedDateTimeFormatter;
  }

  protected String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  protected String getTimeZoneOffset() {
    return timeZoneOffset;
  }

  public void setTimeZoneOffset(String timeZoneOffset) {
    this.timeZoneOffset = timeZoneOffset;
  }
}
