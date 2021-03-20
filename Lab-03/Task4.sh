#!/bin/bash
# Tanvir_Rahman(19101268)

echo "Enter a number"
read num

mul2=$(($num % 2))
mul3=$(($num % 3))

if [[ $mul2 = 0 && $mul3 = 0 ]]; then
  echo "Hello"
elif [[ $mul2 = 0 || $mul3 = 0 ]]; then
  echo "Nihao"
else
  echo "Hola"
fi
