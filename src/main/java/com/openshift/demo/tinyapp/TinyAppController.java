package com.openshift.demo.tinyapp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinyAppController {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_MAGNETA = "\u001b[35m";
  private static final String TEMPLATE = "[ %tT ] TinyApp pod=%s status=OK version=" + ANSI_MAGNETA + "%s" + ANSI_RESET + "\n";

  @Value("${pod.name}")
  private String podName;

  @Value("${version}")
  private String appVersion;

  @RequestMapping("/api/status")
  public String status() {
      return String.format(TEMPLATE, new Date(), podName, appVersion);
  }
}