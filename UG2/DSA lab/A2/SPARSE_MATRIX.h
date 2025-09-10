typedef struct {
    int row;
    int col;
    int value;
} Element;

typedef struct {
    int rows;
    int cols;
    int num_elements;
    Element *elements;
} SparseMatrix;
