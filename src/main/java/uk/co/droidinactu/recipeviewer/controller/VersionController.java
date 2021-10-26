package uk.co.droidinactu.recipeviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
public class VersionController {

  @Value("${recipseserver.name:unknownApp}")
  String name;

  @Value("${recipseserver.version:unknownVersion}")
  String version;

  @GetMapping("/version")
  public String getVersion() {
    return "{\"name\":\"" + name + "\",\"version\": \"" + version + "\"}";
  }
}
