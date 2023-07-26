#include<stdio.h>
#include<stdlib.h>

int main(int ac, char **av) {
    int sum = 0;
    while (*++av)
        sum += atoi(*av);
    printf("%d\n", sum);
}
