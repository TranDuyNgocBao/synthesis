include \masm32\include\masm32rt.inc

sum PROTO :DWORD, :DWORD

.code
start:
    call main
exit

main proc
    LOCAL var1:DWORD
    LOCAL var2:DWORD
    LOCAL result:DWORD
    LOCAL COUNT:DWORD

    mov COUNT, sval(input("Input n: "))
    mov var1, 1
    mov var2, 0

CONTD:
    CMP COUNT, 0
    je STOP
    
    invoke sum, var1, var2
    mov result, eax
    mov var2, eax
    print str$(result)
    print chr$(13,10)
    
INC var1
DEC COUNT
JMP CONTD
STOP:
    ret
main endp

sum proc var1:DWORD, var2:DWORD
    mov eax, var1
    add eax, var2
    ret
sum endp
end start