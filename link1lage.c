#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int Data;
    struct Node *Link;
}node;
node *head = NULL;
node *last = NULL;
node *temp = NULL;
void AddHead(int num);
void AddLast(int num);
void AddOrder(int num);
void Search(int num);
void CountList();
void print();
void DeleteHead();
void DeleteLast();
void DeleteByKey(int Key);

int main(){
    int num[3];
    scanf("%d",&num[0]);
    scanf("%d",&num[1]);
    scanf("%d",&num[2]);
    for(int i=0;i<3;i++){
        AddOrder(num[i]);
        print();
    }
    return 0;
}

void AddHead(int num){
    node *p = malloc(sizeof(node));
    p->Data = num;
    p->Link = NULL;
    if(head == NULL){
        p -> Link = head;
        last = p;
    }
    else{
        p -> Link = head;
    }
        head = p;
}
void AddLast(int num){
    node *p = malloc(sizeof(node));
    p -> Data = num;
    p -> Link = NULL;
    if(head == NULL){
        head = p;
        last = p;
    }else{
        last  -> Link = p;
        last = p;
    }
}
void AddOrder(int num){
    node *p = malloc(sizeof(node));
    p -> Data = num;
    p -> Link = NULL;
    if (head == NULL || p -> Data <= head -> Data){
        p -> Link = head;
        head = p;
        return;
    }
    temp = head;
    while(temp -> Link != NULL && temp -> Link -> Data <= p -> Data){
        temp = temp -> Link;
    }
    if(temp -> Link != NULL){
        p -> Link = temp -> Link;
    }
    temp -> Link = p;
    
}
void Search(int num){
    node *p = head;
    while(p != NULL){
        if(p -> Data == num){
            printf("Found :%d \n",num);
            return;
        }
        p = p -> Link;
    }
    printf("Not Found :%d \n",num);
}

void CountList(){
    node *p = head;
    int count = 0;
    while(p != NULL){
        count++;
        p = p -> Link;
    }
    printf("List Is :%d\n",count);
}


void print(){
    node *p = head;
    while(p != NULL){
        printf("%d ",p -> Data);
        p = p -> Link;
    }
    printf("\b\n");
}



void DeleteHead(){
    if(head==NULL){
        printf("Emtyp Link");
    }else{
        head = head->Link;
    }
}

void DeleateLast(){
    if(head==NULL){
        printf("Empty Linked");
    }
    while(temp -> Link -> Link != NULL){
        temp = temp->Link;
    }
    temp->Link =NULL;
}
void DeleteByKey(int key){
    if(head==NULL){
        printf("Empty Linked");
        return ;
    }
    temp = head;
    node *p = malloc(sizeof(node));
    while(temp ->Data != key && temp->Link != NULL){
        p = temp;
        temp = temp->Link;
    }
    if(temp->Data != key){
        printf("Data not Found\n");
        return;
    }
    if(temp==head){
        head = temp ->Link;
    }else{
        p->Link = temp->Link;
    }
}
