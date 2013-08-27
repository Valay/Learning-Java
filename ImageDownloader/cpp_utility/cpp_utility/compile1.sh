#!/bin/bash

cd $(dirname $0)

rm hist 2>/dev/null

# Requires linking to X11 because CImg lib refers to X11 functions.
g++ -I/opt/local/include -L/usr/X11/lib -o hist hist.cpp -lpthread -lX11
