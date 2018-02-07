//-----------------------------------------------------------------------------
//Issei Mori
//1612406
//Implement LinkedList
//queue.c
//-----------------------------------------------------------------------------
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "queue.h"

//LinkedList
//Exported reference type
typedef struct LinkedListObj{
	struct NodeObj* head;
}LinkedListObj;

//Node
//Exported reference type
typedef struct NodeObj{
	struct NodeObj* next;
	int number;
}NodeObj;

//newLinkedList()
//Constructor for the newLinkedList type
LinkedList newLinkedList(){
	LinkedList list = malloc(sizeof(LinkedListObj));
	list->head = newNode('\0');
	list->head->next = NULL;
	
	return list;
}

//newNode()
//Constructor for the newNode type
Node newNode(int x){
	Node node = malloc(sizeof(NodeObj));
	node->number = x;
	node->next = NULL;
	return node;
}

//freeLinkedList()
//Destructor for the LinkedList type
void freeLinkedList(LinkedList* pS){
	Node tmp = (*pS)->head->next;
	Node copy = tmp;
	freeNode(&(*pS)->head);
	free(*pS);
	while(tmp != NULL){
		freeNode(&copy);
		copy = tmp->next;
		tmp = copy;
	}
}

//freeLinkedList()
//Destructor for the LinkedList type
void freeNode(Node* pS){
	if(pS != NULL && *pS != NULL){
		//printf("%d\n", (*pS)->number );
		free(*pS);
		*pS = NULL;
	}
}

//printLinkedList()
//Print a text representation of S to commandline
//void printLinkedList(FILE* out, LinkedList S){
void printLinkedList(FILE* out, LinkedList S){
	Node tmp = S->head->next;
	while(tmp != NULL){
		fprintf(out, "%d ", tmp->number);
		tmp = tmp->next;
	}
	fprintf(out, "\n");
}

//printLinkedList()
//Print a text representation of S to the file pointed to by out
void printLinkedListToFile(FILE* out, LinkedList S){
	Node tmp = S->head->next;
	while(tmp != NULL){
		fprintf(out, "%d ", tmp->number);
		tmp = tmp->next;
	}
	fprintf(out, "\n");
}

//insert()
//Insert numebr into LinkedList
void insert(int number, LinkedList S){
	Node latest = newNode(number);
	Node tmp = S->head;
	while(tmp->next != NULL){
		tmp = tmp->next;
	}
	tmp->next = latest;
}

//find()
//Find pointer to node containing number
//Return null if none exists
Node find(int number, LinkedList S){
	Node tmp = S->head->next;
	while(tmp != NULL){
		if(tmp->number == number){
			printf("%d\n", tmp->number);
			return tmp;
		}
		tmp = tmp->next;
	}
	return NULL;
}

//delete()
//Delete number from LinkedList
int delete(int number, LinkedList S){
	Node prev = NULL;
	Node curr = S->head->next;
	while(curr->number != number){
		prev = curr;
		curr = curr->next;
	}
	if(curr->next == NULL){
		prev->next = NULL;
		freeNode(&curr);
	}
	else if(curr == NULL) return 0;
	else if(prev == NULL){
		S->head = curr->next;
	}
	else{
		prev->next = curr->next;
	}
	int retVal = curr->number;
	freeNode(&curr);
	return retVal;
}

void deleteTop(FILE* out, LinkedList S){
	int num;
	if(S->head->next == NULL) fprintf(out, "empty\n");
	else if(S->head->next->next == NULL){
		num = S->head->next->number;
		freeNode(&S->head->next);
		fprintf(out, "%d\n", num);
	}else{
		Node tmp = S->head->next;
		num = S->head->next->number;
		S->head->next = S->head->next->next;
		freeNode(&tmp);
		fprintf(out, "%d\n", num);
	}
}