#Makefile
#Runs the list.c program
#Runs valgrind along with ./list when "make test" is typed

CC = gcc
CFLAGS = -std=c99 -Wall -Werror -Wfatal-errors -g
OBJS = list.o
OUTPUT = list

${OUTPUT}: ${OBJS}
	${CC}  $< -o ${OUTPUT}

%.o: %.c
	${CC} -c ${CFLAGS} $<

clean:
	rm -f *.o

spotless: clean
	rm -f ${OUTPUT}

test: ${OUTPUT}
	valgrind --leak-check=full ./${OUTPUT}

.PHONY: clean spotless test
