package mesosphere.marathon
package core.flow

import org.rogach.scallop.ScallopConf

trait ReviveOffersConfig extends ScallopConf {

  lazy val reviveOffersForNewApps = toggle(
    "revive_offers_for_new_apps",
    descrYes = "(Default) Call reviveOffers for new or changed apps.",
    descrNo = "Disable reviveOffers for new or changed apps.",
    hidden = true,
    default = Some(true),
    prefix = "disable_")

  lazy val minReviveOffersInterval = opt[Long](
    "min_revive_offers_interval",
    descr = "Do not ask for all offers (also already seen ones) more often than this interval (ms).",
    default = Some(5000))

  lazy val reviveOffersRepetitions = opt[Int](
    "revive_offers_repetitions",
    descr = "Repeat every reviveOffer request this many times, delayed by the --min_revive_offers_interval.",
    default = Some(3))

  lazy val suppressOffers = toggle(
    "suppress_offers",
    default = Some(false),
    noshort = true,
    descrYes = "Suppress Mesos offers if Marathon has nothing to launch.",
    descrNo = "(Default) Offers will be continually declined for declineOfferDuration.",
    prefix = "disable_"
  )
}
