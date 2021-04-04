package com.wycbw_apps

import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import scala.collection.mutable.ListBuffer

// responsibility = curate all jobs from scraped data, make objects out of them, and list them
object Jobs {

  private def getJobListings: ListBuffer[Job]  = {
    val listing: ListBuffer[Job] = ListBuffer()
    JobScraper.getJobCardsForEachPage.foreach(card => {
      val title: String = card.select("h2.title").text()
      val company: String = card.select("div.sjcl span.company").text()
      val rating: String = card.select("div.sjcl span.ratingsDisplay a span.ratingsContent").text()
      val location: String = if (card.select("div.sjcl div.location").text().nonEmpty) card.select("div.sjcl div.location").text() else "N/A"

      val jobSummaryList: Elements = card.select("div.summary ul li")
      val curatedJobSummaryList: ListBuffer[String] = ListBuffer()
      jobSummaryList.forEach(summary => curatedJobSummaryList += summary.text())

      listing += new Job(title, company, rating, location, curatedJobSummaryList)
    })
    listing
  }

  def listJobs(): Unit = {
    val jobListings: ListBuffer[Job] = getJobListings
    jobListings.foreach(job => {
      println("\n================================")
      println(s"Title: ${job.getTitle}")
      println(s"Company: ${job.getCompany}")
      println(s"Rating: ${job.getRating}")
      println(s"Location: ${job.getLocation}")
      println("****** Summary/Description ******")
      job.getJobSummary.foreach(summary => println(s"• ${summary}"))
      println("****** End ******")
    })
  }
}
