package com.openshift.demo.tinyapp;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinyAppController {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  private static final String TEMPLATE = "[ %tT ] TinyApp pod=%s status=OK version=" + ANSI_YELLOW + "%s" + ANSI_RESET + "\n";

  @RequestMapping("/api/status")
  public String status() {
      return String.format(TEMPLATE, new Date(), System.getenv("POD_NAME"), System.getenv("VERSION"));
  }
}