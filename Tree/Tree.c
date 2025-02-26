#include <stdio.h>
#include <stdlib.h>


struct TreeNode {
    int data;
    struct TreeNode *left;
    struct TreeNode *right;
}tree;


struct TreeNode* createNode(int data) {
    struct TreeNode *newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}


void binaryTree(struct TreeNode** root,int val){
    struct TreeNode* P = createNode(val);
    if(*root == NULL){
        *root = P;
        return;
    }
    struct TreeNode* temp = *root;
    struct TreeNode* prev = NULL;
    while (temp != NULL){
        prev = temp;
        if(P->data < temp->data){
            temp = temp->left;
        }else{
            temp = temp->right;
        }
    }
    if(P->data <prev->data){
        prev->left = P;
    }else{
        prev->right = P;
    }
   

}

void PreOrder(struct TreeNode* root){
    if(root!=NULL){
        printf("%d ",root->data);
        PreOrder(root->left);
        PreOrder(root->right);
    }
}

void  InOrder(struct TreeNode* root){
    if(root!=NULL){
        InOrder(root->left);
        printf("%d",root->data);
        InOrder(root->right);
    }
}

int main() {
    struct TreeNode *root = createNode(30);
    binaryTree(&root,2);
    binaryTree(&root,10);
    binaryTree(&root,-5);
    binaryTree(&root,20);
    binaryTree(&root,43);
    binaryTree(&root,11);
    printf("PreOrder: ");
    PreOrder(root);
    printf("\n");
    return 0;
}

