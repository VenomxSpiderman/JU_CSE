#include "ll.h"
#include <stdio.h>
void init_l(Node *cur) {
    cur->next = NULL;
}

int empty_l(Node *head) {
    return head->next == NULL;
}

int atend_l(Node *cur) {
    return cur->next == NULL;
}

void insert_front(Node *target, Node **head) {
    target->next = (*head)->next;
    (*head)->next = target;
}

void insert_after(Node *target, Node *prev) {
    target->next = prev->next;
    prev->next = target;
}

void delete_front(Node **head) {
    if (!empty_l(*head)) {
        Node *temp = (*head)->next;
        (*head)->next = temp->next;
        free(temp);
    }
}

void delete_after(Node *prev) {
    if (prev->next != NULL) {
        Node *temp = prev->next;
        prev->next = temp->next;
        free(temp);
    }
}