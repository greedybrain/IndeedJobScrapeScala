package com.wycbw_apps

import com.wycbw_apps.CLI.{getDatePosted, getDesiredSalary, getExpLevel, getJobTitle, getJobType, getLocation}

class URLBuild(
                private val jobTitle: String,
                private val desiredSalary: String,
                private val location: String,
                private val jobType: String,
                private val expLevel: String,
                private val datePosted: String) {

  // builds url string
  def thenBuildURL: String =
    "https://www.indeed.com/jobs?q=" + jobTitle + "$" + desiredSalary + "&l=" + location + "&jt=" + jobType + "&explvl=" + expLevel + "&fromage=" + datePosted
}

// companion to define static members for URLBuild class
object URLBuild {
  // gets url params from new instance of URLBuild then calls "thenBuildURL" method
  def getURL: String = {
    val getObjectParams = new URLBuild(getJobTitle, getDesiredSalary, getLocation, getJobType, getExpLevel, getDatePosted)
    getObjectParams.thenBuildURL
  }
}
