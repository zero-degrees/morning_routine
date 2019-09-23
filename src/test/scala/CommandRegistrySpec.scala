package org.scalatest.examples.freespec

import com.github.zero_degrees.morning_routine.CommandRegistry
import com.github.zero_degrees.morning_routine.command.Command

class CommandRegistrySpec extends BaseSpec {
    "The Command Registry" - {
        "should load a command" in {
            assert(CommandRegistry.findCommand(1).isInstanceOf[Command])
        }
        
        "should complain when passed an invalid code" in {
            assertThrows[IllegalArgumentException](CommandRegistry.findCommand(-1))
        }
    }
}