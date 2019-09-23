package com.github.zero_degrees.morning_routine.command

import com.github.zero_degrees.morning_routine.Temperature
import com.github.zero_degrees.morning_routine.Temperature._

case class PajamasCommand() extends Command {
    protected val validTemperatures: List[Temperature] = List(Hot, Cold)
    protected val incompatibleCommands: List[Command] = List()
    protected val hotPrerequisiteCommands: List[Command] = List()
    protected val coldPrerequisiteCommands: List[Command] = List()
    protected val hotMessage: String = "Removing PJs"
    protected val coldMessage: String = "Removing PJs"
}