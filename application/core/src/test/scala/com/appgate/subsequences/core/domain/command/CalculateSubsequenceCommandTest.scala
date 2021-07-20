package com.appgate.subsequences.core.domain.command

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

    it("should return false when command is validated if original string is empty or invalid") {

      forAll(invalidStringGen, validStringGen()) {

        (baseString, subsequenceToLookFor) => {

          Given(s"[${baseString}] as an invalid base string")
          And(s"[${subsequenceToLookFor}] as subsequence to look for")

          When("a CalculateSubsequenceCommand is created")
          val command =  new CalculateSubsequencesCommand(baseString, subsequenceToLookFor)
          And("command is validated")
          val validation = command.isValid

          Then("validation should be false")
          validation shouldBe false
        }
      }
    }

    it("should return false when command is validated if subsequence to look for is empty or invalid") {

      forAll(validStringGen(), invalidStringGen) {

        (baseString, subsequenceToLookFor) => {

          Given(s"[${baseString}] as base string")
          And(s"[${subsequenceToLookFor}] as an invalid subsequence to look for")

          When("a CalculateSubsequenceCommand is created")
          val command = new CalculateSubsequencesCommand(baseString, subsequenceToLookFor)
          And("command is validated")
          val validation = command.isValid

          Then("validation should be false")
          validation shouldBe false
        }
      }
    }

    it("should return false when command is validated if the subsequence to look for has a bigger length than original string") {

      forAll(validStringGen(12), validStringGen(13)) {

        (originalString, subsequenceToLookFor) => {

          Given(s"[${originalString}] as original string")
          And(s"[${subsequenceToLookFor}] as subsequence to look for")

          When("a CalculateSubsequenceCommand is created")
          val command = new CalculateSubsequencesCommand(originalString, subsequenceToLookFor)
          And("command is validated")
          val validation = command.isValid

          Then("validation should be false")
          validation shouldBe false
        }
      }
    }
  }
}
