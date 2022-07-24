include\masm32\include\masm32rt.inc
.code
start:
    call main
    exit
main proc
    LOCAL v1: DWORD
    LOCAL v2: DWORD
    LOCAL v3: DWORD
    
    mov v1, sval(input("Input u1: "))
    mov v2, sval(input("Input d: "))
    mov v3, sval(input("Input n: "))
    print chr$("The term at position ")
    print str$(v3)
    print chr$(" is U")
    print str$(v3)
    print chr$(" = ")
    
    mov ecx, v1
    mov eax, v2
    mov ebx, v3
    dec ebx
    imul ebx
    add ecx, eax
    
    print str$(ecx)
    ret
main endp
end start