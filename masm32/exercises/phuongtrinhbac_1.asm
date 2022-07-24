include \masm32\include\masm32rt.inc

.code
start:

    call main
    exit

main proc
    LOCAL a:DWORD
    LOCAL b:DWORD

    print chr$("Solve equation ax + b = 0", 13, 10)
    mov a, sval(input("Enter a = "))
    mov b, sval(input("Enter b = "))

    mov ebx, a
    mov eax, b

    cmp ebx, 0
    je aZero
    jnge aNZero
    jnle aNZero

    aZero:
        cmp eax, 0
        je bZero
        jnge bNZero
        jnle bNZero

    bZero:
        print chr$("Infinitely many solutions.", 13, 10)
        jmp over

    bNZero:
        print chr$("No solution!", 13, 10)
        jmp over
    aNZero:
        print chr$("x = ")
        mov edx, 0

        idiv ebx
        neg eax
        print str$(eax)
        print chr$(13, 10)
        jmp over

    over:
        ret


main endp


end start