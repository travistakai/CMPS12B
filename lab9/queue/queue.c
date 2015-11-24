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
   STUBPRINTF("return NULL\n");
   return NULL;
}

void queue_free(queue *this) {
   assert(queue_isempty(this));
   free(this);
}

void queue_insert(queue *this, queue_item_t item) {
   STUBPRINTF("item = \"%s\"\n", item);
}

queue_item_t queue_remove(queue *this) {
   assert(!queue_isempty(this));
   STUBPRINTF("return NULL\n");
   return NULL;
}

bool queue_isempty(queue *this) {
   return this->front == NULL;
}
