#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NAME_LENGTH 100
#define MAX_NAMES 1000

void sort_names(char names[][MAX_NAME_LENGTH], int count) {
    char temp[MAX_NAME_LENGTH];
    for (int i = 0; i < count - 1; ++i) {
        for (int j = i + 1; j < count; ++j) {
            if (strcmp(names[i], names[j]) > 0) {
                strcpy(temp, names[i]);
                strcpy(names[i], names[j]);
                strcpy(names[j], temp);
            }
        }
    }
}

void main() {
    FILE *input_file, *output_file;
    char names[MAX_NAMES][MAX_NAME_LENGTH];
    int count = 0;

    input_file = fopen("classmates.txt", "r");
    if (input_file == NULL) {
        printf("Unable to open input file\n");
        return;
    }

    while (fgets(names[count], MAX_NAME_LENGTH, input_file) != NULL) {
        names[count][strcspn(names[count], "\n")] = '\0';
        count++;
    }
    fclose(input_file);

    if (count == 0) {
        printf("No names found in the file.\n");
        return;
    }

    char *smallest_name = names[0];
    char *largest_name = names[0];
    int smallest_length = strlen(names[0]);
    int largest_length = strlen(names[0]);

    for (int i = 1; i < count; ++i) {
        int length = strlen(names[i]);
        if (strlen(names[i]) < strlen(smallest_name)) {
            smallest_name = names[i];
            smallest_length = length;
        }
        if (strlen(names[i]) > strlen(largest_name)) {
            largest_name = names[i];
            largest_length = length;
        }
    }

    printf("Smallest name: %s, Length: %d\n", smallest_name, smallest_length);
    printf("Largest name: %s, Length: %d\n", largest_name, largest_length);

    sort_names(names, count);

    output_file = fopen("sorted_classmates.txt", "w");
    if (output_file == NULL) {
        perror("Unable to open output file");
        return;
    }

    for (int i = 0; i < count; ++i) {
        fprintf(output_file, "%s\n", names[i]);
    }
    fclose(output_file);
}
