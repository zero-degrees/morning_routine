package com.github.zero_degrees.morning_routine.command

import com.github.zero_degrees.morning_routine._
import com.github.zero_degrees.morning_routine.Temperature._

/**
 * Serves as the base class for all commands. This allows the commands required by this coding challenge to be
 * represented as data, but gives the flexibility to override their business logic as needed by some imaginary, future
 * developer.
 */
abstract class Command {
    /** The temperature at which the command is being attempted **/
    protected var temperature: Temperature = Hot

    /** The temperatures at which the command is might succeed **/
    protected val validTemperatures: List[Temperature]
    
    /** Commands that cannot be run before this one **/
    protected val incompatibleCommands: List[Command]

    /** Commands that are rerequisites in hot weather **/
    protected val hotPrerequisiteCommands: List[Command]

    /** Commands that are rerequisites in cold weather **/
    protected val coldPrerequisiteCommands: List[Command]

    /** The success message to be displayed hot weather **/
    protected val hotMessage: String

    /** The success message to be displayed cold weather **/
    protected val coldMessage: String

    /** The failure message **/
    protected val failMessage: String = "fail"

    /** Was the command successfully executed? **/
    protected var success: Boolean = false

    /**
     * Set the command's current temperature.
     * 
     * @return This command instance
     */
    def setTemperature(temperature: Temperature): Command = {
        this.temperature = temperature

        this
    }

    /**
     * Change the success flag.  Mainly here for testing purposes.
     * 
     * @return This command instance
     */
    def setSuccess(success: Boolean): Command = {
        this.success = success

        this
    }

    /**
     * Check if this command was successful.
     * 
     * @return
     */
    def getSuccess(): Boolean = success

    /**
     * Check if the temperature is valid for this command.
     * 
     * @return
     */
    protected def isValidTemperature(): Boolean = validTemperatures.contains(temperature)

    /**
     * Check if we already performed this command.
     * 
     * @param previousActions The actions we've already performed
     * 
     * @return
     */
    protected def alreadyDidThis(previousActions: List[Command]): Boolean =
        previousActions.filter(_ == this).length > 0

    /**
     * Get the temperature-appropriate prerequisite commands.
     * 
     * @return
     */
    protected def getPrerequisiteCommands(): List[Command] =
        temperature match {
            case Hot =>
                hotPrerequisiteCommands
            case Cold =>
                coldPrerequisiteCommands
        }

    /**
     * Check if all of the prerequisite commands have been executed.
     * 
     * @return
     */
    protected def checkPrerequisites(previousActions: List[Command]): Boolean =
        getPrerequisiteCommands.foldLeft(true)((fulfilled, command) => fulfilled && previousActions.contains(command))

    /**
     * Attempt to perform this action.
     * 
     * @param previousActions The actions we've already performed
     * 
     * @return This command instance
     */
    def attempt(previousActions: List[Command]): Command =
        setSuccess(
            !alreadyDidThis(previousActions) &&
            isValidTemperature &&
            checkPrerequisites(previousActions) &&
            previousActions.intersect(incompatibleCommands).length == 0
        )
    
    /**
     * Convert this command into a temperature-appropriate string.
     * 
     * @return A temperature-appropriate message
     */
    override def toString(): String = {
        if(success) {
            temperature match {
                case Hot =>
                    hotMessage
                case Cold =>
                    coldMessage
                case _ =>       //basically impossible to reach unless you just added a new temperature
                    throw new Exception("Invalid Temperature")
            }
        }
        else {
            failMessage
        }
    }
}