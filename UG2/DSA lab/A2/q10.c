#include <stdio.h>
#include <stdlib.h>

// Define the node structure
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Function prototypes
void printList(Node* head);
void printListReverse(Node* head);
int getSize(Node* head);
int areListsEqual(Node* head1, Node* head2);
Node* searchUnordered(Node** head, int key);
Node* searchOrdered(Node** head, int key);
void appendList(Node** head1, Node* head2);
void deleteNthNode(Node** head, int n);
void deleteFirstNode(Node** head);
void deleteLastNode(Node** head);
int isOrdered(Node* head);
Node* mergeSortedLists(Node* head1, Node* head2);
void insertAtBeginning(Node** head, int data);
void insertBeforeNode(Node** head, int target, int data);
void insertAtEnd(Node** head, int data);
void removeDuplicates(Node* head);
void swapPairs(Node* head);
void moveLastToFront(Node** head);
void deleteAlternateNodes(Node** head);
void rotateList(Node** head, int k);
void deleteList(Node** head);
void reverseList(Node** head);
void sortList(Node** head);

// Main function
int main() {
    Node* head = NULL;
    int choice, data, target, n, k;
    Node* head2 = NULL;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Print list\n");
        printf("2. Print list in reverse\n");
        printf("3. Get size of list\n");
        printf("4. Check if two lists are equal\n");
        printf("5. Search for a key in unordered list\n");
        printf("6. Search for a key in ordered list\n");
        printf("7. Append a list at the end of another list\n");
        printf("8. Delete nth node\n");
        printf("9. Delete first node\n");
        printf("10. Delete last node\n");
        printf("11. Check if list is ordered\n");
        printf("12. Merge two sorted lists\n");
        printf("13. Insert at beginning\n");
        printf("14. Insert before a specified node\n");
        printf("15. Insert at end\n");
        printf("16. Remove duplicates\n");
        printf("17. Swap elements pairwise\n");
        printf("18. Move last element to front\n");
        printf("19. Delete alternate nodes\n");
        printf("20. Rotate list\n");
        printf("21. Delete list\n");
        printf("22. Reverse list\n");
        printf("23. Sort list\n");
        printf("24. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printList(head);
                break;
            case 2:
                printListReverse(head);
                break;
            case 3:
                printf("Size of list: %d\n", getSize(head));
                break;
            case 4:
                printf("Enter elements for second list (terminate with -1):\n");
                head2 = NULL;
                while (1) {
                    scanf("%d", &data);
                    if (data == -1) break;
                    insertAtEnd(&head2, data);
                }
                if (areListsEqual(head, head2)) {
                    printf("Lists are equal\n");
                } else {
                    printf("Lists are not equal\n");
                }
                deleteList(&head2);
                break;
            case 5:
                printf("Enter key to search: ");
                scanf("%d", &data);
                if (searchUnordered(&head, data)) {
                    printf("Key found and deleted\n");
                } else {
                    printf("Key not found\n");
                }
                break;
            case 6:
                printf("Enter key to search: ");
                scanf("%d", &data);
                if (searchOrdered(&head, data)) {
                    printf("Key found and deleted\n");
                } else {
                    printf("Key not found\n");
                }
                break;
            case 7:
                printf("Enter elements for second list (terminate with -1):\n");
                head2 = NULL;
                while (1) {
                    scanf("%d", &data);
                    if (data == -1) break;
                    insertAtEnd(&head2, data);
                }
                appendList(&head, head2);
                break;
            case 8:
                printf("Enter position to delete: ");
                scanf("%d", &n);
                deleteNthNode(&head, n);
                break;
            case 9:
                deleteFirstNode(&head);
                break;
            case 10:
                deleteLastNode(&head);
                break;
            case 11:
                if (isOrdered(head)) {
                    printf("List is ordered\n");
                } else {
                    printf("List is not ordered\n");
                }
                break;
            case 12:
                printf("Enter elements for second list (terminate with -1):\n");
                head2 = NULL;
                while (1) {
                    scanf("%d", &data);
                    if (data == -1) break;
                    insertAtEnd(&head2, data);
                }
                head = mergeSortedLists(head, head2);
                break;
            case 13:
                printf("Enter data to insert: ");
                scanf("%d", &data);
                insertAtBeginning(&head, data);
                break;
            case 14:
                printf("Enter target node data: ");
                scanf("%d", &target);
                printf("Enter data to insert: ");
                scanf("%d", &data);
                insertBeforeNode(&head, target, data);
                break;
            case 15:
                printf("Enter data to insert: ");
                scanf("%d", &data);
                insertAtEnd(&head, data);
                break;
            case 16:
                removeDuplicates(head);
                break;
            case 17:
                swapPairs(head);
                break;
            case 18:
                moveLastToFront(&head);
                break;
            case 19:
                deleteAlternateNodes(&head);
                break;
            case 20:
                printf("Enter number of rotations: ");
                scanf("%d", &k);
                rotateList(&head, k);
                break;
            case 21:
                deleteList(&head);
                break;
            case 22:
                reverseList(&head);
                break;
            case 23:
                sortList(&head);
                break;
            case 24:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }

    return 0;
}

