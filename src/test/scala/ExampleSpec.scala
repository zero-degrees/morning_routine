package org.scalatest.examples.freespec

import com.github.zero_degrees.morning_routine.command.Command

class ExampleSpec extends BaseSpec {
    "The application" - {
        "should pass example tests" - {
            "#1" in {
                val args: Array[String] = "HOT 8, 6, 4, 2, 1, 7".split(" ")
                val correctAnswer: String = "Removing PJs, shorts, shirt, sunglasses, sandals, leaving house"
                val actions: List[Command] = runSimulation(args)
                val answer: String = commandsToString(actions)
                
                assert(answer == correctAnswer)
            }

            "#2" in {
                val args: Array[String] = "COLD 8, 6, 3, 4, 2, 5, 1, 7".split(" ")
                val correctAnswer: String = "Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house"
                val actions: List[Command] = runSimulation(args)
                val answer: String = commandsToString(actions)
                
                assert(answer == correctAnswer)
            }

            "#3" in {
                val args: Array[String] = "HOT 8, 6, 6".split(" ")
                val correctAnswer: String = "Removing PJs, shorts, fail"
                val actions: List[Command] = runSimulation(args)
                val answer: String = commandsToString(actions)
                
                assert(answer == correctAnswer)
            }

            "#4" in {
                val args: Array[String] = "HOT 8, 6, 3".split(" ")
                val correctAnswer: String = "Removing PJs, shorts, fail"
                val actions: List[Command] = runSimulation(args)
                val answer: String = commandsToString(actions)
                
                assert(answer == correctAnswer)
            }

            "#5" in {
                val args: Array[String] = "COLD 8, 6, 3, 4, 2, 5, 7".split(" ")
                val correctAnswer: String = "Removing PJs, pants, socks, shirt, hat, jacket, fail"
                val actions: List[Command] = runSimulation(args)
                val answer: String = commandsToString(actions)
                
                assert(answer == correctAnswer)
            }

            "#6" in {
                val args: Array[String] = "COLD 6".split(" ")
                val correctAnswer: String = "fail"
                val actions: List[Command] = runSimulation(args)
                val answer: String = commandsToString(actions)
                
                assert(answer == correctAnswer)
            }
        }
    }
}