package com.appgate.subsequences.core.domain.service

import com.appgate.subsequences.core.domain.command.CalculateSubsequencesCommand
import com.appgate.subsequences.core.util.UnitTest

import scala.language.postfixOps

/**
 * Test scenarios around [[KnapsackCalculatorTest]]
 *
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
class KnapsackCalculatorTest extends UnitTest {

  describe("Subsequence Calculator") {

    val baseString = "rabbbit"
    val targetSubsequence = "rabbit"

    it("should calculate subsequences") {

      Given(s"a CalculateSubsequencesCommand with ${baseString} as base string")
      And(s"${targetSubsequence} as target subsequence")
      And("a KnapsackCalculator")
      val calculator = new KnapsackCalculator()

      When("getSubsequencesCount() is called")
      val count = calculator.getSubsequences(baseString, targetSubsequence)

      Then("count should be 3")
      count shouldBe 3
      baseString.indexOf('b') shouldBe 2

    }
  }
}
