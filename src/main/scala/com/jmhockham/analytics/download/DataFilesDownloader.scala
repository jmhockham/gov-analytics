package com.jmhockham.analytics.download

/**
  * Created by jmhockham on 12/09/17.
  */
object DataFilesDownloader extends App{

  def getElectionsJson: String = {
    val url = "http://lda.data.parliament.uk/elections.json?_view=Elections&_pageSize=376&_page=0"
    scala.io.Source.fromURL(url).mkString
  }

}
