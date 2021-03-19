#!/bin/bash

echo "Which operation would you like to do?"
read operator
if [ "$operator" == "+" ] || [ "$operator" == "-" ] || [ "$operator" == "/" ] || [ "$operator" == "*" ];
then 
    echo "Operand 1: "
    read a
    echo "Operand 2: "
    read b
    result=$(($a $operator $b))
    echo "The result is $result"
else 
    echo "Invalid operator!"
fi