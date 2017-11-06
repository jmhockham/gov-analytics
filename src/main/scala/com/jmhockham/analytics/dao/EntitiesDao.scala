package com.jmhockham.analytics.dao

import com.jmhockham.analytics.model.ElectionSummary
import org.json4s._

object EntitiesDao {

  implicit val formats = DefaultFormats

  def getElectionSummaries(json: JValue) = {
    val electionSummaries = (json \\ "items").children.map { x =>
      ElectionSummary.fromJson(x)
    }
    electionSummaries
  }
}
