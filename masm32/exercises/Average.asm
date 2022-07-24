
  include \masm32\include\masm32rt.inc 

.code

start:
    call main
exit

main proc
    LOCAL var1:DWORD
    LOCAL var2:DWORD
    LOCAL var3:DWORD
    LOCAL var4:DWORD
    mov var1, sval(input("Nhap so thu nhat: "))
    mov var2, sval(input("Nhap so thu hai: "))
    mov var3, sval(input("Nhap so thu ba: "))
    print chr$("Tong 3 so = ")
    mov eax, var1
    mov ebx, var2
    mov ecx, var3
    add ebx, ecx
    add eax, ebx
    mov var4, eax
    print str$(var4)
    print chr$(13,10)
    
    print chr$("Trung binh 3 so = ")
    mov ebx,0
    mov eax, var4
    mov dl, 3
    idiv dl
    mov bl, al
    mov var4, eax
    print str$(ebx) ; in thuong so nguyen
    
    print chr$(".")  ; in phan thap phan
    mov eax, var4
    mov bl, ah
    mov eax, 0
    mov al, bl
    mov ebx, 0
    mov dl, 10
    imul dl
    mov dl, 3
    idiv dl
    mov bl, al
    print str$(ebx)
    
    ret
main endp

end start