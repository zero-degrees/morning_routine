package org.scalatest.examples.freespec

import com.github.zero_degrees.morning_routine.Temperature

class TemperatureSpec extends BaseSpec {
    "The Temperature" - {
        "should be Hot when initialized from a \"HOT\" string" in {
            assert(Temperature.fromString("HOT") == Temperature.Hot)
        }
        
        "should be Cold when initialized from a \"COLD\" string" in {
            assert(Temperature.fromString("COLD") == Temperature.Cold)
        }
        
        "should complain when initialized from a nonsense string" in {
            assertThrows[IllegalArgumentException](Temperature.fromString("derp"))
        }
    }
}