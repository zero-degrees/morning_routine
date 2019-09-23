package org.scalatest.examples.freespec

import com.github.zero_degrees.morning_routine.Temperature
import com.github.zero_degrees.morning_routine.Temperature._
import com.github.zero_degrees.morning_routine.command._

class CommandSpec extends BaseSpec {
    case object TotallyNotAFakeTemperature extends Temperature

    "A Command" - {
        "should give a failure message when unsuccessful" in {
            val previousActions: List[Command] = List()
            val command: Command = (new LeaveCommand).attempt(previousActions)

            assert(command.toString() == "fail")
        }

        "should give a temperature-dependent message when successful" in {
            val previousActions: List[Command] = List(new PajamasCommand)
            val hotCommand: Command = (new FootwearCommand).setTemperature(Hot)
                .attempt(previousActions)
            val coldCommand: Command = (new FootwearCommand).setTemperature(Cold)
                .attempt(previousActions)

            assert(hotCommand.toString() == "sandals")
            assert(coldCommand.toString() == "boots")
        }

        "should fail in inappropriate temperatures" in {
            val previousActions: List[Command] = List(new PajamasCommand)
            val hotCommand: Command = (new SocksCommand).setTemperature(Hot)
                .attempt(previousActions)
            val coldCommand: Command = (new SocksCommand).setTemperature(Cold)
                .attempt(previousActions)


            assert(hotCommand.toString() == "fail")
            assert(coldCommand.toString() == "socks")
        }

        "should succeed only when temperature-dependent prerequisites are not met" in {
            val previousColdActions: List[Command] = List(
                new FootwearCommand,
                new HeadwearCommand,
                new SocksCommand,
                new ShirtCommand,
                new JacketCommand,
                new PantsCommand,
                new PajamasCommand
            )
            val previousHotActions: List[Command] = List(
                new FootwearCommand,
                new HeadwearCommand,
                new ShirtCommand,
                new PantsCommand,
                new PajamasCommand
            )
            val goodHotCommand: Command = (new LeaveCommand).setTemperature(Hot)
                .attempt(previousHotActions)
            val badColdCommand: Command = (new LeaveCommand).setTemperature(Cold)
                .attempt(previousHotActions)
            val goodColdCommand: Command = (new LeaveCommand).setTemperature(Cold)
                .attempt(previousColdActions)


            assert(goodHotCommand.toString() == "leaving house")
            assert(badColdCommand.toString() == "fail")
            assert(goodColdCommand.toString() == "leaving house")
        }

        "should complain when passed a fake temperature" in {
            val previousActions: List[Command] = List()
            val command: Command = (new PajamasCommand).setTemperature(TotallyNotAFakeTemperature)
                .setSuccess(true)

            assertThrows[Exception](command.toString())
        }
    }
}