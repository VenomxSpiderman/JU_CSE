#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_NAME_LEN 100
#define MAX_CLASSMATES 100

// Function to find the smallest and largest names by length
void find_smallest_largest(char names[][MAX_NAME_LEN], int count, char *smallest, char *largest) {
    strcpy(smallest, names[0]);
    strcpy(largest, names[0]);

    for (int i = 1; i < count; i++) {
        if (strlen(names[i]) < strlen(smallest)) {
            strcpy(smallest, names[i]);
        }
        if (strlen(names[i]) > strlen(largest)) {
            strcpy(largest, names[i]);
        }
    }
}

// Function to sort names alphabetically
void sort_names(char names[][MAX_NAME_LEN], int count) {
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            if (strcmp(names[i], names[j]) > 0) {
                char temp[MAX_NAME_LEN];
                strcpy(temp, names[i]);
                strcpy(names[i], names[j]);
                strcpy(names[j], temp);
            }
        }
    }
}

int main() {
    FILE *file;
    char names[MAX_CLASSMATES][MAX_NAME_LEN];
    int count = 0;
    file = fopen("classmates.txt", "r");
    if (file == NULL) {
        printf("Error opening file!\n");
        return 1;
    }
    while (fgets(names[count], MAX_NAME_LEN, file)) {
        names[count][strcspn(names[count], "\n")] = 0;
        count++;
    }
    fclose(file);

    if (count == 0) {
        printf("No names found in the file.\n");
        return 1;
    }

    // Find the smallest and largest names by length
    char smallest[MAX_NAME_LEN], largest[MAX_NAME_LEN];
    find_smallest_largest(names, count, smallest, largest);

    printf("Smallest name: %s (Length: %lu)\n", smallest, strlen(smallest));
    printf("Largest name: %s (Length: %lu)\n", largest, strlen(largest));

    // Sort the names alphabetically
    sort_names(names, count);

    // Open a new file for writing sorted names
    file = fopen("sorted_classmates.txt", "w");
    if (file == NULL) {
        printf("Error opening file!\n");
        return 1;
    }

    // Write sorted names to the file
    for (int i = 0; i < count; i++) {
        fprintf(file, "%s\n", names[i]);
    }
    fclose(file);

    printf("Names sorted alphabetically and saved to 'sorted_classmates.txt'.\n");

    return 0;
}
