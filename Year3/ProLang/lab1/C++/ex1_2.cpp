#include<iostream>
#include<stdio.h>
using namespace std;

int main()
{
    double farenheit, celsius;
	printf("enter degree in farenheit ");
    scanf("%lf", &farenheit);
    celsius = (farenheit - 32) * 5 / 9;
    printf("%lf farenheit = %lf celsius", farenheit, celsius);
    return 0;
}
