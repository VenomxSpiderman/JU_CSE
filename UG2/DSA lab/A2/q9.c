#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* create_node(int data) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->data = data;
    new_node->next = NULL;
    return new_node;
}

Node* Build_list(FILE* file) {
    Node* head = NULL;
    Node* tail = NULL;
    int value;

    while (fscanf(file, "%d", &value) != EOF) {
        Node* new_node = create_node(value);
        if (head == NULL) {
            head = new_node;
            tail = new_node;
        } else {
            tail->next = new_node;
            tail = new_node;
        }
    }

    return head;
}

Node* Build_list_reverse(FILE* file) {
    Node* head = NULL;
    int value;

    while (fscanf(file, "%d", &value) != EOF) {
        Node* new_node = create_node(value);
        new_node->next = head;
        head = new_node;
    }

    return head;
}

void Print_list(Node* head) {
    Node* current = head;
    while (current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

void Free_list(Node* head) {
    Node* current = head;
    Node* next_node;

    while (current != NULL) {
        next_node = current->next;
        free(current);
        current = next_node;
    }
}

int main() {
    FILE* file = fopen("input.txt", "r");
    if (file == NULL) {
        perror("Unable to open file");
        return 1;
    }

    Node* list = Build_list(file);
    printf("List in order:\n");
    Print_list(list);
    Free_list(list);
    fseek(file, 0, SEEK_SET);

    Node* reverse_list = Build_list_reverse(file);
    printf("List in reverse order:\n");
    Print_list(reverse_list);
    Free_list(reverse_list);

    fclose(file);
    return 0;
}