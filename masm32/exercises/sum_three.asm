include \masm32\include\masm32rt.inc
.code

start:
    call main
exit

main proc
    LOCAL var1:DWORD
    LOCAL var2:DWORD
    LOCAL var3:DWORD
    mov var1, sval(input("Nhap so thu nhat: "))
    mov var2, sval(input("Nhap so thu hai: "))
    print chr$("Tong 2 so = ")
    mov eax, var1
    mov ebx, var2
    add eax, ebx
    mov var3, eax
    print str$(var3)
    ret
main endp

end start