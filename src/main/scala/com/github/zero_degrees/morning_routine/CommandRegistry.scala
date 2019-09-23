package com.github.zero_degrees.morning_routine

import com.github.zero_degrees.morning_routine.command._

/**
 * Handles command lookup.
 */
object CommandRegistry {
    /**
     * Find the command that matches the code.
     * 
     * @param code A valid command code
     * 
     * @return
     */
    def findCommand(code: Int): Command =
        code match {
            case 1 =>
                new FootwearCommand
            case 2 =>
                new HeadwearCommand
            case 3 =>
                new SocksCommand
            case 4 =>
                new ShirtCommand
            case 5 =>
                new JacketCommand
            case 6 =>
                new PantsCommand
            case 7 =>
                new LeaveCommand
            case 8 =>
                new PajamasCommand
            case _ =>
                throw new IllegalArgumentException("Invalid command code")
        }
}