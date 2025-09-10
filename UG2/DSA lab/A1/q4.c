#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 100000

void generate_random_numbers(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
    }

    for (int i = n - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

int main() {
    int numbers[SIZE];
    FILE *file;

    srand(time(0));

    generate_random_numbers(numbers, SIZE);

    file = fopen("random_numbers.txt", "w");
    if (file == NULL) {
        printf("Error opening file!\n");
        return 1;
    }

    for (int i = 0; i < SIZE; i++) {
        fprintf(file, "%d\n", numbers[i]);
    }

    fclose(file);

    printf("100,000 random numbers generated and saved to 'random_numbers.txt'.\n");

    return 0;
}
