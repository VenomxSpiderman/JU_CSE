#ifndef LIST_H
#define LIST_H

#define MAX_SIZE 100

typedef struct {
    int data[MAX_SIZE];
    int size;
} List;

void initList(List *list);
int isEmpty(List *list);
int isFull(List *list);
void insert(List *list, int element, int position);
void delete(List *list, int position);
int getElement(List *list, int position);
void display(List *list);

#endif
#include <stdio.h>
#include <stdlib.h>
void initList(List *list) {
list->size = 0;
}

int isEmpty(List *list) {
return list->size == 0;
}

int isFull(List *list) {
return list->size == MAX_SIZE;
}

void insert(List *list, int element, int position) {
if (isFull(list)) {
    printf("List is full\n");
    return;
}
if (position < 0 || position > list->size) {
    printf("Invalid position\n");
    return;
}
for (int i = list->size; i > position; i--) {
    list->data[i] = list->data[i - 1];
}
list->data[position] = element;
list->size++;
}

void delete(List *list, int position) {
if (isEmpty(list)) {
    printf("List is empty\n");
    return;
}
if (position < 0 || position >= list->size) {
    printf("Invalid position\n");
    return;
}
for (int i = position; i < list->size - 1; i++) {
    list->data[i] = list->data[i + 1];
}
list->size--;
}

int getElement(List *list, int position) {
if (position < 0 || position >= list->size) {
    printf("Invalid position\n");
    return -1;
}
return list->data[position];
}

void display(List *list) {
if (isEmpty(list)) {
    printf("List is empty\n");
    return;
}
for (int i = 0; i < list->size; i++) {
    printf("%d ", list->data[i]);
}
printf("\n");
}