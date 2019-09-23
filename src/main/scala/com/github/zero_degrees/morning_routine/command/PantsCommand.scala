package com.github.zero_degrees.morning_routine.command

import com.github.zero_degrees.morning_routine.Temperature
import com.github.zero_degrees.morning_routine.Temperature._

case class PantsCommand() extends Command {
    protected val validTemperatures: List[Temperature] = List(Hot, Cold)
    protected val incompatibleCommands: List[Command] = List(new FootwearCommand)
    protected val hotPrerequisiteCommands: List[Command] = List(new PajamasCommand)
    protected val coldPrerequisiteCommands: List[Command] = hotPrerequisiteCommands
    protected val hotMessage: String = "shorts"
    protected val coldMessage: String = "pants"
}