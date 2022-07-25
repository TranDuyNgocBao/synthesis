# from abc import ABCMeta, abstractmethod
#
#
# class Book(object, metaclass=ABCMeta):
#     def __init__(self, title, author):
#         self.title = title
#         self.author = author
#
#     @abstractmethod
#     def display(self): pass
#
#
# # Write MyBook class
# class MyBook(Book):
#     def __init__(self, title, author, price):
#         super().__init__(title, author)
#         self.price = price
#
#     def display(self):
#         print('Title:', title)
#         print('Author:', author)
#         print('Price:', price)
#
#
# title = input()
# author = input()
# price = int(input())
# new_novel = MyBook(title, author, price)
# new_novel.display()
######################################################################################################################
# class Difference:
#     def __init__(self, a):
#         self.__elements = a
#
#     # Add your code here
#     maximumDifference = 0
#
#     def computeDifference(self):
#         self.__elements = sorted(self.__elements)
#         self.maximumDifference = abs(self.__elements[0] - self.__elements[len(self.__elements)-1])
#
# # End of Difference class
#
# _ = input()
# a = [int(e) for e in input().split(' ')]
#
# d = Difference(a)
# d.computeDifference()
#
# print(d.maximumDifference)
######################################################################################################################
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Solution:
    def display(self, head):
        current = head
        while current:
            print(current.data, end=' ')
            current = current.next

    def insert(self, head: Node, data):
        # Complete this method
        if head is None:
            return Node(data)
        else:
            current = head
            while current.next is not None:
                current = current.next
                continue
            current.next = Node(data)
            return head

mylist = Solution()
T = int(input())
head = None
for i in range(T):
    data = int(input())
    head = mylist.insert(head, data)
mylist.display(head)
