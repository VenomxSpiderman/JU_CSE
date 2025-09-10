// set.h
#ifndef SET_H
#define SET_H

#define MAX_SIZE 100

typedef struct {
    int elements[MAX_SIZE];
    int size;
} Set;

void initializeSet(Set *s);
int isElementOf(Set *s, int element);
void addElement(Set *s, int element);
void removeElement(Set *s, int element);
void displaySet(Set *s);

#endif // SET_H
#include <stdio.h>
#include "set.h"

void initializeSet(Set *s) {
    s->size = 0;
}

int isElementOf(Set *s, int element) {
    for (int i = 0; i < s->size; i++) {
        if (s->elements[i] == element) {
            return 1;
        }
    }
    return 0;
}

void addElement(Set *s, int element) {
    if (s->size < MAX_SIZE && !isElementOf(s, element)) {
        s->elements[s->size++] = element;
    }
}

void removeElement(Set *s, int element) {
    for (int i = 0; i < s->size; i++) {
        if (s->elements[i] == element) {
            s->elements[i] = s->elements[--s->size];
            return;
        }
    }
}

void displaySet(Set *s) {
    printf("{ ");
    for (int i = 0; i < s->size; i++) {
        printf("%d ", s->elements[i]);
    }
    printf("}\n");
}