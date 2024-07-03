function my_sqrt(a, n, x)
    i = 0
    for i in i:n
        x = (x + a/x) / 2
	e = x - sqrt(2)
	print("t: $i")
	print("	err: $e")
	print("	sqrt: $x")
	println()
    end
end
my_sqrt(2, 10, 1)
