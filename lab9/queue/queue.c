//queue.c
//Queue c file that contains the ADT

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "queue.h"

#define STUBPRINTF(...) fprintf(stderr, __VA_ARGS__);

/* Internal implementation definitions */
struct queue_node {
   queue_item_t item;
   struct queue_node *link;
};

typedef struct queue_node queue_node;

struct queue {
   queue_node *front;
   queue_node *rear;
};

/* Functions */

queue *queue_new(void) {
   struct queue *n = malloc(sizeof(struct queue));
   n->front = n->rear = NULL;
   return n;
}

void queue_free(queue *this) {
   assert(queue_isempty(this));
   free(this);
}

void queue_insert(queue *this, queue_item_t item) {
   //STUBPRINTF("item = \"%s\"\n", item);
   if(!queue_isempty(this))
   {
     this->rear->link = (queue_node *)malloc(sizeof(struct queue_node));
     this->rear->link->item = item;
     this->rear = this->rear->link;
   }

   else
   {
     struct queue_node *n = (queue_node *)malloc(sizeof(struct queue_node));
     n->item = item;
     this->front = n;
     this->rear = this->front;
   }
}

queue_item_t queue_remove(queue *this) {
   assert(!queue_isempty(this));

   struct queue_node *n = this->front->link;
   queue_item_t t = this->front->item;
   free(this->front);
   this->front = n;
   return(t);
   
}

bool queue_isempty(queue *this) {
   return this->front == NULL;
}
