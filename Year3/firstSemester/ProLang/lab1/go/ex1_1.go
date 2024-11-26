package main

import "fmt"

func main() {
	var fahrenheit float64
	fmt.Print("enter degree in fahrenheit ")
	fmt.Scanf("%f", &fahrenheit)
	var celcius = (fahrenheit - 32) * 5 / 9
	fmt.Println(fahrenheit, " fahrenheit =", celcius, " celcius")
}
