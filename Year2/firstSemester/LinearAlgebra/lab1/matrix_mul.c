#include <stdio.h>
#include <stdlib.h>

int **matrix_mul(int m, int n, int p, int **matrix_x, int **matrix_y) {
    int **result = malloc(m * sizeof(*result));
    register int i, j, k;
    for (i = 0; i < m; i++) {
        result[i] = calloc(p, sizeof(**result));
    }

    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            for (k = 0; k < p; k++) {
                result[i][j] += matrix_x[i][k] * matrix_y[k][j];
            }
        }
    }
    return (result);
}

int main() {
    int i, j;
    int n = 3;
    int **myArray;
    myArray = (int **) malloc(n * sizeof(int *));
    for (i = 0; i < n; i++)
        myArray[i] = (int *) malloc(sizeof(int));
    printf("Insert data:\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++) {
            scanf("%d", &*(*(myArray + i) + j));
        }

    myArray = matrix_mul(3, 3, 3, myArray, myArray);
    printf("The introduced Array:\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++)
            printf("%d ", *(*(myArray + i) + j));
        printf("\n");
    }
    printf("\n");
    {
    }
    for (i = 0; i < n; i++)
        free(myArray[i]);
    free(myArray);
}
