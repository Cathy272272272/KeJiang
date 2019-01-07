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
// Computes an N x N julia set, storing the results in the 2D pixels matrix
// (pixel matrix allocated by caller, not within function)
void julia_set_serial( int N, int ** pixels){
  double dx, dy, cx, cy, zx, zy, tmp;
  int itr, max = N;
  dx = 3.0 / N;
  dy = 2.0 / N;
  cx = -0.7;
  cy = 0.26;
  for ( int i = 0; i < N; i++ ){
    for ( int j = 0; j < N; j++ ){
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
    julia_set_serial( 1000, a);
    t2 = omp_get_wtime();
    printf("time of serial is %f sec.\n", t2 - t1);
    save_integer_matrix(1000, a, "p5.csv");
}