#!/bin/bash
# Tanvir_Rahman(19101268)

echo "Which operation would you like to do?"
read operator
if ! [ "$operator" == "+" ] || [ "$operator" == "-" ] || [ "$operator" == "/" ] || [ "$operator" == "*" ]; then
    echo "Invalid operator!"
else 
    echo "Operand 1: "
    read a
    echo "Operand 2: "
    read b
    re='^[0-9]+$'
    if ! [[ $a =~ $re && $b =~ $re ]]; then
        echo "Any of the number is invalid!"    
    else 
        result=$(($a $operator $b))
        echo "The result is" $result
    fi

fi