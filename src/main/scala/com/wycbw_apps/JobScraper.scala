package com.wycbw_apps

import org.jsoup.Jsoup
import org.jsoup.nodes.{Document, Element}
import org.jsoup.select.Elements

import scala.collection.mutable.ListBuffer

// responsibility = handle scraping and preparing data for distribution amongst other classes as needed
object JobScraper {
  // retrieving built url
  private val URL: String = URLBuild.getURL
  val allCards: ListBuffer[Element] = ListBuffer()

  // get website html data
  private def getDataDocument(url: String): Document = Jsoup.connect(url).get()

  // get each job listing card
  def jobCardsFrom(data: Document): Unit = {
    val jobCards: Elements = data.select("div.jobsearch-SerpJobCard")
    jobCards.forEach(card => allCards += card)
  }

  def getJobCardsForEachPage: ListBuffer[Element] = {
    var dataDocument: Document = getDataDocument(URL)
    jobCardsFrom(dataDocument)
    if (containsPagination(dataDocument)) {
      val paginationList: Elements = dataDocument.select("div.pagination ul.pagination-list li a")
      paginationList.forEach(pageItem => {
        val completeLink = s"https://www.indeed.com/${pageItem.attr("href")}"
        dataDocument = getDataDocument(completeLink)
        jobCardsFrom(dataDocument)
      })
    }
    allCards
  }

  // check if page has pagination
  def containsPagination(data: Document): Boolean = {
    data.select("*").hasClass("pagination") ||
      data.select("*").hasClass("pagination-list")
  }

}
