package org.scalatest.examples.freespec

import org.scalatest.{ FreeSpec, PrivateMethodTester }

import com.github.zero_degrees.morning_routine.Application
import com.github.zero_degrees.morning_routine.command.Command

/**
 * Serves as the base for test classes. Provides some common methods for convenience.
 */
abstract class BaseSpec extends FreeSpec with PrivateMethodTester {
    /**
     * Expose the Application's main method.
     * 
     * @param args An array of commandline arguments
     * 
     * @return
     */
    protected def main(args: Array[String]): Unit = {
        val privateMethod = PrivateMethod[Unit]('main)
        Application invokePrivate privateMethod(args)
    }

    /**
     * Expose the Application's getCommandCodesFromArgs method.
     * 
     * @param args An array of commandline arguments
     * 
     * @return
     */
    protected def getCommandCodesFromArgs(args: Array[String]): List[Int] = {
        val privateMethod = PrivateMethod[List[Int]]('getCommandCodesFromArgs)
        Application invokePrivate privateMethod(args)
    }

    /**
     * Expose the Application's runSimulation method.
     * 
     * @param args An array of commandline arguments
     * 
     * @return All commands that were executed, regardless of success. Execution stops after the first failure.
     */
    protected def runSimulation(args: Array[String]): List[Command] = {
        val privateMethod = PrivateMethod[List[Command]]('runSimulation)
        Application invokePrivate privateMethod(args)
    }

    /**
     * Expose the Application's commandsToString method.
     * 
     * @param commands The commands you want to stringify
     * 
     * @return A human-readable string
     */
    protected def commandsToString(commands: List[Command]): String = {
        val privateMethod = PrivateMethod[String]('commandsToString)
        Application invokePrivate privateMethod(commands)
    }
}