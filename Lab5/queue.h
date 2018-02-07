//-----------------------------------------------------------------------------
//Issei Mori
//1612406
//Header file for queue.c
//queue.h
//-----------------------------------------------------------------------------
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#ifndef _QUEUE_h_INCLUDE_
#define _QUEUE_h_INCLUDE_

#include <stdio.h>

//LinkedList
//Exported reference type
typedef struct LinkedListObj* LinkedList;

//Node
//Exported reference type
typedef struct NodeObj* Node;

//newNode()
//Constructor for the newNode type
Node newNode(int x);

//newLinkedList()
//Constructor for the newLinkedList type
LinkedList newLinkedList(void);

//freeLinkedList()
//Destructor for the LinkedList type
void freeLinkedList(LinkedList* pS);

//freeNode()
//Destructor for the Node type
void freeNode(Node* pS);

//printLinkedListToFile()
//Print a text representation of S to the file pointed to by out
void printLinkedListToFile(FILE* out, LinkedList S);

//printLinkedList()
//Print a text representation of S to commandline
void printLinkedList(FILE* out, LinkedList S);

//insert()
//Insert numebr into LinkedList
void insert(int number, LinkedList S);

//find()
//Find pointer to node containing number
//Return null if none exists
Node find(int number, LinkedList S);

//delete()
//Delete number from LinkedList
int delete(int number, LinkedList S);

//delete()
//Delete number from the top of the list
void deleteTop(FILE* out, LinkedList S);

#endif

