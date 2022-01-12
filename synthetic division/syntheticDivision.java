import java.util.Scanner;
import java.util.ArrayList;

public class syntheticDivision {
  public static void main(String[] args) {
    //c for coefficients
    ArrayList<Integer> c = new ArrayList<Integer>();

    for (int i = 0; i < args.length; i++) {
        c.add(Integer.parseInt(args[i]));
    }

    //r for negative roots to test
    ArrayList<RationalNumber> r = new ArrayList<RationalNumber>();

    ArrayList<Integer> numerators = factor(c.get(c.size() - 1));
    ArrayList<Integer> denominators = factor(c.get(0));

    for (int i = 0; i < numerators.size(); i++) {
      for (int j = 0; j < denominators.size(); j++) {
        RationalNumber root = new RationalNumber(numerators.get(i), denominators.get(j));
        r.add(root);
      }
    }

    int x = r.size();
    for (int h = 0; h < x; h++) {
      r.add(r.get(h).multiply(new RationalNumber(-1, 1)));
    }

    System.out.println(r);
    System.out.println();

    for (int k = 0; k < r.size(); k++) {
      ArrayList<RationalNumber> answer = new ArrayList<RationalNumber>();
      answer.add(0, new RationalNumber(c.get(0), 1));

      for (int l = 1; l < c.size(); l++) {
        answer.add(new RationalNumber(c.get(l), 1).add(answer.get(l-1).multiply(r.get(k))));
      }

      System.out.print(r.get(k) + " | " + answer);

      if (answer.get(answer.size() - 1).getValue() == 0) {
        System.out.println(" -ROOT");
      } else {
        System.out.println();
      }
    }
  }

  private static ArrayList<Integer> factor(int n) {
    ArrayList<Integer> factors = new ArrayList<Integer>();
    n = Math.abs(n);
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        factors.add(i);
      }
    }
    System.out.println(factors);
    return factors;
  }
}
