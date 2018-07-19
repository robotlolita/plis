# plis

A tiny call-by-value lambda calculus.

## Installation

Install [lein](https://leiningen.org/) and [Graal](https://www.graalvm.org/docs/getting-started/). This assumes a Linux environment.

## Building

    ./build.sh

## Usage

With Lein:

    lein run "((fn x x) 1)"

With the native binary:

    ./plis "((fn x x) 1)"
