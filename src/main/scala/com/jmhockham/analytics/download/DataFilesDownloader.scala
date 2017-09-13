package com.jmhockham.analytics.download

/**
  * Created by jmhockham on 12/09/17.
  */
object DataFilesDownloader extends App{

  def getElectionsJson: String = {
    callUrl("http://lda.data.parliament.uk/elections.json?_view=Elections&_pageSize=376&_page=0")
  }

  def getConstituenciesData: String = {
    callUrl(("http://lda.data.parliament.uk/constituencies.json")
  }

  private def callUrl(url: String): String = {
    scala.io.Source.fromURL(url).mkString
  }

}
