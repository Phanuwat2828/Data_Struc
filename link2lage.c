
#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int Data;
    struct Node *LLink;
    struct Node *RLink;
}node;
node *head = NULL;
node *last = NULL;
void add2lage(node *p,int data);
void add2lageR(node *p,int data);
void print();


int main(){
    int num = 0;
    node *p = malloc(sizeof(node));
    scanf("%d",&p->Data);
    p->LLink = NULL;
    p->RLink = NULL;
    head = last = p;
    print();
    scanf("%d",&num);
    
    print();
    add2lageR(last,2);
    print();
    return 0;
}

void add2lage(node *p,int Data){
    node *Q = malloc(sizeof(node));
    Q->Data = Data;
    Q->LLink = NULL;
    Q->RLink = NULL;
    if(head == NULL){
        head = last =Q;
        return;
    }
    if(p==head){
        Q->RLink=p;
        Q->LLink=Q;
        head = Q;
        return;
    }
    Q->LLink = p->LLink;
    Q->RLink = p;
    p->LLink->RLink = Q;
    p->LLink=Q;
}
void add2lageR(node *p,int Data){
    node *Q = malloc(sizeof(node));
    Q->Data = Data;
    Q->LLink = p;
    Q->RLink = p->RLink;
    if(head == NULL){
        head = last =Q;
        return;
    }
    if(p==last){
        Q->LLink = p;
        p->RLink = Q;
        last = Q;
        return;
    }
    Q->RLink = p->RLink;
    
    Q->LLink = p;
    Q->RLink->LLink = Q;
    last = Q;
}

void print(){
    node *p = head;
    while(p != NULL){
        printf("%d ",p -> Data);
        p = p -> RLink;
    }
    printf("\n");
}