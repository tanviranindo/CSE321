#!/bin/bash
# Tanvir_Rahman(19101268)

echo "Enter a number:"
read int
number=$int
arr=(0)
found=0
condition=0

while [ true ]; do
  if [ $int -eq 1 ]; then
    condition=1
    break
  elif [ $found -eq 1 ]; then
    condition=0
    break
  fi

  sum=0
  while [ $int -gt 0 ]; do
    sum=$((sum + (int % 10) * (int % 10)))
    int=$((int / 10))
  done
  int=$sum
  for i in ${arr[@]}; do
    if [ $i -eq $int ]; then
      found=1
      break
    fi
  done
  arr+=($int)
done

if [ $condition -eq 1 ]; then
  echo "$number is a Happy Prime."
else
  echo "$number is not a Happy Prime."
fi
