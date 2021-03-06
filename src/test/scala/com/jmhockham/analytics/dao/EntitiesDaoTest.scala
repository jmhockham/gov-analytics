package com.jmhockham.analytics.dao

import java.io.File

import org.scalatest.{FlatSpec, Matchers}
import org.json4s.jackson.JsonMethods.parse

class EntitiesDaoTest extends FlatSpec with Matchers {
  private val electionJson = new File(getClass.getResource("/election-summaries.json").getPath)
  "getElectionSummaries" should "parse the json correctly" in {
    val jValue = parse(electionJson)
    val electionSummaries = EntitiesDao.getElectionSummaries(jValue)

    electionSummaries.size shouldBe 2

    electionSummaries.head.resourceUrl shouldBe "http://data.parliament.uk/resources/730039"
    electionSummaries(1).resourceUrl shouldBe "http://data.parliament.uk/resources/694150"

    electionSummaries.head.electionType shouldBe "General Election"
    electionSummaries(1).electionType shouldBe "By-election"

    electionSummaries.head.date shouldBe "2017-06-08"
    electionSummaries(1).date shouldBe "2017-02-23"

    electionSummaries.head.label shouldBe "2017 General Election"
    electionSummaries(1).label shouldBe "23-Feb-2017 By-election"

  }
}
