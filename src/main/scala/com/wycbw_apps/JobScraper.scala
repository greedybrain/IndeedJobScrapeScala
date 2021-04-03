package com.wycbw_apps

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

// responsibility = handle scraping and preparing data for distribution amongst other classes as needed
object JobScraper {
  // retrieving built url
  private val URL: String = URLBuild.getURL

  // get website html data
  private def getJobListing: Document = Jsoup.connect(URL).get()
  // get each job listing card
  def getJobCards: Elements = getJobListing.select("div.jobsearch-SerpJobCard")

}
