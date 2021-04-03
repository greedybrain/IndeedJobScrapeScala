package com.wycbw_apps

import scala.collection.mutable.ListBuffer

// responsibility = define what a job is
class Job(
                private var title: String,
                private var company: String,
                private var rating: String,
                private var location: String,
                private var jobSummary: ListBuffer[String],
              ) {

  // GETTERS AND SETTERS
  def getTitle: String = title
  def getCompany: String = company
  def getRating: String = rating
  def getLocation: String = location
  def getJobSummary: ListBuffer[String] = jobSummary
}
