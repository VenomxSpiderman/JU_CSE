#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_NAME_LEN 100
#define NUM_PRIMES 8

int primes[NUM_PRIMES] = {1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049};

unsigned long long convert_to_large_integer(const char *str) {
    unsigned long long large_int = 0;
    while (*str) {
        large_int = large_int * 100 + (*str); 
        str++;
    }
    return large_int;
}

void compute_remainders(unsigned long long number) {
    printf("Number: %llu\n", number);

    char num_str[20];
    snprintf(num_str, sizeof(num_str), "%llu", number);
    int len = strlen(num_str);
    int half_len = len / 2;

    unsigned long long first_half = strtoull(num_str, NULL, 10);
    unsigned long long second_half = strtoull(num_str + half_len, NULL, 10);

    unsigned long long sum = first_half + second_half;
    printf("Sum of halves: %llu\n", sum);

    for (int i = 0; i < NUM_PRIMES; i++) {
        unsigned long long remainder = sum % primes[i];
        printf("Remainder when divided by %d: %llu\n", primes[i], remainder);
    }
}

int main() {
    char name[MAX_NAME_LEN], surname[MAX_NAME_LEN];

    printf("Enter your name: ");
    fgets(name, sizeof(name), stdin);
    name[strcspn(name, "\n")] = 0; 

    printf("Enter your surname: ");
    fgets(surname, sizeof(surname), stdin);
    surname[strcspn(surname, "\n")] = 0; 

    unsigned long long name_int = convert_to_large_integer(name);
    unsigned long long surname_int = convert_to_large_integer(surname);

    unsigned long long combined_int = name_int * 10000000000ULL + surname_int; 
    compute_remainders(combined_int);

    return 0;
}
