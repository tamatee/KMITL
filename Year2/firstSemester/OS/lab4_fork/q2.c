#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>

int main(/*int ac, char **av*/)
{
	pid_t pid;
	int i = 0; //prevent garbage

	pid = fork();
	//if (pid < 0) exit(-1);
	if (pid > 0) {	//parent
		i = 1;
		printf("my copy of i is %d \n", i);
	}
	else {		//child
		i = 2;
		printf("my copy of i is %d \n\n", i);
	}
	
	wait(NULL);
	return 0;
}
