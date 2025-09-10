#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>

#define MAX_KEYWORDS 100
#define MAX_FILES 6
#define MAX_FILENAME 100
#define MAX_WORD_LENGTH 50

typedef struct {
    char filename[MAX_FILENAME];
    int count;
} FileCount;

typedef struct {
    char keyword[MAX_WORD_LENGTH];
    FileCount files[MAX_FILES];
    int fileCount;
} InvertedIndex;

void addToIndex(InvertedIndex *index, int *indexSize, const char *keyword, const char *filename) {
    for (int i = 0; i < *indexSize; i++) {
        if (strcmp(index[i].keyword, keyword) == 0) {
            for (int j = 0; j < index[i].fileCount; j++) {
                if (strcmp(index[i].files[j].filename, filename) == 0) {
                    index[i].files[j].count++;
                    return;
                }
            }
            strcpy(index[i].files[index[i].fileCount].filename, filename);
            index[i].files[index[i].fileCount].count = 1;
            index[i].fileCount++;
            return;
        }
    }
    strcpy(index[*indexSize].keyword, keyword);
    strcpy(index[*indexSize].files[0].filename, filename);
    index[*indexSize].files[0].count = 1;
    index[*indexSize].fileCount = 1;
    (*indexSize)++;
}

void processFile(InvertedIndex *index, int *indexSize, const char *filename, char keywords[MAX_KEYWORDS][MAX_WORD_LENGTH], int keywordCount) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        perror("Error opening file");
        return;
    }

    char word[MAX_WORD_LENGTH];
    while (fscanf(file, "%s", word) != EOF) {
        for (int i = 0; i < keywordCount; i++) {
            if (strcmp(word, keywords[i]) == 0) {
                addToIndex(index, indexSize, keywords[i], filename);
            }
        }
    }

    fclose(file);
}

void printIndex(InvertedIndex *index, int indexSize) {
    for (int i = 0; i < indexSize; i++) {
        printf("Keyword: %s\n", index[i].keyword);
        for (int j = 0; j < index[i].fileCount; j++) {
            printf("  File: %s, Count: %d\n", index[i].files[j].filename, index[i].files[j].count);
        }
    }
}

int main() {
    char keywords[MAX_KEYWORDS][MAX_WORD_LENGTH] = {"keyword1", "keyword2", "keyword3", "keyword4", "keyword5"};
    int keywordCount = 5;

    char *filenames[MAX_FILES] = {
        "file1.txt",
        "file2.txt",
        "file3.txt",
        "file4.txt",
        "file5.txt",
        "file6.txt"
    };

    InvertedIndex index[MAX_KEYWORDS];
    int indexSize = 0;

    for (int i = 0; i < MAX_FILES; i++) {
        processFile(index, indexSize, filenames[i], keywords, keywordCount);
    }

    printIndex(index, indexSize);

    return 0;
}