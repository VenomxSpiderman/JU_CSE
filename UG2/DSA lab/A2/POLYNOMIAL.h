typedef struct Term {
    int coeff;
    int exp;
    struct Term *next;
} Term;

typedef struct Polynomial {
    Term *head;
} Polynomial;
