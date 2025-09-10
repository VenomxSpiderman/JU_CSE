#include "POLYNOMIAL.h"
#include <stdio.h>
#include <stdlib.h>
Polynomial* createPolynomial() {
    Polynomial *poly = (Polynomial*)malloc(sizeof(Polynomial));
    poly->head = NULL;
    return poly;
}

void addTerm(Polynomial *poly, int coeff, int exp) {
    Term *newTerm = (Term*)malloc(sizeof(Term));
    newTerm->coeff = coeff;
    newTerm->exp = exp;
    newTerm->next = NULL;

    if (poly->head == NULL || poly->head->exp < exp) {
        newTerm->next = poly->head;
        poly->head = newTerm;
    } else {
        Term *current = poly->head;
        while (current->next != NULL && current->next->exp > exp) {
            current = current->next;
        }
        if (current->exp == exp) {
            current->coeff += coeff;
            free(newTerm);
        } else {
            newTerm->next = current->next;
            current->next = newTerm;
        }
    }
}

Polynomial* addPolynomials(Polynomial *poly1, Polynomial *poly2) {
    Polynomial *result = createPolynomial();
    Term *t1 = poly1->head;
    Term *t2 = poly2->head;

    while (t1 != NULL && t2 != NULL) {
        if (t1->exp > t2->exp) {
            addTerm(result, t1->coeff, t1->exp);
            t1 = t1->next;
        } else if (t1->exp < t2->exp) {
            addTerm(result, t2->coeff, t2->exp);
            t2 = t2->next;
        } else {
            addTerm(result, t1->coeff + t2->coeff, t1->exp);
            t1 = t1->next;
            t2 = t2->next;
        }
    }

    while (t1 != NULL) {
        addTerm(result, t1->coeff, t1->exp);
        t1 = t1->next;
    }

    while (t2 != NULL) {
        addTerm(result, t2->coeff, t2->exp);
        t2 = t2->next;
    }

    return result;
}

Polynomial* multiplyPolynomials(Polynomial *poly1, Polynomial *poly2) {
    Polynomial *result = createPolynomial();
    for (Term *t1 = poly1->head; t1 != NULL; t1 = t1->next) {
        for (Term *t2 = poly2->head; t2 != NULL; t2 = t2->next) {
            addTerm(result, t1->coeff * t2->coeff, t1->exp + t2->exp);
        }
    }
    return result;
}

void displayPolynomial(Polynomial *poly) {
    Term *current = poly->head;
    while (current != NULL) {
        printf("%dx^%d", current->coeff, current->exp);
        current = current->next;
        if (current != NULL) {
            printf(" + ");
        }
    }
    printf("\n");
}

void freePolynomial(Polynomial *poly) {
    Term *current = poly->head;
    while (current != NULL) {
        Term *temp = current;
        current = current->next;
        free(temp);
    }
    free(poly);
}