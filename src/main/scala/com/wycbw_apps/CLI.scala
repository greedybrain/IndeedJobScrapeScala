package com.wycbw_apps

import scala.io.StdIn.{readInt, readLine}

object CLI {
  def getJobTitle: String = {
    var jobTitle: String = ""

    do {
      print("Job title: ")
      jobTitle = readLine()
      if (jobTitle.isEmpty) println("Job title required!")
    } while (jobTitle.isEmpty || jobTitle.matches(".*\\d+.*"))

    jobTitle
  }

  def getDesiredSalary: String = {
    var desiredSalary: String = ""

    do {
      print("Desired salary: ")
      desiredSalary = readLine()
      if (desiredSalary.isEmpty) println("Desired salary required!")
    } while (desiredSalary.isEmpty)

    desiredSalary
  }

  def getLocation: String = {
    var location: String = ""

    do {
      print("Location: ")
      location = readLine()
      if (location.isEmpty) println("Location required!")
    } while (location.isEmpty)

    location
  }

  def getJobType: String = {
    var jobType: Int = 0

    println("1. Part-time\n2. Full-time")
    print("Choose number representing the job type (Optional - press enter to skip): ")
    jobType = readInt()

    jobType match {
      case 1 => "parttime"
      case 2 => "fulltime"
      case _ => ""
    }
  }

  def getExpLevel: String = {
    var expLevel: Int = 0

    println("1. Entry level\n2. Mid level\n3. Senior level")
    print("Choose the number representing the experience level (Optional - press enter to skip): ")
    expLevel = readInt()

    expLevel match {
      case 1 => "entry_level"
      case 2 => "mid_level"
      case 3 => "senior_level"
      case _ => ""
    }
  }

  def getDatePosted: String = {
    var datePosted: String = ""

    println("1. Last 24 hours\n2. Last 3 days\n3. Last 7 days\n4. Last 14 days")
    print("Date posted (Optional - press enter to skip): ")
    datePosted = readLine()

    datePosted match {
      case "1" => "1"
      case "2" => "3"
      case "3" => "7"
      case "4" => "14"
      case _ => ""
    }
  }

  def run(): Unit = Jobs.listJobs()

}
