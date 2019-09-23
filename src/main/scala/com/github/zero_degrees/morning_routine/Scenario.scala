package com.github.zero_degrees.morning_routine

import com.github.zero_degrees.morning_routine.command.Command

/**
 * Represents a scenario, including temperature and commands.
 */
class Scenario(temperatureString: String, commandCodes: List[Int]) {
    val temperature: Temperature = Temperature.fromString(temperatureString)

    /**
     * Execute the scenario.
     * 
     * @return A list of all executed commands
     */
    def execute(): List[Command] =
        commandCodes
            .foldLeft(List[Command]())((actions: List[Command], commandCode: Int) => {
                if(failed(actions))
                    actions     //this series of commands already failed
                else {
                    val command: Command = getCommand(commandCode)
                    
                    actions :+ command.attempt(actions)
                }
            })
    
    /**
     * Get the specified command from the registry.
     * 
     * @return A command
     */
    protected def getCommand(code: Int): Command =
        CommandRegistry.findCommand(code)
            .setTemperature(temperature)

    /**
     * Check if the scenario failed yet.
     * 
     * @return
     */
    protected def failed(commands: List[Command]): Boolean = !(commands.length == 0 || commands.last.getSuccess)
}