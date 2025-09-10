#include <stdio.h>

int isAscen(int arr[], int n) {
    int i;

    for (i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return 0;
        }
    }
    return 1;
}
int isDes(int arr[], int n) {
    int i;

    for (i = 0; i < n - 1; i++) {
        if (arr[i] < arr[i + 1]) {
            return 0;
        }
    }

    return 1;
}

int main() {
     int n;
    printf("Enter the size of the array(positive value only and >1): ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter the elements of the array:\n");
    for (int i1 = 0; i1 < n; i1++) {
        scanf("%d",&arr[i1]);
    }
    if (isDes(arr, n)==1)
        printf("Array is sorted in Descending Order.\n");
    else if (isAscen(arr, n)==1)
        printf("Array is sorted in Ascending Order.\n");
    else  printf("Array is not sorted.\n");
    

    return 0;
}