package com.github.zero_degrees.morning_routine

import com.github.zero_degrees.morning_routine.command.Command

object Application extends App {
    /**
     * Extract a list of command codes from the application's commandline arguments. Commas are optional.
     * 
     * @param args An array of commandline arguments
     * 
     * @return The parsed command codes
     */
    protected def getCommandCodesFromArgs(args: Array[String]): List[Int] = {
        val cleanArgString: String = args.tail.mkString(" ")
            .replaceFirst("[, ]+$", " ")
            .replaceAll("[, ]+", " ")

        if(!cleanArgString.matches("^[0-9 ]*$")) {
            throw new IllegalArgumentException("Command codes must be integers.")
        }
        
        cleanArgString.split(" +").toList.map(_.toInt)
    }
    
    /**
     * Simulates the morning routine.
     * 
     * @param args An array of commandline arguments
     * 
     * @return All commands that were executed, regardless of success. Execution stops after the first failure.
     */
    protected def runSimulation(args: Array[String]): List[Command] = {
        if(args.length == 0) {
            throw new IllegalArgumentException("Missing temperature argument.")
        }
        if(args.length == 1) {
            throw new IllegalArgumentException("Missing command code(s).")
        }

        val temperature: String = args(0)
        val commandCodes: List[Int] = getCommandCodesFromArgs(args)
        
        new Scenario(temperature, commandCodes).execute()
    }

    /**
     * Convert a list of commands into a single string.
     * 
     * @param commands The commands you want to stringify
     * 
     * @return A human-readable string
     */
    protected def commandsToString(commands: List[Command]): String = commands.map(_.toString).mkString(", ")
    
    try {
        val actions: List[Command] = runSimulation(args)

        println(commandsToString(actions))
    }
    catch {
        case e: Exception => println(e.getMessage())
    }
}