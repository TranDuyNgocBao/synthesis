
  include \masm32\include\masm32rt.inc 

.code
start:
    call main
exit

main proc
    LOCAL v1:DWORD
    LOCAL v2:DWORD
    LOCAL var3:DWORD
    LOCAL var4:DWORD
    mov v1,sval(input("Enter number 1: "))
    mov v2,sval(input("Enter number 2: "))

    mov eax, v1
    mov ebx, v2
    add eax, ebx
    print str$(eax)
    print chr$(13,10)

    mov eax, v1
    mov ebx, v2
    sub eax, ebx
    print str$(eax)
    print chr$(13,10)

    mov eax, v1
    mov ebx, v2
    imul ebx
    print str$(eax)
    print chr$(13,10)
    
    mov edx, 0
    mov eax, v1
    mov ebx, v2
    idiv ebx
    print str$(eax)
    print chr$(13,10)
    ret

main endp
end start