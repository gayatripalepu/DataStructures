#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
	int data;
	struct node *left,*right;
}node;
node *root=NULL;
node *insert(node *root,int data)
{
	int ch;
	if(root==NULL)
	{
		root=(node *)malloc(sizeof(node));
		root->data=data;
		root->left=NULL;
		root->right=NULL;
		return root;
	}
	else
	{
		printf("do you wish to insert at left or right");
		scanf("%d",&ch);
		if(ch==1)
		root->left=insert(root->left,data);
		else
		root->right=insert(root->right,data);
	}
	return root;
}

void inorder(node *root)
{
	if(root!=NULL)
	{
		inorder(root->left);
		printf("%3d",root->data);
		inorder(root->right);
	}
}
void preorder(node *root)
{
	if(root!=NULL)
	{
		printf("%3d",root->data);
		preorder(root->left);
		preorder(root->right);
	}
}
void postorder(node *root)
{
	if(root!=NULL)
	{
		postorder(root->left);
		postorder(root->right);
		printf("%3d",root->data);
	}
}
int main()
{
	root=insert(root,10);
	root=insert(root,20);
	root=insert(root,30);
	root=insert(root,40);
	inorder(root);
	printf("\n");
	preorder(root);
	printf("\n");
	postorder(root);
	return 1;
}
