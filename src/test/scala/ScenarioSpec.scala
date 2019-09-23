package org.scalatest.examples.freespec

import com.github.zero_degrees.morning_routine.command.Command
import com.github.zero_degrees.morning_routine.Scenario

class ScenarioSpec extends BaseSpec {
    "A Scenario" - {
        "should refuse to run a command multiple times" in {
            val scenario: Scenario = new Scenario("HOT", List(8, 8, 8, 8, 8))
            val executedCommands: List[Command] = scenario.execute

            assert(executedCommands.length == 2)
            assert(executedCommands(0).toString == "Removing PJs")
            assert(executedCommands(1).toString == "fail")
        }
    }
}