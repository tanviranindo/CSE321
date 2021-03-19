#!/bin/bash

echo "Enter a number"
read num

mul3=$(($num%3))
mul2=$(($num%2))

if [[ $mul2 = 0 && $mul3 = 0 ]];
then echo "Hello"
elif [[ $mul2 = 0 || $mul3 = 0 ]];
then echo "Nihao" 
else
  echo "Hola"
fi