#include<stdio.h>
const double Pi = 3.14;
#define circleArea(r) (Pi * r * r)

int main()
{
    float r;
    printf("Enter the radius of the circle: ");
    scanf("%f", &r);
    printf("The area of the circle is: %.2f\n", circleArea(r));
    return 0;
}