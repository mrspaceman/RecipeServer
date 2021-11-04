package uk.co.droidinactu.recipeviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
public class VersionController {

  @Value("${recipseserver.name:unknownApp}")
  private String name;

  @Value("${recipseserver.version:unknownVersion}")
  private String version;

  @GetMapping("/version")
  public String getVersion() {
    log.trace(this.getClass().getName() + ": Getting Application Version");
    return "{\"name\":\"" + name + "\",\"version\": \"" + version + "\"}";
  }

  public void calculateDaysBetweenDates() {
    log.trace(this.getClass().getName() + ": Calculating Days Between Dates");
    int daysBetween = 0;
  }
}
