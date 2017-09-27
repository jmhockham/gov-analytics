package com.jmhockham.analytics.download

import org.scalatest._


/**
  * Created by jmhockham on 12/09/17.
  */
class DataFilesDownloaderTest extends FlatSpec with Matchers {
  //TODO test the API links, and that the data is in an expected format
  "getElectionsJson" should "not return null" in {
    val json = DataFilesDownloader.getElectionsJson
    json should not be null
  }

  "getElectionSummaries" should "return a list of case classes from valid json" in {

  }

  "getConstituenciesData" should "not return null" in {
    val json = DataFilesDownloader.getConstituenciesData
    json should not be null
  }
}

