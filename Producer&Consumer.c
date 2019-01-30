#include <stdio.h>
#include <pthread.h>

#define BUFFERSIZE 24

void *producer(void *);
void *consumer(void *);

pthread_mutex_t consMutex;
pthread_mutex_t prodMutex;
pthread_cond_t  consCond;
pthread_cond_t  prodCond;

// Shared resource: Using it to store flags.
// If value at index is 0, it means the index is free
// and producer can write data. If it is 1, it means
// that index is filled, consumer can consume it.
// You need use separate array for actual data.
char buf[BUFFERSIZE] = {0};

int main(void)
{
   pthread_t thread1, thread2;

    pthread_mutex_init(&consMutex, NULL);
    pthread_mutex_init(&prodMutex, NULL);

    pthread_cond_init(&consCond, NULL);
    pthread_cond_init(&prodCond, NULL);

    int ret1, ret2;

    int prodIndex = 0;
    int consIndex = 0;

    ret1 = pthread_create(&thread1, NULL, producer, (void *)&prodIndex);
    ret2 = pthread_create(&thread2, NULL, consumer, (void *)&consIndex);

    printf("Main function after pthread create\n");

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    pthread_mutex_destroy(&prodMutex);
    pthread_mutex_destroy(&consMutex);

    pthread_cond_destroy(&prodCond);
    pthread_cond_destroy(&consCond);

    return 0;
}

void *producer(void *index)
{
    int *currentProduceIndex = index;
    while(1) {
        pthread_mutex_lock(&prodMutex);

        /* Check if current index is free to fill. */
        while(1 == buf[*currentProduceIndex])
        {
            /* If index is not free, wait for consumer to consume. */
            pthread_cond_wait(&prodCond, &prodMutex);
        }

        /* Now the current index is free. Fill it. */
        buf[*currentProduceIndex] = 1;

        /* Update the producer index. */
        *currentProduceIndex = (*currentProduceIndex+1)%BUFFERSIZE;
        pthread_mutex_unlock(&prodMutex);

        /* Notify consumer that an item has been produced. */
        pthread_mutex_lock(&consMutex);
        pthread_cond_signal(&consCond);
        pthread_mutex_unlock(&consMutex);
    }

    return NULL;
}

void *consumer(void *index)
{
    int *currentConsumeIndex = index;
    while(1) {

        pthread_mutex_lock(&consMutex);

        /* Check if current index is empty. */
        while(0 == buf[*currentConsumeIndex])
        {
            /* If index is empty, wait for producer to produce. */
            pthread_cond_wait(&consCond, &consMutex);
        }

        /* Index is filled, consume it. */
        buf[*currentConsumeIndex] = 0;

        /* Update the consumer index. */
        *currentConsumeIndex = (*currentConsumeIndex+1)%BUFFERSIZE;
        pthread_mutex_unlock(&consMutex);

        /* Notify producer that an item has been consumed. */
        pthread_mutex_lock(&prodMutex);
        pthread_cond_signal(&prodCond);
        pthread_mutex_unlock(&prodMutex);
    }

    return NULL;
}