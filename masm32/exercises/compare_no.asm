
 
  include \masm32\include\masm32rt.inc
.code
start:
    call main
exit
main proc

    LOCAL var1:DWORD
    LOCAL var2:DWORD
    mov var1, sval(input())
    mov var2, sval(input())
    mov eax, var1               ; copy var1 to eax
    cmp eax, var2               ; CMP REG, VAR
    je equal                    ; jump if var1 is equal to 100 to "equal"
    jg bigger                   ; jump if var1 is greater than 100 to "bigger"
    jl smaller                  ; jump if var1 is less than 100 to "smaller"

  equal:
    print chr$("2 numbers you entered are equal.",13,10)
    jmp over

  bigger:
    print chr$("The number 1 you entered is greater than number 2",13,10)
    jmp over

  smaller:
    print chr$("The number 1 you entered is smaller than number 2",13,10)

  over:
    ret
main endp
; ллллллллллллллллллллллллллллллллллллллллллллл

end start                       ; Tell MASM where the program ends
