#!/bin/bash

echo "Enter an Integer"
read int

nsm () {
    ss=0
    a=1
    while [ $a -gt 0 ]
    do
        ss=$((ss+(a%10)*(a%10)))
        a=$((a/10))
    done
    return $a
}

isHappy () {
    s=$1
    f=$1
    while [ true ]
    do 
        nsm $s
        s=$?
        nsm $f
        tmp=$?
        nsm $tmp
        f=$?
        if [ $s -ne $f ];
        then    
            continue
        else
            break
        fi
    done
    if [ $s -eq 1 ];
    then 
        return 1
    else 
        return 0
    fi
}

nsm $int
b=$?
isHappy $b
c=$?
if [ $c -eq 1 ];
then 
    echo "Happy Prime"
else
    echo "Not Happy Prime"
fi