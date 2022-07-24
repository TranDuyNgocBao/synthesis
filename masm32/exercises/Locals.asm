.486                                    ; create 32 bit code
    .model flat, stdcall                    ; 32 bit memory model
    option casemap :none                    ; case sensitive
 
    include \masm32\include\windows.inc     ; always first
    include \masm32\macros\macros.asm       ; MASM support macros
    include \masm32\include\masm32.inc
    include \masm32\include\gdi32.inc
    include \masm32\include\user32.inc
    include \masm32\include\kernel32.inc
    includelib \masm32\lib\masm32.lib
    includelib \masm32\lib\gdi32.lib
    includelib \masm32\lib\user32.lib
    includelib \masm32\lib\kernel32.lib

    show_text PROTO :DWORD      ;  prototype a method + type of parameter

    .code                       ; Tell MASM where the code starts

start:                          ; The CODE entry point to the program
    call main                   ; branch to the "main" procedure
    exit

; ллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллл
main proc
    LOCAL txtinput:DWORD        ; a "handle" for the text returned by "input"
    mov txtinput, input("Type some text at the cursor : ") ; get input string
    invoke show_text, txtinput  ; show inputted string
    ret
main endp
; ллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллл
show_text proc string:DWORD
    print chr$("This is what you typed at the cursor",13,10,"     *** ")
    print string                ; show the string at the console
    print chr$(" ***",13,10)
    ret
show_text endp
; ллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллл
end start                       ; Tell MASM where the program ends
