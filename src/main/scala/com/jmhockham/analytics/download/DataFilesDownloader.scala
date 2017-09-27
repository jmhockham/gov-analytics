package com.jmhockham.analytics.download

import org.json4s._
import org.json4s.jackson.JsonMethods._

/**
  * Created by jmhockham on 12/09/17.
  */
object DataFilesDownloader extends App {

  implicit val formats = DefaultFormats

  def getElectionsJson: String = {
    val json = callUrl("http://lda.data.parliament.uk/elections.json?_view=Elections&_pageSize=376&_page=0")
    getElectionSummaries(json)
    json
  }

  def getElectionSummaries(json: String) = {
    val parsedJson = parse(json)
    val electionSummaries = (parsedJson \\ "items").children.map { x =>
      x.extract[List[ElectionSummary]]
    }
    electionSummaries
  }

  def getConstituenciesData: String = {
    val json = callUrl("http://lda.data.parliament.uk/constituencies.json")
    json
  }

  private def callUrl(url: String): String = {
    scala.io.Source.fromURL(url).mkString
  }

}
