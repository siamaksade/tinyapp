package com.openshift.demo.tinyapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinyAppController {
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String[] ANSI_COLORS = {"\u001b[35m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[36m"};
  private static final String TEMPLATE = "TinyApp pod=%s status=OK version=%s\n";
  private static final Logger LOG = LoggerFactory.getLogger(TinyAppController.class);

  @Value("${pod.name}")
  private String podName;

  @Value("${version}")
  private String appVersion;

  @RequestMapping("/version")
  public String status(@RequestHeader(value="User-Agent") String userAgent) {
    String version = userAgent.contains("curl") ? color(appVersion) : appVersion;
    String response = String.format(TEMPLATE, podName, version);
    LOG.info(response);
    return response;
  }

  private String color(String appVersion) {
    return ANSI_COLORS[appVersion.hashCode() % ANSI_COLORS.length] + appVersion + ANSI_RESET;
  }
}