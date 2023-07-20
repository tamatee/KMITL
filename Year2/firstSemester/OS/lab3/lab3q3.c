#include<stdio.h>

int	main(void)
{
	float sum = 0;
	int a = 0;
	int i = 0;
	while(1)
	{
		scanf("%d", &a);
		if (a == 0)
			break;
		sum += a;
		i++;
	}
	printf("sum: %.0f\n avg: %.2f", sum, sum/i);
}
