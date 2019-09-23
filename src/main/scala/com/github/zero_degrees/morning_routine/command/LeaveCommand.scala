package com.github.zero_degrees.morning_routine.command

import com.github.zero_degrees.morning_routine.Temperature
import com.github.zero_degrees.morning_routine.Temperature._

case class LeaveCommand() extends Command {
    protected val validTemperatures: List[Temperature] = List(Hot, Cold)
    protected val incompatibleCommands: List[Command] = List()
    protected val hotPrerequisiteCommands: List[Command] = List(
        new FootwearCommand,
        new HeadwearCommand,
        new ShirtCommand,
        new PantsCommand,
        new PajamasCommand
    )
    protected val coldPrerequisiteCommands: List[Command] = List(
        new FootwearCommand,
        new HeadwearCommand,
        new SocksCommand,
        new ShirtCommand,
        new JacketCommand,
        new PantsCommand,
        new PajamasCommand
    )
    protected val hotMessage: String = "leaving house"
    protected val coldMessage: String = "leaving house"
}