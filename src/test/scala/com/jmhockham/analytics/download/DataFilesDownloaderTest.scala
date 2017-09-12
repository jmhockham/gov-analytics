package com.jmhockham.analytics.download

import org.scalatest._


/**
  * Created by jmhockham on 12/09/17.
  */
class DataFilesDownloaderTest extends FlatSpec with Matchers {
  //TODO test the API links, and that the data is in an expected format
  "getElectionsJson" should "not return null" in {
    DataFilesDownloader.getElectionsJson should not be null
  }
}

