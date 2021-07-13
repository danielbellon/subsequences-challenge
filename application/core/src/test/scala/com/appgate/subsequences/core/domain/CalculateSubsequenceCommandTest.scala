package com.appgate.subsequences.core.domain

import com.appgate.subsequences.core.domain.CalculateSubsequencesCommand.InvalidCommandException
import com.appgate.subsequences.core.util.UnitTest
import org.scalacheck.Gen

/**
 * Test scenarios around [[CalculateSubsequencesCommand]]
 *
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
class CalculateSubsequenceCommandTest extends UnitTest {

  describe("Calculate Subsequence Command") {

    val invalidStringGen = Gen.oneOf(null, "")

    def validStringGen(lineLength: Int = 10) = Gen.listOfN(lineLength, Gen.alphaNumChar).map(_.mkString)

    it("should raise invalid command exception if original string is empty or invalid") {

      forAll(invalidStringGen, validStringGen()) {

        (originalString, subsequenceToLookFor) => {

          Given(s"[${originalString}] as original string")
          And(s"[${subsequenceToLookFor}] as subsequence to look for")

          When("a CalculateSubsequenceCommand is created")
          val exception = intercept[Exception] {
            new CalculateSubsequencesCommand(originalString, subsequenceToLookFor)
          }

          Then("an InvalidCommandException should be thrown ")
          exception shouldBe a[InvalidCommandException]
        }
      }
    }

    it("should raise invalid command exception if subsequence to look for is empty or invalid") {

      forAll(validStringGen(), invalidStringGen) {

        (originalString, subsequenceToLookFor) => {

          Given(s"[${originalString}] as original string")
          And(s"[${subsequenceToLookFor}] as subsequence to look for")

          When("a CalculateSubsequenceCommand is created")
          val exception = intercept[Exception] {
            new CalculateSubsequencesCommand(originalString, subsequenceToLookFor)
          }

          Then("an InvalidCommandException should be thrown ")
          exception shouldBe a[InvalidCommandException]
        }
      }
    }

    it("should raise an invalid command exception if the subsequence to look for has a bigger length than original string") {

      forAll(validStringGen(12), validStringGen(13)) {

        (originalString, subsequenceToLookFor) => {

          Given(s"[${originalString}] as original string")
          And(s"[${subsequenceToLookFor}] as subsequence to look for")

          When("a CalculateSubsequenceCommand is created")
          val exception = intercept[Exception] {
            new CalculateSubsequencesCommand(originalString, subsequenceToLookFor)
          }

          Then("an InvalidCommandException should be thrown ")
          exception shouldBe a[InvalidCommandException]
        }
      }
    }
  }
}
