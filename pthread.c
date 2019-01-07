#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include <pthread.h>    /* POSIX Threads */
#include "omp.h"
typedef struct str_thdata
{
  int ** a;
  int idx;
  int n;
  int nthreads;
} thdata; 
// Saves an integer matrix of size N x N to file
void save_integer_matrix( int N, int ** pixels, char * fname ){
	FILE * fp = fopen(fname, "w");
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (j == N - 1) {
				fprintf(fp, "%d\n", pixels[i][j]);
			}
			else {
				fprintf(fp, "%d,", pixels[i][j]);
			}
		}
	}
	fclose(fp);
	return;
}
void *julia_set( void * t);
// Computes an N x N julia set, storing the results in the pixels matrix
// Using nthreads number of pthreads
// (pixel matrix allocated by caller, not within function)
void julia_set_pthreads( int N, int ** pixels, int nthreads ){
  int tn;
  pthread_t threads[nthreads];
  thdata t[nthreads];      
  for(tn=0;  tn<nthreads;  tn++) {  
    t[tn].a = pixels;
    t[tn].n = N;
    t[tn].nthreads = nthreads;
    t[tn].idx = tn;
    pthread_create(&threads[tn],  NULL,  julia_set,  (void *)&t[tn]);  
  }  
  for(tn=0;  tn<nthreads  ;  tn++)  {  pthread_join(threads[tn],  NULL);  }    
}
// Computes an N x N julia set, storing the results in the 2D pixels matrix
// (pixel matrix allocated by caller, not within function)
void *julia_set( void * t){
    int i, j,core, ** pixels, n, nthreads;
    thdata * data;
    data = (thdata*)t;
    pixels = data->a;
    n = data->n;
    core = data->idx;
    nthreads = data->nthreads;
  double dx, dy, cx, cy, zx, zy, tmp;
  int itr, max = n;
  dx = 3.0 / n;
  dy = 2.0 / n;
  cx = -0.7;
  cy = 0.26;
  for ( i = core * n / nthreads; i < (core + 1 ) * n / nthreads; i++ ){
    for ( j = 0; j < 1000; j++ ){
      zx = -1.5 + dx * i;
      zy = -1.0 + dy * j;
      itr = 0;
      while ( zx * zx + zy * zy < 4.0 && itr <= max ){
	tmp = zx * zx - zy * zy;
	zy = 2 * zx * zy + cy;
	zx = tmp + cx;
	itr++;
      }
      pixels[i][j] = itr;
    }
  }
}
int main(int argc, char **argv){
  int **a, *aptr;
  double t1, t2;
  int i,j;
  long n = 1000;
  srand(time(NULL)); 
  int nthread = atoi(argv[1]);
  a = (int **) malloc(n*sizeof(int*));
  aptr = (int *) malloc(n*n*sizeof(int));
  for ( i = 0; i < n; i++ ){
      a[i] = aptr;
      aptr += n;
    for (j=0;j<n;++j){
        a[i][j] = 0;
    }
}

    t1 = omp_get_wtime();
    julia_set_pthreads( 1000, a, nthread);
    t2 = omp_get_wtime();
    printf("time of pthread is %f sec.\n", t2 - t1);
    save_integer_matrix(1000, a, "p6.csv");
}