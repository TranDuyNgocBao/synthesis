include \masm32\include\masm32rt.inc

swap1 PROTO :DWORD, :DWORD

.code
start:
    call main
    exit

main proc
    LOCAL var1:DWORD
    LOCAL pVar1: DWORD
    LOCAL var2: DWORD
    LOCAL pVar2:DWORD

mov var1,sval(input("Enter number 1: "))
mov var2,sval(input("Enter number 2: "))

;get addresses of var1, var2 to pVar1,pVar2
    lea eax, var1
    mov pVar1, eax
    lea eax, var2
    mov pVar2, eax

print chr$("var1, address: ")
print str$(pVar1)
print chr$(", value: ")
print str$(var1)
print chr$(13,10)
print chr$("var2, address: ")
print str$(pVar2)
print chr$(", value: ")
print str$(var2)
print chr$(13,10)

;swap
    push eax ; store EAX to STACK
    push ebx ; stor EBX to STACK
    invoke swap1, var1, var2
    pop ebx ; restore EBX, EAX from STACK
    pop eax

; print result
print chr$("After swapping: ")
print str$(var1)
print chr$(", ")
print str$(var2)

ret

main endp

swap1 proc v1: DWORD, v2:DWORD

    print chr$("Argument 1, address: ")
    lea eax, v1
    print str$(eax)
    print chr$(", value: ")
    print str$(v1)
    print chr$(13,10)
    print chr$("Argument 2, address: ")
    lea eax, v2
    print str$(eax)
    print chr$(", value: ")
    print str$(v2)
    print chr$(13,10)
; swap
    mov eax, v1
    mov ebx, v2
    mov v1, ebx
    mov v2, eax
    ret
swap1 endp
end start

    









