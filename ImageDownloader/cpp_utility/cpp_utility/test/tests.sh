#!/bin/bash

cd $(dirname $0)/..

V1=$(hist img/red2x2.jpg|tr -d '\n')

if [ "$V1" != "1.0000000.0000000.000000" ]; then
  echo "test1 failed: Got ${$V1}" >&2
  exit 1
fi

V2=$(hist img/fourpx.jpg|tr -d '\n')


if [ "$V2" != "0.3330220.3339550.333022" ]; then
  echo "test2 failed: Got ${$V2}" >&2
  exit 2
fi

echo "All tests passed!" >&2