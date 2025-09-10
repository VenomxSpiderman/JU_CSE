#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int primes[8] = {1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049};

unsigned long long generate_large_integer() {
    return ((unsigned long long)rand() << 32) | rand();
}

unsigned long long compute_remainder(unsigned long long Li, int P) {
    return Li % P;
}

int main() {
    srand(time(0));  
    int num_large_integers = 10;
    unsigned long long large_integers[num_large_integers];

    for (int i = 0; i < num_large_integers; i++) {
        large_integers[i] = generate_large_integer();
    }

    FILE *file = fopen("remainder_table.txt", "w");
    if (file == NULL) {
        printf("Error opening file!\n");
        return 1;
    }

    fprintf(file, "Li\t\t");
    for (int i = 0; i < 8; i++) {
        fprintf(file, "R (P=%d)\t", primes[i]);
    }
    fprintf(file, "\n");

    for (int i = 0; i < num_large_integers; i++) {
        fprintf(file, "%llu\t", large_integers[i]);
        for (int j = 0; j < 8; j++) {
            unsigned long long remainder = compute_remainder(large_integers[i], primes[j]);
            fprintf(file, "%llu\t", remainder);
        }
        fprintf(file, "\n");
    }

    fclose(file);

    printf("Tabulation completed. Results saved to 'remainder_table.txt'.\n");

    return 0;
}
