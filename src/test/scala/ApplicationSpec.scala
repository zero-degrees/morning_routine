package org.scalatest.examples.freespec

import java.io.ByteArrayOutputStream

import com.github.zero_degrees.morning_routine.CommandRegistry
import com.github.zero_degrees.morning_routine.command._

class ApplicationSpec extends BaseSpec {
    "The Application" - {
        "should extract command codes from commandline arguments with or without commas" in {
            val args: Array[String] = Array("HOT", "8,", "1", "2")
            val correctResult: List[Int] = List(8, 1, 2)

            assert(getCommandCodesFromArgs(args) == correctResult)
        }
        
        "should complain when passed non-integer command codes" in {
            val args: Array[String] = Array("HOT", "a,", "1", "2")

            assertThrows[IllegalArgumentException](getCommandCodesFromArgs(args))
        }

        "should run simulations from the main method" in {
            val correctResult = "Removing PJs, sandals, sunglasses"
            val capture = new ByteArrayOutputStream

            Console.withOut(capture) {
                main(Array[String]("HOT", "8,", "1,", "2,"))
            }

            assert(capture.toString().trim == correctResult)
        }

        "should handle exceptions in the main method" in {
            val exceptionFragment = "Missing temperature argument."
            val capture = new ByteArrayOutputStream

            Console.withOut(capture) {
                main(Array[String]())
            }

            assert(capture.toString().trim == exceptionFragment)
        }

        "should complain when" - {
            "passed no arguments" in {
                val args: Array[String] = Array()
                
                assertThrows[IllegalArgumentException](runSimulation(args))
            }
        
            "missing command codes" in {
                val args: Array[String] = Array("HOT")
                
                assertThrows[IllegalArgumentException](runSimulation(args))
            }
        }

        "should convert commands into a human-readable string" in {
            val previousActions: List[Command] = List(new PajamasCommand)
            val commands: List[Command] = List[Command](
                (new FootwearCommand).attempt(previousActions),
                (new ShirtCommand).attempt(previousActions),
                (new HeadwearCommand).attempt(previousActions)
            )
            val result: String = commandsToString(commands)
            val correctResult: String = "sandals, shirt, sunglasses"

            assert(result == correctResult)
        }
    }
}