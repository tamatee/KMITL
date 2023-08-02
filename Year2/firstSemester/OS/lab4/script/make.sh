if [ $# -eq 0 ]
then
	echo "no arg"
fi
for i in "$#";
do
	touch "q$i.sh";
done
