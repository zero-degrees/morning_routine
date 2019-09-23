#!/bin/sh

usage() {
    cat <<EOM
Usage:
    ./$(basename $0) <temperature> <command code 1, command code 2, ...>

    temperature:
        "HOT" or "COLD"
    
    command codes:
        An optionally comma-separated list of integer command codes (1-8)
EOM
    exit 0
}

[ -z $1 ] && { usage; }

args="run $*"

sbt --warn "$args"