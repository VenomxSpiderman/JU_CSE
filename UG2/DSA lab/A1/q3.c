#include <stdio.h>

int linear_search_int(int arr[], int n, int key) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == key)
            return i;
    }
    return -1;
}
int linear_search_float(float arr[], int n, float key) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == key)
            return i;
    }
    return -1;
}
int linear_search_string(char *arr[], int n, char *key) {
    for (int i = 0; i < n; i++) {
        if (strcmp(arr[i], key) == 0)
            return i;
    }
    return -1;
}

int binary_search_int(int arr[], int n, int key) {
    int low = 0, high = n - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}
int binary_search_float(float arr[], int n, float key) {
    int low = 0, high = n - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}
int binary_search_string(char *arr[], int n, char *key) {
    int low = 0, high = n - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        int res = strcmp(arr[mid], key);
        if (res == 0)
            return mid;
        if (res < 0)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}

int main() {
    char *arr[] = {"apple", "banana", "cherry", "date", "fig"};
    int n = sizeof(arr) / sizeof(arr[0]);
    char key[] = "cherry";

    int result = binary_search_string(arr, n, key);
    if (result != -1)
        printf("Element %s found at index %d\n", key, result);
    else
        printf("Element %s not found\n", key);

    return 0;
}
