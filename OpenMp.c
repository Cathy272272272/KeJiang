#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include "omp.h"
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
// Computes an N x N julia set, storing the results in the pixels matrix
// Using nthreads number of OpenMP threads
// (pixel matrix allocated by caller, not within function)
void julia_set( int N, int ** pixels );
void julia_set_openmp( int N, int ** pixels, int nthreads ){
  omp_set_num_threads(nthreads);
  julia_set(N, pixels);
}
void julia_set( int N, int ** pixels ){
  int i,j;
  int itr, max = N;
  double dx, dy, cx, cy, zx, zy, tmp;
  dx = 3.0 / N;
  dy = 2.0 / N;
  cx = -0.7;
  cy = 0.26;
#pragma omp parallel shared(pixels) private(i,j,zx, zy, tmp, itr) 
{
#pragma omp for schedule(dynamic, 100)
  for ( i = 0; i < N; i++ ){
    for ( j = 0; j < N; j++ ){
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
    julia_set_openmp( 1000, a, nthread);
    t2 = omp_get_wtime();
    printf("time of openmp is %f sec.\n", t2 - t1);
    save_integer_matrix(1000, a, "p7.csv");
}