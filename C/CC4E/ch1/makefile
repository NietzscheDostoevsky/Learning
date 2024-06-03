# compiler and flags 

CC = gcc
CFLAGS = -Wall -Wextra -g

#sources and object files 
SRCS = $(wildcard *.c)
OBJS = $(SRCS:.c=.o)
EXES = $(SRCS:.c=)

#default rule to build all executables 
all: $(EXES)

#pattern rule to build each executable from its correcponding object file
%: %.o
	$(CC) $(CFLAGS) -o $@ $<

# pattern rule to complile each source file into an object file
%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

# Clean rule to remove object files and executables 
clean:
	rm -f $(OBJS) $(EXES)

