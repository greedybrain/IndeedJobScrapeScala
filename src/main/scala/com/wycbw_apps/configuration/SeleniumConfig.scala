package com.wycbw_apps.configuration

import org.openqa.selenium.chrome.ChromeDriver

object SeleniumConfig {
  private final val chromeDriver: String = "webdriver.chrome.driver"
  private final val chromeDriverExecutable: String = "/Users/whatyoucodingboutwillis/bin/chromedriver"
}

class SeleniumConfig {
  def postConstruct(): Unit = System.setProperty(SeleniumConfig.chromeDriver, SeleniumConfig.chromeDriverExecutable)
  def driver: ChromeDriver = new ChromeDriver()
}