void printList(Node* head) {
    Node* current = head;
    while (current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

void printListReverse(Node* head) {
    if (head == NULL) return;
    printListReverse(head->next);
    printf("%d -> ", head->data);
}

int getSize(Node* head) {
    int size = 0;
    Node* current = head;
    while (current != NULL) {
        size++;
        current = current->next;
    }
    return size;
}

int areListsEqual(Node* head1, Node* head2) {
    while (head1 != NULL && head2 != NULL) {
        if (head1->data != head2->data) return 0;
        head1 = head1->next;
        head2 = head2->next;
    }
    return head1 == NULL && head2 == NULL;
}

Node* searchUnordered(Node** head, int key) {
    Node* current = *head;
    Node* prev = NULL;
    while (current != NULL) {
        if (current->data == key) {
            if (prev == NULL) {
                *head = current->next;
            } else {
                prev->next = current->next;
            }
            free(current);
            return *head;
        }
        prev = current;
        current = current->next;
    }
    return NULL;
}

Node* searchOrdered(Node** head, int key) {
    Node* current = *head;
    Node* prev = NULL;
    while (current != NULL && current->data <= key) {
        if (current->data == key) {
            if (prev == NULL) {
                *head = current->next;
            } else {
                prev->next = current->next;
            }
            free(current);
            return *head;
        }
        prev = current;
        current = current->next;
    }
    return NULL;
}

void appendList(Node** head1, Node* head2) {
    if (*head1 == NULL) {
        *head1 = head2;
        return;
    }
    Node* current = *head1;
    while (current->next != NULL) {
        current = current->next;
    }
    current->next = head2;
}

void deleteNthNode(Node** head, int n) {
    if (*head == NULL) return;
    Node* temp = *head;
    if (n == 0) {
        *head = temp->next;
        free(temp);
        return;
    }
    for (int i = 0; temp != NULL && i < n - 1; i++) {
        temp = temp->next;
    }
    if (temp == NULL || temp->next == NULL) return;
    Node* next = temp->next->next;
    free(temp->next);
    temp->next = next;
}

void deleteFirstNode(Node** head) {
    if (*head == NULL) return;
    Node* temp = *head;
    *head = (*head)->next;
    free(temp);
}

void deleteLastNode(Node** head) {
    if (*head == NULL) return;
    if ((*head)->next == NULL) {
        free(*head);
        *head = NULL;
        return;
    }
    Node* current = *head;
    while (current->next->next != NULL) {
        current = current->next;
    }
    free(current->next);
    current->next = NULL;
}

int isOrdered(Node* head) {
    if (head == NULL) return 1;
    while (head->next != NULL) {
        if (head->data > head->next->data) return 0;
        head = head->next;
    }
    return 1;
}

Node* mergeSortedLists(Node* head1, Node* head2) {
    if (head1 == NULL) return head2;
    if (head2 == NULL) return head1;
    if (head1->data < head2->data) {
        head1->next = mergeSortedLists(head1->next, head2);
        return head1;
    } else {
        head2->next = mergeSortedLists(head1, head2->next);
        return head2;
    }
}

void insertAtBeginning(Node** head, int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

void insertBeforeNode(Node** head, int target, int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    if (*head == NULL || (*head)->data == target) {
        newNode->next = *head;
        *head = newNode;
        return;
    }
    Node* current = *head;
    while (current->next != NULL && current->next->data != target) {
        current = current->next;
    }
    if (current->next == NULL) return;
    newNode->next = current->next;
    current->next = newNode;
}

void insertAtEnd(Node** head, int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    if (*head == NULL) {
        *head = newNode;
        return;
    }
    Node* current = *head;
    while (current->next != NULL) {
        current = current->next;
    }
    current->next = newNode;
}

void removeDuplicates(Node* head) {
    Node* current = head;
    while (current != NULL && current->next != NULL) {
        if (current->data == current->next->data) {
            Node* temp = current->next;
            current->next = current->next->next;
            free(temp);
        } else {
            current = current->next;
        }
    }
}

void swapPairs(Node* head) {
    Node* current = head;
    while (current != NULL && current->next != NULL) {
        int temp = current->data;
        current->data = current->next->data;
        current->next->data = temp;
        current = current->next->next;
    }
}

void moveLastToFront(Node** head) {
    if (*head == NULL || (*head)->next == NULL) return;
    Node* secondLast = NULL;
    Node* last = *head;
    while (last->next != NULL) {
        secondLast = last;
        last = last->next;
    }
    secondLast->next = NULL;
    last->next = *head;
    *head = last;
}

void deleteAlternateNodes(Node** head) {
    if (*head == NULL) return;
    Node* current = *head;
    while (current != NULL && current->next != NULL) {
        Node* temp = current->next;
        current->next = current->next->next;
        free(temp);
        current = current->next;
    }
}

void rotateList(Node** head, int k) {
    if (k == 0 || *head == NULL) return;
    Node* current = *head;
    int count = 1;
    while (count < k && current != NULL) {
        current = current->next;
        count++;
    }
    if (current == NULL) return;
    Node* kthNode = current;
    while (current->next != NULL) {
        current = current->next;
    }
    current->next = *head;
    *head = kthNode->next;
    kthNode->next = NULL;
}

void deleteList(Node** head) {
    Node* current = *head;
    Node* next;
    while (current != NULL) {
        next = current->next;
        free(current);
        current = next;
    }
    *head = NULL;
}

void reverseList(Node** head) {
    Node* prev = NULL;
    Node* current = *head;
    Node* next = NULL;
    while (current != NULL) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    *head = prev;
}

void sortList(Node** head) {
    if (*head == NULL || (*head)->next == NULL) return;
    Node* sorted = NULL;
    Node* current = *head;
    while (current != NULL) {
        Node* next = current->next;
        if (sorted == NULL || sorted->data >= current->data) {
            current->next = sorted;
            sorted = current;
        } else {
            Node* temp = sorted;
            while (temp->next != NULL && temp->next->data < current->data) {
                temp = temp->next;
            }
            current->next = temp->next;
            temp->next = current;
        }
        current = next;
    }
    *head = sorted;
}