/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import station.Booking;
import station.Booking;
import station.Customer;
import station.Customer;
import station.Gas_station;
import station.Gas_station;
import station.Train;
import station.Train;
import station.Utils;
import station.Utils;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class LinkedListWritten<T> {

    public Node<T> head, tail;
    private int length = 0;

    public LinkedListWritten() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
        length = 0;
    }

    public void tostring() {
        if (isEmpty()) {
            System.out.println(" Empty");
        } else {
            Node<T> p = head;
            while (p != null) {
                System.out.print(" " + p.info);
                p = p.next;
            }
            System.out.println("");
        }
    }

    public int size() {
        return length;
    }

    public void addLast(T data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node<T> tmp = new Node(data, null);
            tail.next = tmp;
            tail = tmp;
        }
        length++;
    }

    public void addFirst(T data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node<T> tmp = new Node(data, null);
            tmp.next = head;
            head = tmp;
        }
        length++;
    }

    public void addMany(T[] arr) {
        for (T arr1 : arr) {
            addLast(arr1);
        }
    }

    public void addPos(int index, T data) {
        if (length == 0 && index != 0) {
            System.out.println("False");
        } else if (index < 0 || index > length) {
            System.out.println("False");
        } else if (index == 0) {
            addFirst(data);
        } else if (index == length) {
            addLast(data);
        } else {
            Node<T> p = head;
            int i = 0;
            while (p != null) {
                if (i == index) {
                    Node<T> tmp = new Node(data);
                    tmp.next = p.next;
                    p.next = tmp;
                    break;
                }
                i++;
                p = p.next;
            }
            length++;
        }
    }

    public T get(int index) {
        Node<T> p = head;
        int i = 0;
        while (p != null) {
            if (i == index) {
                return p.info;
            }
            i++;
            p = p.next;
        }
        return null;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println(" False");
        } else {
            head = head.next;
            length--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println(" False");
        } else {
            Node<T> p = head;
            while (p != null) {
                if (p.next == tail) {
                    p.next = null;
                    length--;
                    break;
                }
                p = p.next;
            }
        }
    }

    public void remove(int index) {
        if (isEmpty()) {
            System.out.println(" False");
        } else if (index < 0 || index > length - 1) {
            System.out.println(" False");
        } else if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            removeLast();
        } else {
            Node<T> p = head;
            int i = 0;
            while (p != null) {
                if (i + 1 == index) {
                    p.next = p.next.next;
                    length--;
                    break;
                }
                i++;
                p = p.next;
            }
        }
    }

    public Node<T> search(String val, int choice) {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> p = head;
            while (p != null) {
                String searc = Utils.getStrfromObj((Gas_station) p.info, choice);
                if (searc.equals(val)) {
                    return p;
                }
                p = p.next;
            }
        }
        return null;
    }

    public void dele(String xCode, int choice) {
        if (isEmpty()) {
            System.out.println("Cannot find xCode");
        } else {
            Node<T> p = head;
            int i = 0;
            while (p != null) {
                String searc = Utils.getStrfromObj((Gas_station) p.info, choice);
                if (searc.equals(xCode)) {
                    if (!Utils.repeatQuiz("Do you really want to delete? (1-yes || 2-no)")) {
                        System.out.println("Stop deleting");
                        return;
                    }
                    remove(i);
                    System.out.println("Deleted");
                    return;
                }
                i++;
                p = p.next;
            }
        }
        System.out.println("Cannot find XCode");
    }

    public void delexCode(String xCode) {
        if (size() <= 1) {
            System.out.println("False");
        } else {
            Node<T> p = head;
            int i = 0;
            while (p != null) {
                String searc = "";
                if (p.next != null) {
                    searc = Utils.getStrfromObj((Train) p.next.info, 1);
                }
                if (searc.equals(xCode)) {
                    if (!Utils.repeatQuiz("Do you really want to delete? (1-yes || 2-no)")) {
                        System.out.println("Stop deleting");
                        return;
                    }
                    remove(i);
                    System.out.println("Deleted");
                    return;
                }
                i++;
                p = p.next;
            }
        }
        System.out.println("Cannot find XCode");
    }

    public Node<T> mergeSort(Node<T> p) {
        if (p == null || p.next == null) {
            return p;
        }

        // get middle of the list
        Node<T> middle = getMiddle(p);
        Node<T> nextInfoMiddle = middle.next;

        middle.next = null;

        Node<T> left = mergeSort(p);

        Node<T> right = mergeSort(nextInfoMiddle);

        Node<T> sortedList = sortedMerge(left, right);

        return sortedList;
    }

    private Node<T> getMiddle(Node<T> head) {
        if (head == null) {
            return head;
        }

        Node<T> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node<T> sortedMerge(Node<T> a, Node<T> b) {
        Node<T> result = null;

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Train num1, num2;
        if (a.info instanceof Train || b.info instanceof Train) {
            num1 = (Train) a.info;
            num2 = (Train) b.info;
            if (num1.tcode.compareTo(num2.tcode) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
        }
        
        Customer num3, num4;
        if (a.info instanceof Customer || b.info instanceof Customer) {
            num3 = (Customer) a.info;
            num4 = (Customer) b.info;
            if (num3.ccode.compareTo(num4.ccode) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
        }
        
        Booking num5, num6;
        if (a.info instanceof Booking || b.info instanceof Booking) {
            num5 = (Booking) a.info;
            num6 = (Booking) b.info;
            
            if(Utils.book == true){
                if (num5.tcode.compareTo(num6.tcode) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
            }else{
                if (num5.ccode.compareTo(num6.ccode) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
            }
        }
        return result;
    }
}
