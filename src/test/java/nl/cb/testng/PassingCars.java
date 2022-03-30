package nl.cb.testng;

// https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/

public class PassingCars {

  public int solution(int[] A) {

    long westCars = countWestCars(A);

    // exclude strange conditions
    if (westCars == 0 || westCars == A.length) {
      return 0;
    }

    long result = 0;
    int countedWestCars = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        result = result + westCars - countedWestCars;
      } else {
        countedWestCars++;
      }
    }

    // exclude excessive result
    if (result > 1000000000) {
      result = -1;
    }

    return (int) result;
  }

  private long countWestCars(int[] A) {
    int result = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 1) {
        result++;
      }
    }
    return result;
  }
}
