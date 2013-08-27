#include <iostream>
#include "CImg.h"
using namespace cimg_library;

int main(int argc, char *argv[]) {

  cimg::exception_mode(1);
  try {
    CImg<int> img(argv[1]);
    double* c = new double[3];
    double t = 0;
    int i = 0, n = 0;
    cimg_for(img,ptr,int) { ++n; }
    n /= 3;
    cimg_for(img,ptr,int) { c[i++ / n] += *ptr; }
    t = c[0] + c[1] + c[2];
    std::cout << std::fixed << (c[0] /= t) << "\n" << (c[1] /= t) << "\n" << (c[2] /= t) << std::endl;
    return 0;
  } 
  catch (CImgException &e) {
    return -1;
  }
}
