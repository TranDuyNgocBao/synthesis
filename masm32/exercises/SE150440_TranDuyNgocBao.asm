include \masm32\include\masm32rt.inc


.code
start:
    call main
exit

main proc
    LOCAL var1:DWORD
    LOCAL var2:DWORD
    LOCAL result:DWORD
    LOCAL COUNT:DWORD
    LOCAL dem:DWORD

    mov var1, sval(input("Input number 1: "))
    mov var2, sval(input("Input number 2: "))

    mov eax, var1
    mov COUNT, eax
    mov eax, 0
    mov result, eax
    mov ecx, var2

CONTD:
    CMP COUNT, ecx
    jg STOP

    mov eax, result
    mov ebx, COUNT
    add eax, ebx
    mov result, eax

INC COUNT
JMP CONTD
STOP:
    print chr$("Sum = ")
    print str$(result)
    ret
main endp


end start