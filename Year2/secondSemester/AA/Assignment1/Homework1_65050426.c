#include <stdio.h>
#include <stdlib.h>

double sqrt(double n) {
    double x = n;
    double y = 1;
    double e = 0.000001;
    while (x - y > e) {
        x = (x + y) / 2;
        y = n / x;
    }
    return x;
}

double sq(double n) {
    return n * n;
}

double calculate(double a, double b, double c) {
    double x1, x2;
    if (a == 0) {
        x1 = -c / b;
        printf("x = %.2f\n", x1);
    } else {
        double sub = sq(b) - (4 * a * c);
        if (sub < 0) {
            printf("This calculation's result is \"a+bi\" form\n");
        } else {
            x1 = (-b + sqrt(sub)) / (2 * a);
            x2 = (-b - sqrt(sub)) / (2 * a);
            printf("x1 = %.2f , x2 = %.2f\n", x1, x2);
        }
    }
    return 1;
}
int main() {
    double *a = calloc(3, sizeof(double));
    int i = 0;

    printf("\nFill A, B, C to find x in 'Ax^2 + Bx + C = 0' form\n");
    while (i < 3) {
        printf("%c = ", 'A' + i);
        scanf("%lf", &a[i++]);
    }

    calculate(a[0], a[1], a[2]);

    free(a); 

    return 0;
}
