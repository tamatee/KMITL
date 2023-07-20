#include<stdio.h>

int	main(void)
{
	int	a,b,c;
	printf("enter a number: ");
	scanf("%d", &a);
	printf("enter 2nd && 3rd number: ");
	scanf("%d %d", &b, &c);
	printf("summation: %d\n", a + b + c);
	return 0;
}
