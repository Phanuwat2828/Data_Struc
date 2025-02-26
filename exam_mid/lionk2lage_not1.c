
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
void Add2Left(node *p,int data);
void Add2Right(node *p,int data);
void print();
int main(){
    int num[5];
    
    for(int i = 0; i < 5; i++) {
        scanf("%d", &num[i]);
    }
    node *p = malloc(sizeof(node));
    p->Data = num[0];
    p->LLink = NULL;
    p->RLink = NULL;
    head = last = p;
    print();
    Add2Left(p,num[1]);
    print();
    Add2Right(p,num[2]);
    print();
    Add2Left(p,num[3]);
    print();
    Add2Right(p,num[4]);
    print();
    return 0;
}
void Add2Left(node *p,int Data){
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
void Add2Right(node *p,int Data){
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
    p->RLink->LLink = Q;
    p->RLink = Q;
}
void print(){
    node *p = head;
    while(p != NULL){
        if(p->RLink==NULL){
            printf("%d",p -> Data);
        }else{
            printf("%d ",p -> Data);
        }
        p = p -> RLink;
    }
    printf("\n");
}

void print(){
    node *p = head;
    while(p != NULL){
        if(p->RLink==NULL){
            printf("%d",p -> Data);
        }else{
            printf("%d ",p -> Data);
        }
        p = p -> RLink;
    }
    printf("\n");
}