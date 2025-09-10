#include<SPARSE_MATRIX.h>
#include <stdio.h>
#include <stdlib.h>
SparseMatrix* createSparseMatrix(int rows, int cols, int num_elements) {
    SparseMatrix *matrix = (SparseMatrix*)malloc(sizeof(SparseMatrix));
    matrix->rows = rows;
    matrix->cols = cols;
    matrix->num_elements = num_elements;
    matrix->elements = (Element*)malloc(num_elements * sizeof(Element));
    return matrix;
}

void destroySparseMatrix(SparseMatrix *matrix) {
    free(matrix->elements);
    free(matrix);
}

void setElement(SparseMatrix *matrix, int row, int col, int value) {
    for (int i = 0; i < matrix->num_elements; i++) {
        if (matrix->elements[i].row == row && matrix->elements[i].col == col) {
            matrix->elements[i].value = value;
            return;
        }
    }
    matrix->elements[matrix->num_elements].row = row;
    matrix->elements[matrix->num_elements].col = col;
    matrix->elements[matrix->num_elements].value = value;
    matrix->num_elements++;
}

int getElement(SparseMatrix *matrix, int row, int col) {
    for (int i = 0; i < matrix->num_elements; i++) {
        if (matrix->elements[i].row == row && matrix->elements[i].col == col) {
            return matrix->elements[i].value;
        }
    }
    return 0;
}

void displaySparseMatrix(SparseMatrix *matrix) {
    for (int i = 0; i < matrix->num_elements; i++) {
        printf("Row: %d, Col: %d, Value: %d\n", matrix->elements[i].row, matrix->elements[i].col, matrix->elements[i].value);
    }
}