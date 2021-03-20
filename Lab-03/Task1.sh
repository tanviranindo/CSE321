# !/bin/bash
# Tanvir_Rahman(19101268)

echo "Enter a student ID"
read id

year=${id:0:2}
index=${id:2:1}
dept=${id:3:2}

digit=8
cseDepartment=1
session=(Spring Fall Summer)

if [ ${#id} -eq $digit ] && [ $dept -eq $cseDepartment ] && [ $index -lt 4 ]; then
    echo "The student is form the Dept. of CSE enrolled in ${session[$((index - 1))]} 20$year."
elif [ ${#id} -eq $digit ] && [ $dept -ne $cseDepartment ] && [ $index -lt 4 ]; then
    echo "The student is not from the Dept. of CSE."
else
    echo "Invalid BRACU ID."
fi

