package com.appgate.subsequences.core.util

import org.scalacheck.Shrink
import org.scalatest.{FunSpecLike, GivenWhenThen, Matchers}
import org.scalatestplus.easymock.EasyMockSugar
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * Base configuration for unit tests
 *
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
trait UnitTest extends FunSpecLike
  with GivenWhenThen
  with Matchers
  with ScalaCheckPropertyChecks
  with EasyMockSugar {

  // Scala check configurations
  implicit override val generatorDrivenConfig: PropertyCheckConfiguration = PropertyCheckConfiguration(minSuccessful = 5, minSize = 3)
  implicit val disableStringShrink: Shrink[String] = Shrink(_ => Stream.empty)
  implicit val disableDoubleShrink: Shrink[Double] = Shrink(_ => Stream.empty)
  implicit val disableIntShrink: Shrink[Int] = Shrink(_ => Stream.empty)
  val timeoutSeconds = 5

}
