
 
include \masm32\include\masm32rt.inc

.code
start:
    call main
    exit

main proc
    LOCAL var1: DWORD
    LOCAL var2: DWORD
    mov var1, sval(input("Enter number 1: "))
    mov var2, sval(input("Enter number 2: "))
    mov eax, var1
    mov ecx, var2
    add ecx, eax
    print chr$(ecx)

ret
main endp
end start