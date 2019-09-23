package com.github.zero_degrees.morning_routine.command

import com.github.zero_degrees.morning_routine.Temperature
import com.github.zero_degrees.morning_routine.Temperature._

case class SocksCommand() extends Command {
    protected val validTemperatures: List[Temperature] = List(Cold)
    protected val incompatibleCommands: List[Command] = List(new FootwearCommand)
    protected val hotPrerequisiteCommands: List[Command] = List()
    protected val coldPrerequisiteCommands: List[Command] = List(new PajamasCommand)
    protected val hotMessage: String = ""
    protected val coldMessage: String = "socks"
}