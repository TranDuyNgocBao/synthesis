/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author ADMIN
 */
public class MathOperation {

    private final int MAX_VAL = 999999999;

    public void summation(String num1, String num2) {
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            System.out.print("-");
            System.out.println(sumBig(num1, num2));
        } else if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            num1 = num1.substring(1);
            subtraction(num2, num1);
        } else if (num1.charAt(0) != '-' && num2.charAt(0) == '-') {
            num2 = num2.substring(1);
            subtraction(num1, num2);
        } else {
            System.out.println(sumBig(num1, num2));
        }
    }

    public void subtraction(String num1, String num2) {
        if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            num1 = num1.substring(1);
            System.out.print("-");
            System.out.println(sumBig(num1, num2));
        } else if (num1.charAt(0) != '-' && num2.charAt(0) == '-') {
            num2 = num2.substring(1);
            System.out.println(sumBig(num1, num2));
        } else if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            subtraction(num2, num1);
        } else {
            if (num1.length() > num2.length()) {
                System.out.println(subBig(num1, num2));
            } else if (num1.length() < num2.length()) {
                System.out.print("-");
                System.out.println(subBig(num2, num1));
            } else {
                if (comPareSameLength(num1, num2) < 0) {
                    System.out.print("-");
                    System.out.println(subBig(num2, num1));
                } else {
                    System.out.println(subBig(num1, num2));
                }
            }
        }
    }

    public void production(String num1, String num2) {
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            System.out.println(bigProduct(num1, num2));
        } else if (num1.charAt(0) != '-' && num2.charAt(0) != '-') {
            System.out.println(bigProduct(num1, num2));
        } else {
            System.out.print("-");
            if (num1.charAt(0) == '-') {
                num1 = num1.substring(1);
            } else {
                num2 = num2.substring(1);
            }
            System.out.println(bigProduct(num1, num2));
        }
    }
    
    public void division(String num1, int num2){
        if (num1.charAt(0) == '-' && num2<0) {
            num1 = num1.substring(1);
            num2 = num2*(-1);
            System.out.println(bigDivide(num1, num2));
        } else if (num1.charAt(0) == '-' && num2>0) {
            num1 = num1.substring(1);
            System.out.print("-");
            System.out.println(bigDivide(num1, num2));
        } else if (num1.charAt(0) != '-' && num2<0) {
            num2 = num2*(-1);
            System.out.print("-");
            System.out.println(bigDivide(num1, num2));
            
        } else {
            System.out.println(bigDivide(num1, num2));
        }
    }

    private int comPareSameLength(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return -1;
        } else if (num1.length() > num2.length()) {
            return 1;
        }
        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) - 48 > num2.charAt(i) - 48) {
                return 1;
            }
            if (num1.charAt(i) - 48 < num2.charAt(i) - 48) {
                return -1;
            }
        }
        return 0;
    }

    private String sumBig(String num1, String num2) {
        Stack_lib<Integer> n1 = new Stack_lib<>();
        Stack_lib<Integer> n2 = new Stack_lib<>();
        String result = "";
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        for (int i = 0; i < num1.length(); i++) {
            int tmp = num1.charAt(i) - 48;
            n1.push(tmp);
        }
        for (int i = 0; i < num2.length(); i++) {
            int tmp = num2.charAt(i) - 48;
            n2.push(tmp);
        }
        int r = 0;
        while (n1.size() > 0) {
            if (n2.size() > 0) {
                int p = n1.pop() + n2.pop() + r;
                if (p > 9) {
                    r = 1;
                } else {
                    r = 0;
                }
                result = p % 10 + result;
            } else if (n1.size() > 0) {
                int p = n1.pop() + r;
                if (p > 9) {
                    r = 1;
                } else {
                    r = 0;
                }
                result = p % 10 + result;
            }
        }
        if (r != 0) {
            result = r + result;
        }
        return result;
    }

    private String subBig(String num1, String num2) {
        Stack_lib<Integer> n1 = new Stack_lib<>();
        Stack_lib<Integer> n2 = new Stack_lib<>();
        String result = "";
        for (int i = 0; i < num1.length(); i++) {
            int tmp = num1.charAt(i) - 48;
            n1.push(tmp);
        }
        for (int i = 0; i < num2.length(); i++) {
            int tmp = num2.charAt(i) - 48;
            n2.push(tmp);
        }

        int r = 0;
        while (n1.size() > 0) {
            if (n2.size() > 0) {
                int p = n1.pop() - n2.pop() - r;
                if (p >= 0) {
                    r = 0;
                } else {
                    p = 10 + p;
                    r = 1;
                }
                result = p + result;
            } else if (n1.size() > 0) {
                int p = n1.pop() - r;
                if (p >= 0) {
                    r = 0;
                } else {
                    p = 10 + p;
                    r = 1;
                }
                result = p + result;
            }
        }
        while (result.charAt(0) - 48 == 0) {
            result = result.substring(1);
            if (result.length() == 1) {
                break;
            }
        }
        return result;
    }

    private String productBigAndSmall(String num1, int num2) {
        Stack_lib<Integer> n1 = new Stack_lib<>();
        for (int i = 0; i < num1.length(); i++) {
            int tmp = num1.charAt(i) - 48;
            n1.push(tmp);
        }

        String result = "";
        int r = 0;
        while (n1.size() > 0) {
            int p = n1.pop() * num2 + r;
            r = p / 10;
            p = p % 10;
            result = p + result;
        }
        if (r != 0) {
            result = r + result;
        }
        return result;
    }

    private String bigProduct(String num1, String num2) {
        Stack_lib<Integer> n2 = new Stack_lib<>();
        String result = "";
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        for (int i = 0; i < num2.length(); i++) {
            int tmp = num2.charAt(i) - 48;
            n2.push(tmp);
        }

        String p = "0";
        while (n2.size() > 0) {
            p = sumBig(p, productBigAndSmall(num1, n2.pop()));
            int lnt = p.length();
            result = p.charAt(lnt - 1) + result;
            p = p.substring(0, lnt - 1);
        }
        result = p + result;
        while (result.charAt(0) - 48 == 0) {
            result = result.substring(1);
            if (result.length() == 1) {
                break;
            }
        }
        return result;
    }

    private String bigDivide(String num, int div) {
        if (div > MAX_VAL) {
            return "Divisor is oversized";
        }
        if(div == 0)return "False";
        Stack_lib<Integer> n = new Stack_lib<>();
        for (int i = num.length() - 1; i >= 0; i--) {
            int tmp = num.charAt(i) - 48;
            n.push(tmp);
        }

        String result = "";
        String p = "";
        String divi = "";
        divi += div;
        int check = 0;
        while (n.size() > 0) {
            p += n.pop();
            if (check == 0) {
                while (comPareSameLength(p, divi) < 0 && n.size() > 0) {
                    p = productBigAndSmall(p, 10);
                    String tmp = "";
                    tmp += n.pop();
                    p = sumBig(p, tmp);
                }
                check++;
            } else if (n.size() > 0) {
                p = productBigAndSmall(p, 10);
                String tmp = "";
                tmp += n.pop();
                p = sumBig(p, tmp);
            }
            int p_divi = 0;
            for (int i = 0; i < p.length(); i++) {
                p_divi = p_divi * 10 + (p.charAt(i) - 48);
            }
            int res = p_divi / div;
            result += res;
            int sub = p_divi - res * div;
            p = "" + sub;
        }
        return result;
    }

}
