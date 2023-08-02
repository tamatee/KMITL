res=20
correct=10
wrong=7
comerr=5

for f in $(find . -type f -name "*.c")
	do
	p_name=$(echo "$f" | cut -d '.' -f 2 | cut -d '/' -f 2)
	gcc $f -o $p_name 2>/dev/null
	if [ -f $p_name ]
		then
		ans=$(./$p_name)
		if [ $ans = $res ]
			then
			score=$correct
		else
			score=$wrong
			fi
	else
		score=$comerr
		fi
	printf "%s\t%d\n" $p_name $score
done
